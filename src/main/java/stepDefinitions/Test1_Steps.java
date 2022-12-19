package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class Test1_Steps {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver1.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("I access the coinmarketcap web page")
    public void i_access_the_coinmarketcap_web_page() throws InterruptedException {
        driver.get("https://coinmarketcap.com/");


    }

    @When("I access the homepage I handle the alter windows")
    public void i_access_the_homepage_i_handle_the_alter_windows() throws InterruptedException {
        driver.findElement(By.cssSelector("body > div.sc-9de9f75d-0.kkwCna > div.sc-9de9f75d-2.gHDzMo > div.gv-close > svg")).click();
        driver.findElement(By.cssSelector("#__next > div > div.main-content > div.sc-1a736df3-0.PimrZ.cmc-body-wrapper > div > div.sc-daeb01fe-0.sc-daeb01fe-2.fIICuw > svg > path")).click();
        driver.findElement(By.cssSelector("#cmc-cookie-policy-banner > div.cmc-cookie-policy-banner__close")).click();
        driver.findElement(By.cssSelector("#__next > div > div.sc-c5c9d167-2.dwWUUU > div > div.buttons > button.sc-a4a6801b-0.ccMCCm")).click();

    }

    @And("I enter and I filter to see first 20 rows")
    public void i_enter_and_i_filter_to_see_first_rows(Integer int1) throws InterruptedException {
        driver.findElement(By.cssSelector(".jPLKhd.sc-aef7b723-0.table-control-page-sizer > .coScOT.sc-aef7b723-0.sc-dae82938-0 > .dgXMPo.sc-aef7b723-0")).click();

        driver.findElement(By.cssSelector(".dropdown-container.ezlhyG.sc-aef7b723-0.sc-f84d4cca-0 > button:nth-of-type(3)")).click();

        // Best code to use is below but for some reason it not responding in the DOM so I had to use two seperate clicks as seen above.
        //Select customize = new Select(driver.findElement(By.cssSelector(".jPLKhd.sc-aef7b723-0.table-control-page-sizer > .coScOT.sc-aef7b723-0.sc-dae82938-0")));
        //customize.selectByIndex(20);

    }


    @And("customise the page contents such as price in ETH,Price Change to 7d%, Supply\\(from Max supply to Total Supply) and leave the rest as default")
    public void customiseThePageContentsSuchAsPriceInETHPriceChangeToDSupplyFromMaxSupplyToTotalSupplyAndLeaveTheRestAsDefault(int arg0) {


        driver.findElement(By.cssSelector("span:nth-of-type(2) > .fvaoCA.gNHIvn.sc-22155b6a-13.sc-40630ce0-0.sc-a4a6801b-0.table_control_customize_button")).click();
        // Clicking on customize button


        driver.findElement(By.cssSelector(".giDSbC.sc-562372d2-4 > div:nth-of-type(1) > div:nth-of-type(2) > span:nth-of-type(2)")).click();
        //Clicking on ETH

        driver.findElement(By.cssSelector("[class] [class='sc-562372d2-8 eOkPCC']:nth-of-type(2) div:nth-of-type(2) span:nth-of-type(3)")).click();
        //Clicking on 7%

        driver.findElement(By.cssSelector("[class] [class='sc-562372d2-8 eOkPCC']:nth-of-type(5) div:nth-of-type(2) span:nth-of-type(2)")).click();
        //Clicking on Total supply

    }

    @And("I click on Apply changes")
    public void i_click_on_apply_changes() {
        driver.findElement(By.cssSelector("[class='sc-a4a6801b-0 dEfebw']")).click();
    }

    @And("I chose {string} by filtering through Algorith")
    public void i_chose_by_filtering_through_algorith(String string) {
        driver.findElement(By.cssSelector(".bvlYFP.hide_on_mobile_wrapper.sc-319be8a1-4 > .eTWSGQ.gNHIvn.sc-a4a6801b-0.sc-c8c9e58f-0.table-control-filter")).click();
        //Clicking on the filter

        driver.findElement(By.cssSelector("li:nth-of-type(2) > .dkCJeu.sc-71effa2a-0 > span > .cmPAGl.gNHIvn.sc-7b31fd38-0.sc-a4a6801b-0.sc-cc37dd9f-0")).click();
        //Clicking on Algorith

        driver.findElement(By.cssSelector(".dURHKG.sc-45fbdd6f-0 > div:nth-of-type(1) > ul > li:nth-of-type(5)")).click();
        //Clicking on PoW

    }

    @And("I add +AddFilter")
    public void i_add_add_filter() {
        driver.findElement(By.cssSelector("[class] li:nth-of-type(5) [data-sensors-click]")).click();

    }

    @And("I toggle on {string}")
    public void i_toggle_on(String string) {
        driver.findElement(By.cssSelector("[for='mineable']")).click();

    }

    @And("I select {string}")
    public void i_select(String string) {
        driver.findElement(By.cssSelector("div:nth-of-type(1) > .cGFzGl.cmc-filter-button.sc-a4a6801b-0 > .igdbUo.sc-aef7b723-0 > .dsDrxm.sc-aef7b723-0 > path")).click();
        //Clicking on all cryptocurrency

        driver.findElement(By.cssSelector("div:nth-of-type(2) > .bcMxzk.cmc-option-button.sc-a4a6801b-0")).click();

    }

    @And("I select price")
    public void i_select_price() {
        driver.findElement(By.cssSelector("div:nth-of-type(3) > .cGFzGl.cmc-filter-button.sc-a4a6801b-0 > .igdbUo.sc-aef7b723-0")).click();

    }

    @And("I set the minimum value to {int} and maximum to {int}")
    public void i_set_the_minimum_value_to_and_maximum_to(Integer int1, Integer int2) {
        driver.findElement(By.cssSelector(".cmc-input-row > input:nth-of-type(1)")).sendKeys("100");
        driver.findElement(By.cssSelector(".cmc-input-row > input:nth-of-type(2)")).sendKeys("10000");

    }

    @And("I click on apply filter")
    public void i_click_on_apply_filter() {
        driver.findElement(By.cssSelector(".cmc-filter-button.glxMF.sc-a4a6801b-0")).click();

    }

    @Then("I click show results to give me the new list")
    public void i_click_show_results_to_give_me_the_new_list() {
        driver.findElement(By.cssSelector(".cXksaI.cmc-filter-button.sc-a4a6801b-0")).click();

    }


}