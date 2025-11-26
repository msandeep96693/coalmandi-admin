package Adminpageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adminsigninpage extends adminBasicpage {

	public adminsigninpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "(//input[@type='text'])[1]") 
	private WebElement emailfield;
	
	@FindBy(xpath = "(//input[@type='password'])[1]")
	private WebElement passwordfield;
	
	@FindBy(xpath = "(//span[text()='Log in'])[1]/..") 
	private WebElement siginbtn;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']") 
	private WebElement clickonprofile;
	
	@FindBy(xpath = "//button[.='Logout']")  
	private WebElement clickonlogoutbtn;
	
	public void signinpage(String email, String pwd) throws InterruptedException
	{
		// enter a email 
			waitforElement(emailfield);
			emailfield.sendKeys(email);	
			// enter a password
			waitforElement(passwordfield);
			passwordfield.sendKeys(pwd);
					// click on signin button
					waitforElement(siginbtn);
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", siginbtn );
			
//			Thread.sleep(3000);
//			waitforElement(clickonprofile);
//			javascriptclick(clickonprofile);
//			
//			waitforElement(clickonlogoutbtn);
//			clickonlogoutbtn.click();
			
	}
}
