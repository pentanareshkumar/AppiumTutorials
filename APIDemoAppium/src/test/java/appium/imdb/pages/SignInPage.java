package appium.imdb.pages;

import org.openqa.selenium.By;

import appium.imdb.datadriven.IMDBDriverBase;

public class SignInPage extends IMDBDriverBase{
	
	By signin_with_imdb_btn = By.id("com.imdb.mobile:id/imdb_auth_portal");
	By email_txt_box = By.id("ap_email");
	By imdb_password_txt_box = By.id("ap_password");
	By signin_btn = By.id("signInSubmit");
	
	public void clickSigninWithIMDBBtn()
	{
		driver.findElement(signin_with_imdb_btn).click();
	}
	
	public void enterEmailId(String emailId)
	{
		driver.findElement(email_txt_box).sendKeys(emailId);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(imdb_password_txt_box).sendKeys(password);
	}
	
	public void clickSignInBtn()
	{
		driver.findElement(signin_btn).click();
	}
}
