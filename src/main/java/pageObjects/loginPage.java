package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	
	public WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	private By yourName= By.id("name");
	private By yourEmail=By.id("email");
	private By aggreTerms=By.id("agreeTerms");
	private By submit=By.id("form-submit");
	private By projectsPage=By.xpath("//h5[@class='section-title h1']");
	private By prcaticepage2=By.linkText("Automation Practise - 2");
	private By radiobutton1=By.xpath("//input[@value='radio1']");
	private By suggetionbox=By.id("autocomplete");
	private By suggetions=By.className("ui-menu-item");
	private By dropdown=By.id("dropdown-class-example");
	private By checkBox1=By.id("checkBoxOption1");
	
	public WebElement getYourName() {
		return driver.findElement(yourName);
	}
	public WebElement getYourEmail() {
		return driver.findElement(yourEmail);
	}
	public WebElement getAgreeTerms() {
		return driver.findElement(aggreTerms);
	}
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
	public WebElement getProjectsPage() {
		return driver.findElement(projectsPage);
	}
	public WebElement getPractice2() {
		return driver.findElement(prcaticepage2);
	}
	public WebElement getRadiobutton1() {
		return driver.findElement(radiobutton1);
	}
	public WebElement getSuggentionbox() {
		return driver.findElement(suggetionbox);
	}
	public List<WebElement> getSuggetions() {
		return driver.findElements(suggetions);
	}
	public WebElement getDropDown() {
		return driver.findElement(dropdown);
	}
	public WebElement getCheckBox1() {
		return driver.findElement(checkBox1);
	}
	
}
