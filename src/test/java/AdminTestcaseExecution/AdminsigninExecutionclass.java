package AdminTestcaseExecution;

import org.testng.annotations.Test;

import Adminpageobject.adminsigninpage;
import Basepackage.AdminBaseclass;

public class AdminsigninExecutionclass extends AdminBaseclass {

	
	@Test(priority = 0, invocationCount = 2)
	public void adminsigninflow() throws InterruptedException
	{
		adminsigninpage signin = new adminsigninpage(driver);
		signin.signinpage(prop.getProperty("emailID"), prop.getProperty("password"));
	}
}
