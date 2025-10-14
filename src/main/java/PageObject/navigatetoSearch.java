package PageObject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitHelper;


public class navigatetoSearch {
	
	WebDriver driver;
	WaitHelper waitHelper;
	
	//CONSTRUCTOR
	
	public navigatetoSearch(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver,10);
	}
	
	//LOCATORS
	
	By SchandMapMainMenu = By.xpath("//a[normalize-space()='Schedules and Maps']");
	By BusSubMenu = By.xpath("//a[normalize-space()='Bus']");
	By searchBox = By.id("find-schedule-searchbox"); 
	By FindSchSearchBox = By.id("find-schedule-searchbox");
	By SeachBtn = By.xpath("//button[@class='flexContainer']");
	By SearchResultDisplay = By.xpath("//output[contains(@class,'searchResultsList')]");
	By DatePicker = By.xpath("//*[@id=\"schedulestimefilter-startdate\"]");
	By StartTime = By.xpath("//*[@id=\"schedulestimefilter-starttime\"]");
	By EndTime = By.xpath("//*[@id=\"schedulestimefilter-endtime\"]");
	By SchSearchBtn = By.xpath("//button[@class='flexContainer'][normalize-space()='Search']");
	By SchSearchResult = By.xpath("//*[@id=\"DesktopSchedulesTable\"]/tbody");
	By AddToFav = By.xpath("//*[@id=\"information\"]/section[2]/div/button[1]");
	By NameTxtBox = By.xpath("//*[@id=\"addgtfsfavourite-gtfsfavouritekey\"]");
	By AddToFavBtn = By.xpath("//*[@id=\"add-to-favourites_dialog\"]/form/section/gtfs-favourite/div/button");
	By ManageMyFavLink = By.xpath("//*[@id=\"information\"]/section[2]/div/a[2]");
	By myfavtxtview = By.xpath("//*[@id=\"content\"]/div[1]/section[3]/my-gtfs-favourites/ul/li");
	
	
	//ACTION METHODS
	
	// Page Validation
	public boolean isMainpageLoaded(String HomePageTitle) {
		return driver.getTitle().contains(HomePageTitle);
	}
	
	//click on main menu
	public void clickOnSchandMapMainMenu() {
		//Hover over the main menu first
				WebElement mainmenu = driver.findElement(SchandMapMainMenu);
				waitHelper.waitforElementsToBeVisible(mainmenu);
				
				Actions actions = new Actions(driver);
				actions.moveToElement(mainmenu).perform(); // hover on menu
				waitHelper.waitforElementsToBeVisible(mainmenu);
				//Thread.sleep(1000); //1 sec wait for submenu to appear
	}
	
	//click on sub menu
	public void clickOnBusSubMenu() {
		
		WebElement submenu = driver.findElement(BusSubMenu);
		waitHelper.waitforElementsToBeVisible(submenu);
		submenu.click();
		
		
	}
	
	// Page Validation
	public boolean isBusSchedulePageLoaded(String busScheduletitle) {
		return driver.getTitle().contains(busScheduletitle);
	}
	
	//locate to the search area
	public Boolean LocateToSearchNavigation() {
		 WebElement searchbox = driver.findElement(searchBox);
		 waitHelper.scrollToElement(searchbox);
		 waitHelper.waitforElementsToBeVisible(searchbox);
		 return searchbox.isDisplayed();
	}
	
	//Enter search input
	public void EnterSearchInput(String input) {
		WebElement searchboxInput = driver.findElement(FindSchSearchBox);
		waitHelper.waitforElementsToBeVisible(searchboxInput);
		searchboxInput.clear();
		searchboxInput.sendKeys(input);
	}
	
	//click on search button
	public void clickOnSearchbtn() {
		WebElement searchbtn = driver.findElement(SeachBtn);
		waitHelper.waitforElementsToBeClickable(searchbtn);
		searchbtn.click();
	}
	
	
    // Validate search results
	public boolean isSearchResultsVisible()
	{
		try {
			WebElement s_results = driver.findElement(SearchResultDisplay);
			waitHelper.waitforElementsToBeVisible(s_results);
			return s_results.isDisplayed();
		}
		catch
		(Exception e) {
			return false;
		}
	}
	
	//Click on bus 
	public void selectBusfromResultList(String busRoute) {
		
		  // Wait for the results container
	    WebElement resultsContainer = driver.findElement(By.xpath("//output[contains(@class,'searchResultsList')]"));
	    waitHelper.waitforElementsToBeVisible(resultsContainer);

	    // Use XPath to find the exact bus link
	    WebElement busLink = resultsContainer.findElement(
	        By.xpath(".//a[contains(normalize-space(.), '" + busRoute + "')]")
	    );

	    // Scroll into view and click using JavaScript to avoid interception
	    waitHelper.scrollToElement(busLink);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", busLink);
	}
	
	//Validate that selected bus page loaded 
	public boolean isBusRoutePageLoaded(String busRoute) {
	    return driver.getTitle().contains(busRoute);
	}
	
	//Select the start date and set
	public void selectTomorowDate() {
		//Method to select (enter) tomorrow’s date into the date input field
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		
		//Format date as yyyy/MM/dd 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = tomorrow.format(formatter);
		
		//clear the existing input and enter tomorrow's date
		driver.findElement(DatePicker).clear();
		driver.findElement(DatePicker).sendKeys(formattedDate);		
		
		// Print to console for verification
        System.out.println("Tomorrow’s date entered: " + formattedDate);
        
	}
	
	//Add the start time which is in HH:MM format
	public void setStartTime(String startTime) {
		WebElement startInput = driver.findElement(StartTime);
        waitHelper.waitforElementsToBeClickable(startInput);

        // Clear any existing value and enter desired time
        startInput.clear();
        startInput.sendKeys(startTime);

        // Optional: use JS to make sure value is set
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + startTime + "';", startInput);

        System.out.println("Start time set to: " + startTime);
	}
    
	//Add the end time which is in HH:MM format
	public void setEndTime(String endTime) {
		 WebElement endInput = driver.findElement(EndTime);
	        waitHelper.waitforElementsToBeClickable(endInput);

	        endInput.clear();
	        endInput.sendKeys(endTime);

	        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + endTime + "';", endInput);

	        System.out.println("End time set to: " + endTime);
	}
	
	//Click on search button
	public void clickOnSchSearchBtn() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait until the button is visible and enabled
	    WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(SchSearchBtn));

	    // Scroll into view - Waits until the Search button is both visible and clickable.
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", searchBtn);

	    // Remove any overlays dynamically (if present) - Scrolls the button into the center of the viewport
	    ((JavascriptExecutor) driver).executeScript(
	        "document.querySelectorAll('.alert-banner, .overlay, .sticky-header').forEach(e => e.style.display='none');"
	    );

	    // Retry clicking until successful - Removes any dynamic overlays that might block clicks (like popups, banners, sticky headers).
	    int attempts = 0;
	    while(attempts < 5) {
	        try {
	            searchBtn.click();
	            System.out.println("Search button clicked successfully!");
	            break;
	        } catch (ElementClickInterceptedException | StaleElementReferenceException e) { // StaleElementReferenceException happens if the page reloads or the element gets replaced
	            System.out.println("Click intercepted or stale, retrying...");
	            try { Thread.sleep(500); } catch (InterruptedException ex) {}
	            searchBtn = driver.findElement(SchSearchBtn); // re-locate element
	        }
	        attempts++;
	    }

	    // Final check: if still not clicked, do JS click
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
	    System.out.println("Final JS click executed!");
	}
    
	//Validate Bus Schedules Result table
	public boolean validateBusSchResults() {
		
		try {
			WebElement sb_results = driver.findElement(SchSearchResult);
			//waitHelper.scrollToElement(sb_results);
			waitHelper.waitforElementsToBeVisible(sb_results);
			return sb_results.isDisplayed();
			
		}
		catch
		(Exception e) {
			return false;
		}
		
	}
		
	    //Click on stop
		public void selectStopfromResultList(String stopList) {
			
			  // Wait for the results container
		    WebElement stopsResultsContainer = driver.findElement(SchSearchResult);
		    waitHelper.waitforElementsToBeVisible(stopsResultsContainer);

		    // Use XPath to find the exact bus link
		    WebElement stopLink = stopsResultsContainer.findElement(
		        By.xpath(".//a[contains(normalize-space(.), '" + stopList + "')]")
		    );

		    // Scroll into view and click using JavaScript to avoid interception
		    waitHelper.scrollToElement(stopLink);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", stopLink);
		}
		
	//click on Add to favorites
	public void clickOnAddToFav() {
		
		WebElement AddToFavbtn = driver.findElement(AddToFav);
		waitHelper.waitforElementsToBeClickable(AddToFavbtn);
		AddToFavbtn.click();
		
	}
	
	//Edit the Stop name
	public void editTxtNameAndAddToFav(String rename_stoptxt) {
	    // Rename the stop name
	    WebElement nameTxtbox = driver.findElement(NameTxtBox);
	    waitHelper.waitforElementsToBeClickable(nameTxtbox);
	    nameTxtbox.clear();
	    nameTxtbox.sendKeys(rename_stoptxt);

	    // Click on Add to Favorites button
	    WebElement addToFavBtn = driver.findElement(AddToFavBtn);
	    waitHelper.waitforElementsToBeClickable(addToFavBtn);
	    addToFavBtn.click();

	    System.out.println("Stop renamed to: " + rename_stoptxt + " and added to favorites.");
	}
	
	
	//Check that above step "Add to favourites" is displayed on the manage my favourites page
	public void NavToManageMyFavPage() {
		
		//click on Manage my favourites page
		WebElement ManageMyFav = driver.findElement(ManageMyFavLink);
		waitHelper.waitforElementsToBeClickable(ManageMyFav);
		ManageMyFav.click();
		
		//Locate favourites list
		// Wait for 99 UBC B-Line link to be visible
	    WebElement favRoute = driver.findElement(By.xpath("//a[text()='99 UBC B-Line']"));
	    waitHelper.waitforElementsToBeVisible(favRoute);

	    // Simple assertion
	    if (favRoute.isDisplayed()) {
	        System.out.println("99 UBC B-Line successfully added to Favorites!");
	    } else {
	        throw new AssertionError("Stop not found in Favorites list!");
	    }
	
		
	}
	
 
}
