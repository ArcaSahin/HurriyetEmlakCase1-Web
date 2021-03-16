package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.ForSalePage;
import Pages.LandingPage;
import Resources.Base;
import junit.framework.Assert;

public class TestScenarios extends Base {

	@Test
	public void BasePageNavigation() throws IOException 
	{
		driver = initializeDriver();
		driver.get("https://www.hurriyetemlak.com/");
	}
	
	@Test(priority=1)
	public void goTo_ForSalePage()
	{
		LandingPage lp = new LandingPage(driver);
		ForSalePage fsp = lp.click_forSale();
	}
	
	@Test(priority=2)
	public void Selections() throws InterruptedException
	{
		ForSalePage fsp = new ForSalePage(driver);
		fsp.selections_Part1();
	}
	
	@Test(priority=3)
	public void Selections2() throws InterruptedException
	{
		ForSalePage fsp = new ForSalePage(driver);
		fsp.selections_Part2("100000", "2000000");
	}
	
	@Test(priority=4)
	public void Selections3() throws InterruptedException
	{
		ForSalePage fsp = new ForSalePage(driver);
		fsp.selections_Part3();
	}
	
	@Test(priority=5)
	public void ClickSearch() throws InterruptedException
	{
		ForSalePage fsp = new ForSalePage(driver);
		fsp.click_Search();
	}
	
	@Test(priority=6)
	public void Assertions()
	{
		ForSalePage fsp = new ForSalePage(driver);
		Assert.assertTrue(fsp.verify_Filters().isDisplayed());
	}
	
	@Test(priority=7)
	public void CloseWebPage()
	{
		driver.close();
	}
	
}
