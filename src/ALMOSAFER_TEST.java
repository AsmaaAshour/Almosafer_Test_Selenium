import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ALMOSAFER_TEST extends PARAMETERS {

	// This is Object => Another Way to Inheritance in java
	// PARAMETERS par= new PARAMETERS();
	// System.out.println(par.);

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void beforetest() {
		driver.get("https://www.almosafer.com/en?ncr=1");
	}

	@Test(enabled = false)
	public void test1() {
		// Assert the current language is English
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL.contains("en"), true);

		// Assert the current currency is SAR
		String CurrentCurrency = driver.findElement(By.cssSelector("[data-testid='Header__CurrencySelector']"))
				.getText();
		Assert.assertEquals(CurrentCurrency.contains("SAR"), true);
	}

	@Test(enabled = false)
	public void test2() throws InterruptedException {

		driver.get(Website[RandomIndexWebsite]);
		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();

		if (driver.getCurrentUrl().contains("en")) {
			driver.findElement(By.cssSelector("[data-testid='AutoCompleteInput']"))
					.sendKeys(EnglishPlaces[RandomIndexEnglishPlaces]);

		} else {
			driver.findElement(By.cssSelector("[data-testid='AutoCompleteInput']"))
					.sendKeys(ArabicPlaces[RandomIndexArabicPlaces]);
		}

		driver.findElement(By.cssSelector("[data-testid='HotelSearchBox__SearchButton']")).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("[data-testid='HotelSearchResult__sort__LOWEST_PRICE']")).click();
	}

	@Test()
	public void test3() {
		String ActualDepatureFlightDateString = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();

		String ActualReturnFlightDateString = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();

		int ActualDepatureFlightDateInt = Integer.parseInt(ActualDepatureFlightDateString);
		int ActualReturnFlightDateInt = Integer.parseInt(ActualReturnFlightDateString);

		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals(ActualDepatureFlightDateInt, ExpectedDepatureFlightDate);
		Assert.assertEquals(ActualReturnFlightDateInt, ExpectedReturnFlightDate);
		Assert.assertAll();

	}

	@AfterTest
	public void aftertest() {
	}
}
