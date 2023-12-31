package testMag;

import java.util.Random;

import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class teeesttts {
	int radiantNumber = 3;
	String radiantNumberString = "3";
	int breatheNumber = 2;
	String breatheNumberString = "2";

	int argusNumber = 4;
	String argusNumberString = "4";

	int heroNumber = 1;
	String heroNumberString = "1";

	int backpackNumber = 5;
	String backpackNumberString = "5";

	int numberOfItemTobeAdded = 5;

	// this the price
	String RadinetPrice;
	String breathePrice;

	String argusPrice;
	String heroPrice;
	String backpackPrice;

	// this is the urls
	String TheWebsite = "https://magento.softwaretestingboard.com/";
	String SignupPage = "https://magento.softwaretestingboard.com/customer/account/create/";
	String SingInPage = "https://magento.softwaretestingboard.com/customer/account/login";
	String SingOut = "https://magento.softwaretestingboard.com/customer/account/logout/";
	String CheckoutPage = "https://magento.softwaretestingboard.com/checkout/";

	// this is for registration process
	String[] firstNameList = { "ahmad", "ali", "anas", "mahmoud", "toqa" };
	String[] lastNameList = { "mahmoud", "noureldin", "faisal", "bahaa", "fadi" };
	String MutualPassowrd = "Asdasd123!@#";
	String theEmailToLogin;

	// this is for random
	Random rand = new Random();
	int RandomIndex = rand.nextInt(0, 5);
	int RandomIndexForEmail = rand.nextInt(0, 10000);

	// this is to login
	String EmailUser = "user";
	String EmailComplete = "@yahoo.com";

	// this is the webdriver
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void myBeforeTest() {

		driver.manage().window().maximize();
		driver.get(TheWebsite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		RadinetPrice = driver.findElement(By.xpath("//*[@id=\"old-price-1556-widget-product-grid\"]")).getText();
		breathePrice = driver.findElement(By.xpath("//*[@id=\"old-price-1812-widget-product-grid\"]")).getText();

		argusPrice = driver.findElement(By.xpath("//*[@id=\"old-price-694-widget-product-grid\"]")).getText();

		heroPrice = driver.findElement(By.xpath("//*[@id=\"old-price-158-widget-product-grid\"]")).getText();

		backpackPrice = driver.findElement(By.xpath("//*[@id=\"old-price-6-widget-product-grid\"]")).getText();

	}

	@Test(priority = 1)
	public void SingIUp() throws InterruptedException {

		driver.get(SignupPage);
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));

		firstName.sendKeys(firstNameList[RandomIndex]);

		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));

		lastName.sendKeys(lastNameList[RandomIndex]);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));

		email.sendKeys(EmailUser + RandomIndexForEmail + EmailComplete);

		theEmailToLogin = EmailUser + RandomIndexForEmail + EmailComplete;
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys(MutualPassowrd);
		WebElement confirmpassword = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
		confirmpassword.sendKeys(MutualPassowrd);

		WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));

		createAccount.click();

		Thread.sleep(5000);

		driver.get(SingOut);

	}

	@Test(priority = 2)
	public void SignIn() {

		theEmailToLogin = EmailUser + RandomIndexForEmail + EmailComplete;
		driver.get(SingInPage);
		WebElement EmailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		EmailField.sendKeys(theEmailToLogin);
		WebElement PasswordField = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		PasswordField.sendKeys(MutualPassowrd);

		WebElement SingInButton = driver.findElement(By.xpath("//*[@id=\"send2\"]"));

		SingInButton.click();
	}

	@Test(priority = 3)
	public void AddItems() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] ItemPages = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html",
				"https://magento.softwaretestingboard.com/fusion-backpack.html" };

		for (String ITEM : ItemPages) {
			driver.get(ITEM);

			Thread.sleep(5000);

			if (driver.getCurrentUrl().contains("radiant")) {
				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();

				Quantity.sendKeys(radiantNumberString);

				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
				int randomIndexForTheColor = rand.nextInt(0, colors.size());
				colors.get(randomIndexForTheColor).click();
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

				int randomindex = rand.nextInt(0, sizes.size());
				sizes.get(randomindex).click();

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);

			} else if (driver.getCurrentUrl().contains("breathe")) {
				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();

				Quantity.sendKeys(breatheNumberString);

				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
				int randomIndexForTheColor = rand.nextInt(0, colors.size());
				colors.get(randomIndexForTheColor).click();

				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

				int randomindex = rand.nextInt(0, sizes.size());
				sizes.get(randomindex).click();

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);

			} else if (driver.getCurrentUrl().contains("argus")) {

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();

				Quantity.sendKeys(argusNumberString);

				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
				int randomIndexForTheColor = rand.nextInt(0, colors.size());
				colors.get(randomIndexForTheColor).click();

				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

				int randomindex = rand.nextInt(0, sizes.size());
				sizes.get(randomindex).click();

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);

			} else if (driver.getCurrentUrl().contains("hoodie")) {

				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
				int randomIndexForTheColor = rand.nextInt(0, colors.size());
				colors.get(randomIndexForTheColor).click();

				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

				int randomindex = rand.nextInt(0, sizes.size());
				sizes.get(randomindex).click();
				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));

				Quantity.sendKeys(heroNumberString);

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);

			} else if (driver.getCurrentUrl().contains("backpack")) {
				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();

				Quantity.sendKeys(backpackNumberString);

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(3000);
			}

		}

	}

	@Test(priority = 4)
	public void CheckOutProcess() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(CheckoutPage);

		WebElement StreetAdress = driver.findElement(By.name("street[0]"));

		StreetAdress.sendKeys("Amman");

		WebElement City = driver.findElement(By.name("city"));
		City.sendKeys("Amman");

		WebElement region = driver.findElement(By.name("region_id"));
		Select selector = new Select(region);

		selector.selectByIndex(RandomIndex);

		WebElement PostalCode = driver.findElement(By.name("postcode"));

		PostalCode.sendKeys("123");

		WebElement country = driver.findElement(By.name("country_id"));
		Select selector2 = new Select(country);

		selector2.selectByIndex(RandomIndex);

		WebElement mobileNumber = driver.findElement(By.name("telephone"));

		mobileNumber.sendKeys("9627997770");
		Thread.sleep(10000);
		WebElement SubmitButton = driver
				.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
		SubmitButton.click();
	}

	@Test(priority = 5)
	public void confirm_the_price() {

		WebElement Radient = driver.findElement(By.xpath("//*[@id=\"old-price-1556-widget-product-grid\"]/span"));
		WebElement Breathe = driver.findElement(By.xpath("//*[@id=\"old-price-1812-widget-product-grid\"]/span"));
		WebElement Argus = driver.findElement(By.xpath("//*[@id=\"old-price-694-widget-product-grid\"]/span"));
		WebElement Hero = driver.findElement(By.xpath("//*[@id=\"old-price-158-widget-product-grid\"]/span"));
		WebElement Backpack = driver.findElement(By.xpath("//*[@id=\"old-price-6-widget-product-grid\"]/span"));

		String RadientString = Radient.getText().replace("$", "").replace(".", "");
		int RadientInt = Integer.parseInt(RadientString);
		int resultRadient = RadientInt / 100;

		System.out.println(resultRadient);

		String BreatheString = Breathe.getText().replace("$", "").replace(".", "");
		;
		int BreatheInt = Integer.parseInt(BreatheString);
		int resultBreath = BreatheInt / 100;
		System.out.println(resultBreath);

		String ArgusString = Argus.getText().replace("$", "").replace(".", "");
		;
		int ArgusInt = Integer.parseInt(ArgusString);
		int resultArgus = ArgusInt / 100;
		System.out.println(resultArgus);

		String HeroString = Hero.getText().replace("$", "").replace(".", "");
		;
		int HeroInt = Integer.parseInt(HeroString);
		int resultHero = HeroInt / 100;
		System.out.println(resultHero);

		String BackpackString = Backpack.getText().replace("$", "").replace(".", "");
		;
		int BackpackInt = Integer.parseInt(BackpackString);
		int resultBackpack = BackpackInt / 100;
		System.out.println(resultBackpack);

		int expected = (resultArgus * argusNumber) + (resultRadient * radiantNumber) + (resultBreath * breatheNumber)
				+ (resultHero * heroNumber) + (resultBackpack * backpackNumber);

		System.out.println(expected);

		String thePriceinTheCart = driver
				.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[4]/td/strong/span")).getText()
				.replace("$", "").replace(".", "");
		int thePriceAsInt = Integer.parseInt(thePriceinTheCart);
		int Actual = thePriceAsInt / 100;

		assertEquals(Actual, expected);

	}
}


