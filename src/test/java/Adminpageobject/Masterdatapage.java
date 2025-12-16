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
	
	// ownership
	@FindBy(xpath = "//input[@placeholder='Enter ownership type']")
	private WebElement enterownershiptype;
	
	// product to trade
	@FindBy(xpath = "//input[@placeholder='Enter coal type']")
	private WebElement entercoaltype;
	
	@FindBy(xpath = "//input[@placeholder='Enter hsn code']")
	private WebElement enterhsncode;
	
	@FindBy(xpath = "//input[@placeholder='Enter minimum listing quantity']")
	private WebElement minilistingquantity;
	
	@FindBy(xpath = "//input[@placeholder='Enter minimum listing quantity increment']")
	private WebElement minilistingquantityincrement;
	
	@FindBy(xpath = "//input[@placeholder='Enter minimum bidding quantity']")
	private WebElement minibiddingquantity;
	
	@FindBy(xpath = "//input[@placeholder='Enter minimum bidding quantity increment']")
	private WebElement minibiddingquantityincrement;
	
	@FindBy(xpath = "//input[@placeholder='Enter minimum bidding price increment']")
	private WebElement minibiddingpriceincrement;
	
	@FindBy(xpath = "//input[@placeholder='Enter minimum split quantity']")
	private WebElement minisplitquantity;
	
	// origin of coal
	@FindBy(xpath = "//input[@placeholder='Enter coal origin']")
	private WebElement originofcoalfield;
	
	// coal source
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[3]")
	private WebElement clickcoalsourcedropdown;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	private List<WebElement> coaloriginoptions;
	
	@FindBy(xpath = "//input[@placeholder='Enter coal source']")
	private WebElement coalsourcefield;
	
	@FindBy(xpath = "//div[@class='ant-table-content']/table//tbody/tr")
	private List<WebElement> listdata;
	
	// grade of coal
	
	@FindBy(xpath = "//input[@placeholder='Enter coal grade name']")
	private WebElement entercoalgradenamefield;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[4]")
	private WebElement clickoncoalorigindropdown;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[5]")
	private WebElement clickoncoaltypedropdown;
	
	@FindBy(xpath = "//input[@placeholder='Enter unit']")
	private WebElement enterunitfield;
	
	@FindBy(xpath = "//input[@placeholder='Enter value range']" )
	private WebElement entervaluerangefield;
	
	// cil subsidairies
	
	@FindBy(xpath = "//input[@placeholder='Enter cil subsidiary name']")
	private WebElement entercilsubsidairynamefield;
	
	@FindBy(xpath = "//input[@placeholder='Enter google map url']" ) 
	private WebElement entergooglemapurlfield;
	
	
	
	public void masterdata(String email, String pwd, String sidebarusermgmtname,
			String Industrylistname, String ownershiptypename, String producttotradename,
			String originofcoalname, String coalsourcename,
			String gradeofcoal, String cilsubsidairies ) throws InterruptedException
	{
		adminsigninpage adminsignin = new adminsigninpage(driver);
		adminsignin.signinpage(email, pwd);
		
		
		Thread.sleep(2000);
		
		ClickAction(sidebarusermgmtname);
		
		clickonmasterdatalist(Industrylistname);
		
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(enterindustryfield);
		enterindustryfield.sendKeys(setRandomNameformasterdata());
		
		waitforElement(createbutton);
		javascriptclick(createbutton);
		Thread.sleep(2000);
		
		
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		// ---------------------- ownership type ------------------------------------------
		
		ClickAction(sidebarusermgmtname);
		
		clickonmasterdatalist(ownershiptypename);

		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(enterownershiptype);
		enterownershiptype.sendKeys(setRandomNameformasterdata());
		
		waitforElement(createbutton);
		javascriptclick(createbutton);
		Thread.sleep(2000);
		
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		//// ---------------------- product to trade ------------------------------------------
		
		ClickAction(sidebarusermgmtname);
		
		clickonmasterdatalist(producttotradename);

		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(entercoaltype);
		entercoaltype.sendKeys(setRandomNameformasterdata());
		
		waitforElement(enterhsncode);
		enterhsncode.sendKeys("HSN346346");
		
		waitforElement(minilistingquantity);
		minilistingquantity.sendKeys("500");
		
		waitforElement(minilistingquantityincrement);
		minilistingquantityincrement.sendKeys("200");
		
		waitforElement(minibiddingquantity);
		minibiddingquantity.sendKeys("500");
		
		waitforElement(minibiddingquantityincrement);
		minibiddingquantityincrement.sendKeys("100");
		
		waitforElement(minibiddingpriceincrement);
		minibiddingpriceincrement.sendKeys("150");
		
		waitforElement(minisplitquantity);
		minisplitquantity.sendKeys("50");
		
		waitforElement(createbutton);
		javascriptclick(createbutton);
		
		Thread.sleep(2000);
		
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		
		// ------------- Origin of coal -------------------------
		
		ClickAction(sidebarusermgmtname);
		
		clickonmasterdatalist(originofcoalname);

		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(originofcoalfield);
		originofcoalfield.sendKeys(setRandomNameformasterdata());
		
		waitforElement(createbutton);
		javascriptclick(createbutton);
		
		Thread.sleep(2000);
		
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		// ------------ coal sources -----------------------

		ClickAction(sidebarusermgmtname);
		
		clickonmasterdatalist(coalsourcename);

		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(clickcoalsourcedropdown);
//		javascriptclick(clickcoalsourcedropdown);
		clickcoalsourcedropdown.click();
		
		coaloriginoptions.get(1).click();
		
		waitforElement(coalsourcefield);
		coalsourcefield.sendKeys(setRandomNameformasterdata());
		
		waitforElement(createbutton);
		javascriptclick(createbutton);
		
		Thread.sleep(2000);
		
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		
		// Grade of coal
		
		ClickAction(sidebarusermgmtname);
		
		clickonmasterdatalist(gradeofcoal);
		
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(entercoalgradenamefield);
		entercoalgradenamefield.sendKeys(setRandomNameformasterdata());
		
		waitforElement(clickoncoalorigindropdown);
		clickoncoalorigindropdown.click();
		
		coaloriginoptions.get(1).click();
		
		waitforElement(clickoncoaltypedropdown);
		clickoncoaltypedropdown.click();
		
		coaloriginoptions.get(1).click();

		waitforElement(enterunitfield);
		enterunitfield.sendKeys("NCV / FC");

		waitforElement(entervaluerangefield);
		entervaluerangefield.sendKeys("High purity, FC > 95%");
		
		waitforElement(createbutton);
		javascriptclick(createbutton);
		
		Thread.sleep(2000);
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		// cil subsidairies
		
		ClickAction(sidebarusermgmtname);
				
		clickonmasterdatalist(cilsubsidairies);
				
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(entercilsubsidairynamefield);
		entercilsubsidairynamefield.sendKeys("CIL Subsidairy name");
		
		waitforElement(entergooglemapurlfield);
		entergooglemapurlfield.sendKeys("https://maps.app.goo.gl/LVUPWLi5Uob2o2wT7");
		
		waitforElement(createbutton);
		javascriptclick(createbutton);
		
		Thread.sleep(2000);
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		// mines
		
		// ports of operation
		
		// free lifting period options
		
		// payment terms options
		
		// delivery terms
		
		// delivery mode
		
		
		
		
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
