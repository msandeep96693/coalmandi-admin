package AdminTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Adminpageobject.Usermanagementpage;
import Basepackage.AdminBaseclass;

public class usermanagementExecutionclass  extends AdminBaseclass {

	@Test(priority = 0, enabled = false)
	public void usermanagementlistflow() throws InterruptedException
	{
		 user = new Usermanagementpage(driver);
		 user.usermanagementlistpage(prop.getProperty("emailID"), prop.getProperty("password"),
 				 prop.getProperty("sidebarusermgmtname"));
	}
	
	
	@Test(priority = 1, enabled = false)
	public void createandupdateopsentityflow() throws InterruptedException, AWTException
	{
		 user = new Usermanagementpage(driver);
		 user.createandupdateopsbranchandmanager(prop.getProperty("emailID"), prop.getProperty("password"),
 				 prop.getProperty("sidebarusermgmtname"), prop.getProperty("Entityname"));
	}
	
	@Test(priority = 1, enabled = false)
	public void createandupdatekpoentityflow() throws InterruptedException, AWTException
	{
		 user = new Usermanagementpage(driver);
		 user.createandupdatekpoentityandmanager(prop.getProperty("emailID"), prop.getProperty("password"),
 				 prop.getProperty("sidebarusermgmtname"), prop.getProperty("Entityname"));
	}
	
	@Test(priority = 1, enabled = false)
	public void createandupdateopsadminflow() throws InterruptedException, AWTException
	{
		 user = new Usermanagementpage(driver);
		 user.createandupdateopsadmin(prop.getProperty("emailID"), prop.getProperty("password"),
 				 prop.getProperty("sidebarusermgmtname"), prop.getProperty("opsfullname"));
	}
	
	@Test(priority = 1, enabled = true)
	public void createandupdatekpoadminflow() throws InterruptedException, AWTException
	{
		 user = new Usermanagementpage(driver);
		 user.createandupdatekpoadmin(prop.getProperty("emailID"), prop.getProperty("password"),
 				 prop.getProperty("sidebarusermgmtname"), prop.getProperty("kpofullname"));
	}
	
	
}
