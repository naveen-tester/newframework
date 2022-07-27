package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowPageObjects<WebElements> {
	
	public WebDriver driver;

	public WindowPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="openwindow")
	WebElement openwindow;
	@FindBy(xpath="//div[@class='text-center']/h2")
	WebElement coursestext;
	@FindBy(id="opentab")
	WebElement opentab;
	@FindBy(linkText="Home")
	WebElement hometext;
	@FindBy(id="name")
	WebElement textforalert;
	@FindBy(id="confirmbtn")
	WebElement alertButton;
	@FindBy(xpath="//input[@style='display: block;']")
	WebElement showText;
	@FindBy(id="hide-textbox")
	WebElement hideButton;
	@FindBy(xpath="//fieldset//*[@name='courses']/tbody/tr/td[3]")
	List<WebElement> coursePrice;
	@FindBy(xpath="//div[@class='tableFixHead']/table/tbody/tr/td[4]")
	List<WebElement> amount;
	@FindBy(xpath="//div[@class='totalAmount']")
	WebElement totalamount;
	
	public WebElement getWindow() {
		return openwindow;
	}
	public WebElement getCourses() {
		return coursestext;
	}
	public WebElement getOpenTab() {
		return opentab;
	}
	public WebElement getHomeText() {
		return hometext;
	}
	public WebElement getEnterNameForText() {
		return textforalert;
	}
	public WebElement getConfirmButton() {
		return alertButton;
	}
	public WebElement getShowText() {
		return showText;
	}
	public WebElement getHideButton() {
		return hideButton;
	}
	public List<WebElement> getcoursePrices() {
		return coursePrice;
	}
	public List<WebElement> getAmount(){
		return amount;
	}
	public WebElement getTotalAmount() {
		return totalamount;
	}
}
