package AdminTestcaseExecution;

import org.testng.annotations.Test;

import Adminpageobject.Masterdatapage;
import Basepackage.AdminBaseclass;

public class MasterdataExecutionclass extends AdminBaseclass {
	
	@Test
	public void masterdataexecution() throws InterruptedException
	{
		master = new Masterdatapage(driver);
		 master.masterdata(prop.getProperty("emailID"), prop.getProperty("password"),
				 prop.getProperty("sidebarmasterdataname"), prop.getProperty("Industrylistname"),
				 prop.getProperty("ownershiptypename"), 
				 prop.getProperty("producttotradename"),
				 prop.getProperty("originofcoalname"),
				 prop.getProperty("coalsourcename"),
				 prop.getProperty("gradeofcoal"),
				 prop.getProperty("cilsubsidairies"),
				 prop.getProperty("portsofoperation"),
				 prop.getProperty("freeliftingperioidoptions"),
				 prop.getProperty("paymenttermsoptions"),
				 prop.getProperty("deliveryterms"),
				 prop.getProperty("deliverymode")
				 );
	}

}
