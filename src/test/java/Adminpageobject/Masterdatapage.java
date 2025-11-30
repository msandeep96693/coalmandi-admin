package Adminpageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.checkerframework.checker.interning.qual.FindDistinct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Masterdatapage  extends adminBasicpage {

	public Masterdatapage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
	private List<WebElement> btnsSideBar;
	
	@FindBy(xpath = "((//div[@class='w-full']/div)[2]/div/div)[2]/div/div/div/h3")
	private List<WebElement> listofmasterdatalist;
	
	@FindBy(xpath = "//button[.='Create New']")
	private WebElement createnewbutton;
	
	// industry
	@FindBy(xpath = "//input[@placeholder='Enter industry name']")
	private WebElement enterindustryfield;
	
	@FindBy(xpath = "//button[.='Create']")
	private WebElement createbutton;
	
	@FindBy(xpath = "//div[@class='ant-table-content']/table//tbody/tr")
	private List<WebElement> listdata;
	
	// Ownership
	
	@FindBy(xpath = "//input[@placeholder='Enter ownership type']")
	private WebElement enterownershipfield;
	
	public void masterdata(String email, String pwd, String sidebarusermgmtname,
			String Industrylistname) throws InterruptedException
	{
		adminsigninpage adminsignin = new adminsigninpage(driver);
		adminsignin.signinpage(email, pwd);
		
		
		Thread.sleep(5000);
		
		ClickAction(sidebarusermgmtname);
		
		clickonmasterdatalist(Industrylistname);
		
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		
		
		
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
	}
	
	
	
	
	
	
	
	public void ClickAction(String btn) {
	    switch(btn.toLowerCase()) {
	        case "dashboard": javascriptclick(btnsSideBar.get(0)); break;
	        case "user management": javascriptclick(btnsSideBar.get(1)); break;
	        case "master data": javascriptclick(btnsSideBar.get(2)); break;
	        case "configuration": javascriptclick(btnsSideBar.get(3)); break;
	     
	        default: throw new NoSuchElementException("Button not found: " + btn);
	    }
	    
	    
	}
	
	public void clickonmasterdatalist(String expectedText)
	{
		for (WebElement masterdatalistname : listofmasterdatalist) 
		{
		String masterdatalistdata = masterdatalistname.getText().trim();
		System.out.println(" Master data : -"+masterdatalistdata);
			
		    if (masterdatalistdata.equalsIgnoreCase(expectedText) || masterdatalistdata.contains(expectedText)) 
		    {
		    	masterdatalistname.click();
		        break;
		    }
		}
	}
	

}
