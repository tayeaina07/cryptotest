Feature: Filtering through coinmarketcap and extracting data for comparison

  Scenario: To go through the url and perform requested actions
    Given I access the coinmarketcap web page
    When I access the homepage I handle the alter windows
    And I enter and I filter to see first 20 rows
    And customise the page contents such as price in ETH,Price Change to 7d%, Supply(from Max supply to Total Supply) and leave the rest as default
    And I click on Apply changes
    And I chose 'Pow' by filtering through Algorith
    And I add +AddFilter
    And I toggle on 'Mineable'
    And I select 'All Cryptocurrencies'
    And I select 'Coins'
    And I select price
    And  I set the minimum value to 100 and maximum to 10000
    And I click on apply filter
    Then I click show results to give me the new list
