package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConInfoPomPage {

    @FindBy(id="dtlview_Last Name")
    private WebElement verifyconname;

    @FindBy(id="dtlview_Support Start Date")
    private WebElement verifyStartDate;

    @FindBy(id="dtlview_Support End Date")
    private WebElement verifyEndDate;

    @FindBy(id="dtlview_Organization Name")
    private WebElement verifyOrgname;

    public ConInfoPomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getVerifyconname() {
        return verifyconname.getText();
    }

    public String getVerifyStartDate() {
        return verifyStartDate.getText();
    }

    public String getVerifyEndDate() {
        return verifyEndDate.getText();
    }

    public String getVerifyOrgname() {
        return verifyOrgname.getText();
    }
}
