package Adminpageobject;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Usermanagementpage extends adminBasicpage {

	public Usermanagementpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
	private List<WebElement> btnsSideBar;
	
	@FindBy(xpath = "//a[@href='/user-management/ops-entities']")
	private WebElement manageopsbutton;
	
	@FindBy(xpath = "//a[@href='/user-management/kpo-entities']")
	private WebElement managekpobutton;
	
	@FindBy(xpath = "//a[@href='/user-management/admin-users']")
	private WebElement adminuserbutton;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']") 
	private WebElement clickonprofile;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement clickonlogoutbtn;
	
	// Manage ops
	@FindBy(xpath = "//input[@placeholder='Search by Entity Name']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//div[@class='ant-table-content']/table//tbody/tr")
	private List<WebElement> listdata;
	
	@FindBy(xpath = "//button[.='Create New']")
	private WebElement createnewbutton;
	
	@FindBy(xpath = "//input[@placeholder='Enter entity name']")
	private WebElement entitynamefield;  
	
	@FindBy(xpath = "//input[@placeholder='Enter entity name']")
	private WebElement entitynamefield1;
	
	@FindBy(xpath = "(//div[@class='css-b62m3t-container'])[1]")
	private WebElement clickonstatedropdown;
	
	@FindBy(xpath = "(//div[@class='css-b62m3t-container'])[2]")
	private WebElement  clickondistrictdropdown;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")   // (//input[@type='text'])[2]  // //input[@id='react-select-4-input']
	private WebElement statesearchfield;
	
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement districtsearchfield;
	
	@FindBy(xpath = "//button[.='Create Entity']")
	private WebElement createentitybutton;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement kebabbutton;
	
	@FindBy(xpath = "//div[@role='option']/input")
	private List<WebElement> stateanddistrictoptions;

	
	// update ops entity 
	@FindBy(xpath = "//button[.='Edit']") 
	private WebElement editbutton;
	
	@FindBy(xpath = "//button[.='Update Entity']")
	private WebElement updateentitybutton;
	
	@FindBy(xpath = "//button[.='View']")
	private List<WebElement> clickonviewbutton;
	
	// manager kpo 
	
	@FindBy(xpath = "//textarea")
	private WebElement enteraddresstextarea;
	
	@FindBy(xpath = "//input[@placeholder='Enter GST number']")
	private WebElement gstnumberfield;
	
	@FindBy(xpath = "//input[@placeholder='Enter Max Team Members']")
	private WebElement maxteammemberfield;
	
	@FindBy(xpath = "//div[@class='ant-select-selection-overflow']")
	private WebElement clickonbranchdropdown;
	
	@FindBy(xpath = "(//input[@type='search'])[2]")
	private WebElement searchbranchfield;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileupload;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	private List<WebElement> branchoption;
	
	
	// admin user  &   OPS manager  
	
	@FindBy(xpath = "//span[.='OPS Admin']")
	private WebElement opsadmintabbutton;
	
	@FindBy(xpath = "//input[@placeholder='Enter full name']")
	private WebElement fullnamefield;
	
	@FindBy(xpath = "//input[@placeholder='Enter email address']")
	private WebElement enteremailaddressfield;
	
	@FindBy(xpath = "//input[@placeholder='Enter phone number']")
	private WebElement enterphonenumberfield;
	
	@FindBy(xpath = "(//button[@type='button'])[8]")
	private WebElement createopsadminbutton;
	
	@FindBy(xpath = "//button[.='Update KPO Admin']")
	private WebElement updatekpoadminbutton;
	
	@FindBy(xpath = "//button[.='Update OPS Admin']")
	private WebElement updateopsadminbutton;
	
	@FindBy(xpath = "//button[.='Create KPO Admin']")
	private WebElement createkpoadminbutton;
	
	@FindBy(xpath = "//button[.='Create OPS Manager']")
	private WebElement createopsmanagerbtn;
	
	@FindBy(xpath = "//button[.='Update OPS Manager']")
	private WebElement updateopsmanagerbtn;
	
	@FindBy(xpath = "//button[.='Create KPO Manager']")
	private WebElement createkpomanagerbtn;
	
	@FindBy(xpath = "//button[.='Update KPO Manager']")
	private WebElement updatekpoamanagerbtn;
	
	@FindBy(xpath = "//span[.='Mark as company admin']")
	private WebElement markascompanyadmincheckbox;
	
	public void usermanagementlistpage(String email, String pwd, String sidebarusermgmtname
			) throws InterruptedException
	{
		adminsigninpage adminsignin = new adminsigninpage(driver);
		adminsignin.signinpage(email, pwd);
		
		ClickAction(sidebarusermgmtname);
		
		waitforElement(manageopsbutton);
		javascriptclick(manageopsbutton);
		
		Thread.sleep(3000);
		
		waitforElement(searchtextfield);
		searchtextfield.sendKeys("ops");
		
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		Thread.sleep(2000);
		
		waitforElement(clickonprofile);
		javascriptclick(clickonprofile);
		
		waitforElement(clickonlogoutbtn);
		clickonlogoutbtn.click();
		
		
	}
	
	public void createandupdateopsbranchandmanager(String email, String pwd, String sidebarusermgmtname
			) throws InterruptedException, AWTException
	{
		adminsigninpage adminsignin = new adminsigninpage(driver);
		adminsignin.signinpage(email, pwd);
		
		ClickAction(sidebarusermgmtname);
		
		waitforElement(manageopsbutton);
		javascriptclick(manageopsbutton);
		
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		Thread.sleep(2000);
		
		waitforElement(entitynamefield);
		entitynamefield.sendKeys(setRandomName());
		
		waitforElement(clickonstatedropdown);
		clickonstatedropdown.click();
//		javascriptclick(clickonstatedropdown);
		
		waitforElement(statesearchfield);
		statesearchfield.sendKeys("Andh");
		
		stateanddistrictoptions.get(0).click();
		driver.findElement(By.xpath("//div[.='Create ops Entity']")).click();
		
		Thread.sleep(1000);
		waitforElement(clickondistrictdropdown);
		clickondistrictdropdown.click();
//		javascriptclick(clickondistrictdropdown);
		
		waitforElement(districtsearchfield);
		districtsearchfield.sendKeys("Chit");
		
		stateanddistrictoptions.get(0).click();
		driver.findElement(By.xpath("//div[.='Create ops Entity']")).click();
		
		Thread.sleep(2000);
		
		waitforElement(createentitybutton);
		javascriptclick(createentitybutton);
		
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		Thread.sleep(3000);
		
		// update the ops branch
		
		waitforElement(kebabbutton);
		javascriptclick(kebabbutton);
		
		waitforElement(editbutton);
		javascriptclick(editbutton);
		
		waitforElement(entitynamefield1);
		entitynamefield1.click();
		entitynamefield1.sendKeys(Keys.CONTROL + "a");
		entitynamefield1.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
//		entitynamefield1.sendKeys("Update ops branch");
		
		waitforElement(clickonstatedropdown);
		javascriptclick(clickonstatedropdown);
		
		waitforElement(statesearchfield);
		statesearchfield.clear();
		Thread.sleep(1000);
		statesearchfield.sendKeys("Assam");
		stateanddistrictoptions.get(0).click();
		driver.findElement(By.xpath("//div[.='Edit ops Entity']")).click();
		
//		Actions action1 = new Actions(driver);
//		action1.sendKeys(Keys.ENTER).perform();
//		action1.sendKeys(Keys.ESCAPE).perform();
		
		Thread.sleep(2000);
		waitforElement(clickondistrictdropdown);
		javascriptclick(clickondistrictdropdown);
		
		waitforElement(districtsearchfield);
		districtsearchfield.clear();
		Thread.sleep(1000);
		districtsearchfield.sendKeys("jorhat");
		stateanddistrictoptions.get(0).click();
		driver.findElement(By.xpath("//div[.='Edit ops Entity']")).click();
		
//		action.sendKeys(Keys.ENTER).perform();
//		action.sendKeys(Keys.ESCAPE).perform();
		
		Thread.sleep(2000);
		
		waitforElement(updateentitybutton);
		javascriptclick(updateentitybutton);
		
		Thread.sleep(1000);
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		
		// crate manager under ops branch
		
		clickonviewbutton.get(0).click();
		
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(fullnamefield);
		fullnamefield.sendKeys(setRandomName());
		
		waitforElement(enteremailaddressfield);
		enteremailaddressfield.sendKeys(setRandomEmail());
		
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		waitforElement(createopsmanagerbtn);
		javascriptclick(createopsmanagerbtn);
		
		// update ops manager
		
//		driver.findElement(By.xpath("(//button)[12]")).click();
		waitforElement(kebabbutton);
//		javascriptclick(kebabbutton);
		kebabbutton.click();
		
		waitforElement(editbutton);
		javascriptclick(editbutton);
		
		waitforElement(fullnamefield);
		fullnamefield.click();
		fullnamefield.sendKeys(Keys.CONTROL + "a");
		fullnamefield.sendKeys(Keys.DELETE);
		fullnamefield.sendKeys(setRandomName());
		
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.click();
		enterphonenumberfield.sendKeys(Keys.CONTROL + "a");
		enterphonenumberfield.sendKeys(Keys.DELETE);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		waitforElement(updateopsmanagerbtn);
//		javascriptclick(updateopsmanagerbtn);
		updateopsmanagerbtn.click();
		
		waitforElement(clickonprofile);
		javascriptclick(clickonprofile);
		
		waitforElement(clickonlogoutbtn);
		clickonlogoutbtn.click();
	}
	
	public void createandupdatekpoentityandmanager(String email, String pwd, String sidebarusermgmtname,
			String Entityname) throws InterruptedException
	{
		adminsigninpage adminsignin = new adminsigninpage(driver);
		adminsignin.signinpage(email, pwd);
		
		ClickAction(sidebarusermgmtname);
		
		waitforElement(managekpobutton);
		javascriptclick(managekpobutton);
		
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		Thread.sleep(2000);
		
		waitforElement(entitynamefield);
		entitynamefield.sendKeys(setRandomName());
		
		waitforElement(enteraddresstextarea);
		enteraddresstextarea.sendKeys("BTM 1st stage, Bangalore");
		
		waitforElement(gstnumberfield);
		gstnumberfield.sendKeys("09BTWPS5056G1ZV");
		
		waitforElement(maxteammemberfield);
		maxteammemberfield.sendKeys("2");
		
		// click on branch
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
		branchoption.get(0).click();
		Actions action =  new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='block';", fileupload);
		fileupload.sendKeys("/home/active34/Downloads/photos /QA club photos/Club 7.png");
		// /home/active34/Downloads/photos /QA club photos/Club 7.png
		// C:\\Users\\User\\Desktop\\Background images\\Bg-1.jpg
		
		waitforElement(createentitybutton); 
		javascriptclick(createentitybutton); 
		
		Thread.sleep(3000);
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}		
		
		// update kpo entity
		
		Thread.sleep(1000);
		
		waitforElement(kebabbutton);
		javascriptclick(kebabbutton);
		
		waitforElement(editbutton);
		javascriptclick(editbutton);
		
		waitforElement(entitynamefield1);
		entitynamefield1.click();
		entitynamefield1.sendKeys(Keys.CONTROL + "a");
		entitynamefield1.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		entitynamefield1.sendKeys(setRandomName());
		
		waitforElement(enteraddresstextarea);
		enteraddresstextarea.click();
		enteraddresstextarea.sendKeys(Keys.CONTROL + "a");
		enteraddresstextarea.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		enteraddresstextarea.sendKeys("ATM 1st stage, Mangalore");
		
		waitforElement(gstnumberfield);
		gstnumberfield.click();
		gstnumberfield.sendKeys(Keys.CONTROL + "a");
		gstnumberfield.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		gstnumberfield.sendKeys("29CABPB5697M1Z5");
		
		waitforElement(maxteammemberfield);
		maxteammemberfield.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		maxteammemberfield.sendKeys("6");
		
		waitforElement(updateentitybutton);
		javascriptclick(updateentitybutton);
		
		Thread.sleep(1000);
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("update List data :- "+ listdetailsdata);
		}
		
		
		// create kpo manager under kpo company 
		
		
		clickonviewbutton.get(0).click();
				
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
				
		waitforElement(fullnamefield);
		fullnamefield.sendKeys(setRandomName());
				
		waitforElement(enteremailaddressfield);
		enteremailaddressfield.sendKeys(setRandomEmail());
				
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
				
		// branch optional  ----  click on branch
				
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).click();
		branchoption.get(0).click();
				
		waitforElement(markascompanyadmincheckbox);
		javascriptclick(markascompanyadmincheckbox);
				
		waitforElement(createkpomanagerbtn);
		javascriptclick(createkpomanagerbtn);
				
		// update kpo manager
		
		Thread.sleep(1000);				
		waitforElement(kebabbutton);
		kebabbutton.click();
				
		waitforElement(editbutton);
		javascriptclick(editbutton);
				
		waitforElement(fullnamefield);
		fullnamefield.click();
		fullnamefield.sendKeys(Keys.CONTROL + "a");
		fullnamefield.sendKeys(Keys.DELETE);
		fullnamefield.sendKeys(setRandomName());
				
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.click();
		enterphonenumberfield.sendKeys(Keys.CONTROL + "a");
		enterphonenumberfield.sendKeys(Keys.DELETE);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
			
		waitforElement(updatekpoamanagerbtn);
		javascriptclick(updatekpoamanagerbtn); 
		
		waitforElement(clickonprofile);
		javascriptclick(clickonprofile);
		
		waitforElement(clickonlogoutbtn);
		clickonlogoutbtn.click();
	}
	
	public void createandupdateopsadmin(String email, String pwd, String sidebarusermgmtname,
			String opsfullname) throws InterruptedException
	{
		adminsigninpage adminsignin = new adminsigninpage(driver);
		adminsignin.signinpage(email, pwd);
		
		ClickAction(sidebarusermgmtname);
		
		waitforElement(adminuserbutton);
		javascriptclick(adminuserbutton);
		
		waitforElement(opsadmintabbutton);
		javascriptclick(opsadmintabbutton);
		
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(fullnamefield);
		fullnamefield.sendKeys(opsfullname);
		
		waitforElement(enteremailaddressfield);
		enteremailaddressfield.sendKeys(setRandomEmail());
		
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		waitforElement(createopsadminbutton);
		javascriptclick(createopsadminbutton);
		
		Thread.sleep(1000);
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		
		// update ops admin 
		
		waitforElement(kebabbutton);
		javascriptclick(kebabbutton);
				
		waitforElement(editbutton);
		javascriptclick(editbutton);
	
		waitforElement(fullnamefield);
		fullnamefield.click();
		fullnamefield.sendKeys(Keys.CONTROL + "a");
		fullnamefield.sendKeys(Keys.DELETE);
		fullnamefield.sendKeys(setRandomName());
		
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.click();
		enterphonenumberfield.sendKeys(Keys.CONTROL + "a");
		enterphonenumberfield.sendKeys(Keys.DELETE);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		waitforElement(updateopsadminbutton);
		javascriptclick(updateopsadminbutton);
		
		waitforElement(clickonprofile);
		javascriptclick(clickonprofile);
		
		waitforElement(clickonlogoutbtn);
		clickonlogoutbtn.click();
	}
	
	public void createandupdatekpoadmin(String email, String pwd, String sidebarusermgmtname,
			String kpofullname) throws InterruptedException
	{
		adminsigninpage adminsignin = new adminsigninpage(driver);
		adminsignin.signinpage(email, pwd);
		
		ClickAction(sidebarusermgmtname);
		
		waitforElement(adminuserbutton);
		javascriptclick(adminuserbutton);
		
		waitforElement(createnewbutton);
		javascriptclick(createnewbutton);
		
		waitforElement(fullnamefield);
		fullnamefield.sendKeys(kpofullname);
		
		waitforElement(enteremailaddressfield);
		enteremailaddressfield.sendKeys(setRandomEmail());
		
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		waitforElement(createkpoadminbutton);
		javascriptclick(createkpoadminbutton);
		
		Thread.sleep(1000);
		for(int i = 0; i<= listdata.size(); i++)
		{
			 String listdetailsdata = listdata.get(1).getText();
			 System.out.println("List data :- "+ listdetailsdata);
		}
		
		// update kpo admin 
		waitforElement(kebabbutton);
		javascriptclick(kebabbutton);
				
		waitforElement(editbutton);
		javascriptclick(editbutton);
	
		waitforElement(fullnamefield);
		fullnamefield.click();
		fullnamefield.sendKeys(Keys.CONTROL + "a");
		fullnamefield.sendKeys(Keys.DELETE);
		fullnamefield.sendKeys("update kpo admin");
		
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.click();
		enterphonenumberfield.sendKeys(Keys.CONTROL + "a");
		enterphonenumberfield.sendKeys(Keys.DELETE);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		waitforElement(updatekpoadminbutton);
		javascriptclick(updatekpoadminbutton);
		
		waitforElement(clickonprofile);
		javascriptclick(clickonprofile);
		
		waitforElement(clickonlogoutbtn);
		clickonlogoutbtn.click();
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

}
