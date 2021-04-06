package Selenium;


	import java.util.Collections;
	import java.util.List;
	import java.util.concurrent.TimeUnit;
	import java.util.ArrayList;
	import java.util.Arrays;

	//import org.apache.poi.ss.formula.functions.T;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class QASeleniumTest {

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chrome\\chromeNew\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://tutorialsninja.com/demo/index.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@title='My Account']")).click();
			driver.findElement(By.xpath("//a[text()='Login']")).click();
			// username & password
			driver.findElement(By.cssSelector("#input-email")).sendKeys("sctqatest@grr.la");
			driver.findElement(By.cssSelector("#input-password")).sendKeys("Spring123$");

			WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
			login.click();
			driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
			WebElement scroll = driver.findElement(By.xpath("//div[@id='content']/script[1]"));
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			List<WebElement> ls = driver.findElements(By.xpath("//div[@class='product-thumb transition']/div[2]/h4/a"));
			List<WebElement> ls1 = driver.findElements(By.xpath("//div[@class='product-thumb transition']/div[2]/p[2]"));
			// Collections.sort(ls1);
			for (int i = 0; i < ls.size(); i++) {
				System.out.println(ls.get(i).getText());
			}
			List<Double> prizes = new ArrayList();
			for (int j = 0; j < ls1.size(); j++) {
				String price = ls1.get(j).getText();
				if(price.indexOf("Ex Tax:")<0)
				{
				System.out.println(price);
				System.out.println(price.indexOf(('$')));
				String finalprice = price.substring(price.indexOf('$')+1);
				System.out.println("my price" +finalprice);
				Double priceval = Double.parseDouble(finalprice);
				prizes.add(priceval);
				// 
			}
				System.out.println(price);
			}
			Collections.sort(prizes);
			//System.out.println("Sorted Price");
			
			//System.out.println(prizes);
			action.sendKeys(Keys.PAGE_UP).build().perform();
			driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).click();
			driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']")).click();
			driver.findElement(By.xpath("//select[@id='input-sort']")).click();
			driver.findElement(By.xpath("//option[text()='Price (High > Low)']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div/h4/a[text()='MacBook Pro']")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			WebElement quality = driver.findElement(By.xpath("//input[@name='quantity']"));
			quality.clear();
			quality.sendKeys("2");
			driver.findElement(By.xpath("//button[@id='button-cart']")).click();
			driver.findElement(By.xpath("//span[@id='cart-total']")).click();
			List<WebElement> l = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td"));
			for (WebElement e : l) {
				System.out.println(e.getText());
			}
			List<WebElement> l1 = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]"));
			for (WebElement e : l1) {
				System.out.println(e.getText());
			}

		}
	}



