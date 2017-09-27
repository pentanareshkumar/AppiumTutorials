package appium.imdb.pages;

import org.openqa.selenium.By;

import appium.imdb.datadriven.IMDBDriverBase;

public class HomePage extends IMDBDriverBase{

	By menu_account = By.id("com.imdb.mobile:id/menu_account");
	By overflow = By.id("com.imdb.mobile:id/overflow");
	By signout_lnk = By.name("Sign Out");
	By signin_lnk = By.name("Sign In");
	
	
	public void clickMenuAccount()
	{
		driver.findElement(menu_account).click();
	}
	
	public void clickOverFlow()
	{
		driver.findElement(overflow).click();
	}
	
	public void clickSignOutLink()
	{
		driver.findElement(signout_lnk).click();
	}
	
	public void clickSignInLink()
	{
		driver.findElement(signin_lnk).click();
	}
	
}
