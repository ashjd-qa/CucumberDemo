#Feature
Feature: Search Functionality

 Scenario: Successfully find the bus schedule at Translink website
 Given User launch the chrome browser
 When User opens the url "https://www.translink.ca/"
 Then User can view Homepage title - "Home | TransLink"
 Then User hover on Schedules and Maps in the main menu
 Then User click on Bus from sub menu dropdown options
 Then User can view the bus schedule page title - "Bus Schedules"
 Then User locate to the input area - Search by transit mode, route #, name, or stop
 When User type "99" in the search bar
 Then a list is returned when user click on find schedule search button
 Then User selects and clicks on "#99 – UBC B-Line" from the search results
Then User can view the selected bus schedules page for "99 UBC B-Line | TransLink"
When User update the date to be one day ahead
Then  User update the start time "07:30"
Then User update the end time "08:30"
Then User click on the search button 
And User can view the returned list
Then User select the click on the stop "#50913"
And User clicks on Add to Favorites button for the selected route
Then User rename stop name to "99 UBC B-Line" and click on add to favourites button
And User should confirm that stop is added to the favorites by visiting the manage my favourites page


 