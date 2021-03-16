package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	WebElement element;
	
	@FindBy(xpath="//img[@src='/_nuxt/img/satilik.c924a0d.svg']")
	WebElement satilikBtn;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ForSalePage click_forSale()
	{
		ForSalePage fsp = new ForSalePage(driver);
		satilikBtn.click();
		return fsp;
	}
}
