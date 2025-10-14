package stepdefinitions;
import org.openqa.selenium.*;

import java.time.Duration;

import org.junit.*;
import PageObject.navigatetoSearch;
import io.cucumber.java.en.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

public class BusSchedulesNavStep {
	
	WebDriver driver;
	navigatetoSearch nts;
	WaitHelper waitHelper;
	
	//Navigate to Bus Schedules page
	
	@Given("User launch the chrome browser")
	public void user_launch_the_chrome_browser() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	}

	@When("User opens the url {string}")
	public void user_opens_the_url(String url) {
	    driver.get(url);
	    nts = new navigatetoSearch(driver);
	}

	@Then("User can view Homepage title - {string}")
	public void user_can_view_homepage_title(String HomePageTitle) {
		// Wait for the page title to contain the bus route name
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains(HomePageTitle));

	    // Assert that the page title contains the bus route name
	    Assert.assertTrue("Bus route page not loaded!", driver.getTitle().contains(HomePageTitle));
	}

		//String actualTitle = driver.getTitle();
	   // Assert.assertTrue("Title not found! Actual title: " + actualTitle,
	                      //actualTitle.contains("Home | TransLink"));

	@Then("User hover on Schedules and Maps in the main menu")
	public void user_hover_on_schedules_and_maps_in_the_main_menu() {
	    nts.clickOnSchandMapMainMenu();
	}

	@Then("User click on Bus from sub menu dropdown options")
	public void user_click_on_bus_from_sub_menu_dropdown_options(){
	    nts.clickOnBusSubMenu();
	}

	@Then("User can view the bus schedule page title - {string}")
	public void user_can_view_the_bus_schedule_page_title(String busScheduletitle) {
		// Wait for the page title to contain the bus route name
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains(busScheduletitle));

	    // Assert that the page title contains the bus route name
	    Assert.assertTrue("Bus route page not loaded!", driver.getTitle().contains(busScheduletitle));
	}

	@Then("User locate to the input area - Search by transit mode, route #, name, or stop")
	public void user_locate_to_the_input_area_search_by_transit_mode_route_name_or_stop() {
	  
	    Assert.assertTrue("Search box is not visible!", nts.LocateToSearchNavigation());
	}

	@When("User type {string} in the search bar")
	public void user_type_in_the_search_bar(String input) {
		nts.EnterSearchInput("99");
	    
	}

	@Then("a list is returned when user click on find schedule search button")
	public void a_list_is_returned_and_user_click_on_find_schedule_search_button() {
		nts.clickOnSearchbtn();
		boolean resultsvisible = nts.isSearchResultsVisible();
		Assert.assertTrue("List is not visible",resultsvisible);
		if(resultsvisible){
	     System.out.println("List results are visible");
		}else {
		 System.out.println("List is not visible");
		}
	}
	
	//Navigate to selected bus schedule page - "#99 - UBC B-Line"
	
	@Then("User selects and clicks on {string} from the search results")
	public void user_selects_and_clicks_on_from_the_search_results(String busRoute) {
	    nts.selectBusfromResultList("#99 - UBC B-Line");

 }
	
	@Then("User can view the selected bus schedules page for {string}")
	public void user_can_view_the_selected_bus_schedules_page(String busRoute) {
		// Wait for the page title to contain the bus route name
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains(busRoute));

	    // Assert that the page title contains the bus route name
	    Assert.assertTrue("Bus route page not loaded!", driver.getTitle().contains(busRoute));
	}
	
	//Update the Date and Time and search for results
	
	@When("User update the date to be one day ahead")
	public void user_update_the_date_to_be_one_day_ahead() {
	    nts.selectTomorowDate();
	}

	@Then("User update the start time {string}")
	public void user_update_the_start_time(String startTime) {
	    nts.setStartTime(startTime);
	    
	}

	@Then("User update the end time {string}")
	public void user_update_the_end_time(String endTime) {
	    nts.setEndTime(endTime);
	}

	@Then("User click on the search button")
	public void user_click_on_the_search_button() {
	    nts.clickOnSchSearchBtn();
	}

	@And("User can view the returned list")
	public void user_can_view_the_returned_list() {
	    nts.validateBusSchResults();
	    boolean BusSchResultVisible = nts.validateBusSchResults();
	    Assert.assertTrue("List is not visible",BusSchResultVisible);
	}
	
	@Then("User select the click on the stop {string}")
	public void user_select_the_click_on_the_stop(String stopList) {
	    nts.selectStopfromResultList(stopList);
	}

	@And("User clicks on Add to Favorites button for the selected route")
	public void user_clicks_on_button_for_the_selected_route() {
	    nts.clickOnAddToFav();
	}

	@Then("User rename stop name to {string} and click on add to favourites button")
	public void user_rename_stop_name_to_and_click_on_add_to_favourites_button(String rename_stoptxt) {
	    nts.editTxtNameAndAddToFav(rename_stoptxt);

	}

	@And("User should confirm that stop is added to the favorites by visiting the manage my favourites page")
	public void user_should_confirm_that_stop_is_added_to_the_favorites_by_visiting_the_manage_my_favourites_page() {
	   nts.NavToManageMyFavPage();
	   
	  
	   
	}




}
