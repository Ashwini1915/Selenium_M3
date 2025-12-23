package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPompage {
	//Declare
	

	    @FindBy(name="accountname")
	    private WebElement orgnameTF;

	    @FindBy(id="phone")
	    private WebElement phnoTF;

	    @FindBy(name="industry")
	    private WebElement industryDD;

	    @FindBy(name="accounttype")
	    private WebElement typeDD;

	    @FindBy(xpath="//input[@title='Save[Alt+S]']")
	    private WebElement saveBtn;

	    public CreateOrgPompage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    public void enterOrgName(String orgName) {
	        orgnameTF.sendKeys(orgName);
	    }

	    public void enterPhone(String phone) {
	        phnoTF.sendKeys(phone);
	    }

	    public WebElement getIndustryDD() {
	        return industryDD;
	    }

	    public WebElement getTypeDD() {
	        return typeDD;
	    }

	    public void clickSave() {
	        saveBtn.click();
	    }
	}
