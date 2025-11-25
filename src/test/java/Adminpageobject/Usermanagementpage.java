package Adminpageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	// Manage ops
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//div[@class='ant-table-content']/table//tbody/tr")
	private List<WebElement> opsbranchlistdata;
	
	@FindBy(xpath = "//button[.='Create New']")
	private WebElement createnewbutton;
	
	@FindBy(xpath = "//input[@placeholder='Enter entity name']")
	private WebElement entitynamefield;
	
	@FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[1]")
	private WebElement clickonstatedropdown;
	
	@FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[2]")
	private WebElement  clickondistrictdropdown;
	
	@FindBy(xpath = "(//input[@type='search'])[2]")
	private WebElement statesearchfield;
	
	@FindBy(xpath = "(//input[@type='search'])[3]")
	private WebElement districtsearchfield;
	
	@FindBy(xpath = "//button[.='Create Entity']")
	private WebElement createentitybutton;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement kebabbutton;
	
	// update entity 
	@FindBy(xpath = "//button[.='Edit']") 
	private WebElement editbutton;
	
	@FindBy(xpath = "//button[.='Update Entity']")
	private WebElement updateentitybutton;
	
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
