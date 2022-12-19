package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Boolean running = true;

        do {

            HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();

            // Currency Code
            currencyCodes.put(1, "GTQ");
            currencyCodes.put(2, "GBP");
            currencyCodes.put(3, "doge");

            Integer from, to;
            String fromCode, toCode;
            double amount;

            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to the currency converter");

            System.out.println("currency converting From");
            System.out.println("1:GTQ (Guatemalan Quetzal) \t 2:GBP (British Pound) \t 3:doge (Doge)");
            from = sc.nextInt();
            while (from < 1 || from > 3) {
                System.out.println("Please select a valid currency(1-5");
                System.out.println("1:GTQ (Guatemalan Quetzal) \t 2:GBP (British Pound) \t 3:doge (Doge)");
                from = sc.nextInt();
            }
            fromCode = currencyCodes.get(from);


            System.out.println("currency converting To");
            System.out.println("1:GTQ (Guatemalan Quetzal) \t 2:GBP (British Pound) \t 3:doge (Doge)");
            to = sc.nextInt();
            while (from < 1 || from > 3) {
                System.out.println("Please select a valid currency(1-5");
                System.out.println("1:GTQ (Guatemalan Quetzal) \t 2:GBP (British Pound) \t 3:doge (Doge)");
                to = sc.nextInt();
            }
            toCode = currencyCodes.get(to);

            System.out.println("Amount you wish to convert");
            amount = sc.nextFloat();

            sendHttpGETRequest(fromCode, toCode, amount);

            System.out.println("Would you like to make another conversion?");
            System.out.println("1:Yes \t Any other key: N0");
            if(sc.nextInt() != 1){
                running = false;
            }



        }while(running);

        System.out.println("Thank you");


    }

    private  static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {
        String GET_URL = "https://pro-api.coinmarketcap.com/v1/exchange/market-pairs/latest?base" + toCode + "&symbols=" + fromCode;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine())!=null){
                response.append(inputLine);
            }in.close();

            JSONObject obj  = new JSONObject(response.toString());
            Double exchangeRate = obj.getJSONObject("rates").getDouble(fromCode);
            System.out.println(obj.getJSONObject("rates"));
            System.out.println(exchangeRate);
            System.out.println();
            System.out.println(amount + fromCode + " =" + amount/exchangeRate + toCode );
        }
        else{
            System.out.println("GET request failed");
        }



    }
}

