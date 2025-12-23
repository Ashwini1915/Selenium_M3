package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPompage  {
	//Declare
	@FindBy(linkText="Organizations")
	private WebElement org_header;
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement plusicon;
	//Initialization
	public OrgPompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//Utilize
	public String getOrg_header() {
		return org_header.getText();
	}
	public void getPlusicon() {
		 plusicon.click();
	}
	
	

}
