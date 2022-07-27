package tesngframework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.Base;
import pageObjects.loginPage;

@SuppressWarnings("deprecation")
public class HomePage extends Base{
	public WebDriver driver;
	loginPage lp;
	private static Logger log=LogManager.getLogger(HomePage.class.getName());
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void intilizeBrowser() throws Exception {
		driver =browserDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("Driver is intialized");
	
	}
	@Test(dataProvider="getData")
	public void loginPage(String name,String email) throws IOException {
		driver.get(prop.getProperty("url"));
		lp= new loginPage(driver);
		lp.getYourName().sendKeys(name);
		lp.getYourEmail().sendKeys(email);
		lp.getSubmit().click();
		System.out.println(lp.getProjectsPage().getText());
		//Assert.assertEquals(lp.getProjectsPage().getText(),"OUR PROJECTS");
		lp.getPractice2().click();
		log.info("Login is successful ");
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[1][2];
		data[0][0]="Naveen";
		data[0][1]="seleniumnaveen570@gmail.com";
		
		return data;
	}
	@Test(dependsOnMethods= {"loginPage"})
	public void radioButton() {
		lp= new loginPage(driver);
		lp.getRadiobutton1().click();
		lp.getRadiobutton1().isSelected();
	}
	@Test()
	public void suggetionBox() {
		lp.getSuggentionbox().sendKeys("ind");
		for(WebElement suggetion:lp.getSuggetions()) {
			if(suggetion.getText().equalsIgnoreCase("India")) {
				suggetion.click();
				break;
			}
		}
	}
	@Test(dependsOnMethods= {"loginPage"})
	public void DropDown() {
		Select s= new Select(lp.getDropDown());
		s.selectByValue("option1");
	}
	@Test(dependsOnMethods= {"loginPage"})
	public void CheckBox() {
		lp.getCheckBox1().click();
		lp.getCheckBox1().isSelected();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		log.info("browser closed successful ");
	}

}
