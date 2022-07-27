package tesngframework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WindowPageObjects;
import pageObjects.loginPage;
import resources.Base;

public class Windows extends Base {
	
	WindowPageObjects wo;
	public WebDriver driver;
	loginPage lp;
	@BeforeTest
	public void initilizeBrowser() throws IOException {
		driver=browserDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(dataProvider="getData")
	public void loginPage(String name,String email) {
		
		driver.get(prop.getProperty("url"));
		lp= new loginPage(driver);
		lp.getYourName().sendKeys(name);
		lp.getYourEmail().sendKeys(email);
		lp.getSubmit().click();
		System.out.println(lp.getProjectsPage().getText());
		//Assert.assertEquals(lp.getProjectsPage().getText(),"OUR PROJECTS");
		lp.getPractice2().click();
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[1][2];
		data[0][0]="Naveen";
		data[0][1]="seleniumnaveen570@gmail.com";
		return data;
	}
	@SuppressWarnings("deprecation")
	@Test(dependsOnMethods="loginPage")
	public void openWindow() {
		wo= new WindowPageObjects(driver);
		wo.getWindow().click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String Parent=it.next();
		String Child=it.next();
		driver.switchTo().window(Child);
		assertEquals(wo.getCourses().getText(),"FEATURED COURSES");
		driver.switchTo().window(Parent);
	}
	@SuppressWarnings("deprecation")
	@Test(dependsOnMethods="loginPage")
	public void OpenTab() {
		wo= new WindowPageObjects(driver);
		wo.getOpenTab().click();
		assertEquals(wo.getHomeText().getText(), "Home");
	}
	@Test
	public void verifyAlert() {
		wo= new WindowPageObjects(driver);
		String name="Naveen";
		wo.getEnterNameForText().sendKeys(name);
		wo.getConfirmButton().click();
		String alertTest=driver.switchTo().alert().getText();
		String originalText="Hello "+name+", Are you sure you want to confirm?";
		assertEquals(originalText,alertTest);
		driver.switchTo().alert().accept();
		wo.getConfirmButton().click();
		driver.switchTo().alert().dismiss();
	}
	@Test(dependsOnMethods="loginPage")
	public void VerifyTheElementDisplayed() {
		wo= new WindowPageObjects(driver);
		wo.getHideButton().click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('displayed-text').value='Naveen';");
	}
	@Test(dependsOnMethods="loginPage")
	public void SumOfCoursePrice() {
		wo= new WindowPageObjects(driver);
		int temp=0;
		int sum=0;
		int CountCourse=wo.getcoursePrices().size();
		System.out.println(CountCourse);
		for(int i=0;i<CountCourse;i++) {
			String price=((WebElement) wo.getcoursePrices().get(i)).getText();
			int coursePrice=Integer.parseInt(price);
			temp=coursePrice+sum;
			sum=temp;
		}
		System.out.println("Total sum of prices: "+sum);
	}
	
	@Test(dependsOnMethods="loginPage")
	public void VerifyTotalAmount() {
		wo= new WindowPageObjects(driver);
		int amountCount=wo.getAmount().size();
		int temp,sum=0;
		for(int i=0;i<amountCount;i++) {
			String personAmount=((WebElement) wo.getAmount().get(i)).getText();
			int PA=Integer.parseInt(personAmount);
			temp=sum+PA;
			sum=temp;
		}
		String TotalText=wo.getTotalAmount().getText();
		String digits=TotalText.replaceAll("[^0-9]", "");
		int totalAmount=Integer.parseInt(digits);
		assertEquals(totalAmount,sum);
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
