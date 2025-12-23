package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPompage {
	@FindBy(xpath="//span[text()='[ ACC12 ] exam -  Organization Information']")
		private WebElement orgheader;
	@FindBy(id="dtlview_Organization Name")
	private WebElement verifyorgname;
	@FindBy(id="dtlview_Phone")
	private WebElement verifyphno;
	@FindBy(id="dtlview_Industry")
	private WebElement verifyindustry;
	@FindBy(id="dtlview_Type")
	private WebElement verifytype;
	//Initialize
	public OrgInfoPompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//utilize
	public String getOrgheader() {
		return orgheader.getText();
	}
	public String getVerifyorgname() {
		return verifyorgname.getText();
	}
	public String getVerifyphno() {
		return verifyphno.getText();
	}
	public String getVerifyindustry() {
		return verifyindustry.getText();
	}
	public String getVerifytype() {
		return verifytype.getText();
	}
	
	
	
	

}
