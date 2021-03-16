package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForSalePage {

	WebDriver driver;
	WebElement element;
	ForSalePage fsp;
	
	@FindBy(xpath="//div[@class='he-select-base__container']")
	WebElement selectCityBar;
	
	@FindBy(xpath="//input[@placeholder='İl Ara']")
	WebElement selectCityList;
	
	@FindBy(xpath="//div[@class='he-radio he-select__radio']")
	WebElement selectCityRadioBtn;
	
	@FindBy(xpath="//*[contains(text(),'İlçe Seçiniz')]")
	WebElement selectCountyBar;
	
	@FindBy(xpath="//input[@placeholder='İlçe Ara']")
	WebElement selectCountyList;
	
	@FindBy(xpath="//*[contains(text(),'Bornova')]")
	WebElement selectCountyCheckBox;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[2]/div/ul/li[2]")
	WebElement categoryRadioBtn;
	
	@FindBy(xpath="//input[@class='floating-input priceMin']")
	WebElement minBox;
	
	@FindBy(xpath="//input[@class='floating-input priceMax']")
	WebElement maxBox;
	
	@FindBy(xpath="//*[contains(text(),'Bina Yaşı Seçiniz')]")
	WebElement selectBuildingAgeBar;
	
	@FindBy(xpath="//*[contains(text(),'Sıfır Bina')]")
	WebElement selectBuildingAgeCheckBox;
	
	@FindBy(xpath="//*[contains(text(),'1-5')]")
	WebElement selectBuildingAgeCheckBox2;
	
	@FindBy(xpath="//*[contains(text(),'6-10')]")
	WebElement selectBuildingAgeCheckBox3;
	
	@FindBy(linkText="Ara")
	WebElement clickSearchBtn;
	
	@FindBy(className="applied-filters__inner")
	WebElement appliedFilters;
	
	public ForSalePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ForSalePage selections_Part1() throws InterruptedException
	{
		ForSalePage fsp = new ForSalePage(driver);
		fsp.selectCityBar.click();
		fsp.selectCityList.sendKeys("İzmir");
		fsp.selectCityRadioBtn.click();
		Thread.sleep(3000);
		fsp.selectCountyBar.click();
		fsp.selectCountyList.sendKeys("Bornova");
		fsp.selectCountyCheckBox.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[2]/div/ul/li[2]"))).click();
		fsp.categoryRadioBtn.click();
		return fsp;
	}
	
	public ForSalePage selections_Part2(String min, String max) throws InterruptedException
	{
		Thread.sleep(3000);
		minBox.sendKeys(min);
		maxBox.sendKeys(max);
		return this;
	}
	
	public ForSalePage selections_Part3() throws InterruptedException
	{
		Thread.sleep(5000);
		selectBuildingAgeBar.click();
		selectBuildingAgeCheckBox.click();
		Thread.sleep(2000);
		selectBuildingAgeCheckBox2.click();
		Thread.sleep(2000);
		selectBuildingAgeCheckBox3.click();
		return this;
	}
	
	public ForSalePage click_Search() throws InterruptedException
	{
		Thread.sleep(5000);
		clickSearchBtn.click();
		return this;
	}
	
	public WebElement verify_Filters()
	{
		return appliedFilters;
	}


}
