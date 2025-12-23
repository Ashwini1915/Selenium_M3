package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePomPage {

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement homeHeader;

    @FindBy(partialLinkText="Organizations")
    private WebElement org_tab;

    @FindBy(partialLinkText="Contacts")
    private WebElement contact_tab;

    @FindBy(xpath="//img[contains(@src,'user')]")
    private WebElement administrator;

    @FindBy(linkText="Sign Out")
    private WebElement signout;

    public HomePomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getHomeHeader() {
        return homeHeader.getText();
    }

    public WebElement getOrg_tab() {
        return org_tab;
    }

    public WebElement getContact_tab() {
        return contact_tab;
    }

    public WebElement getAdministrator() {
        return administrator;
    }

    public WebElement getSignout() {
        return signout;
    }
}
