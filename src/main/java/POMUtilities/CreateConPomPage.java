package POMUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtilities;

public class CreateConPomPage {

    WebDriver driver;

    @FindBy(name = "lastname")
    private WebElement lastnameTF;

    @FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
    private WebElement orgPlusIcon;

    @FindBy(name = "search_text")
    private WebElement searchTF;

    @FindBy(name = "search")
    private WebElement searchBtn;

    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

    public CreateConPomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLastName(String lastname) {
        lastnameTF.sendKeys(lastname);
    }

    public void selectOrganization(String orgName, WebDriverUtilities wutil) {
        orgPlusIcon.click();
        String parentId = wutil.fetchTheParentWindowId(driver);
        wutil.swithtoWindowIdusing_tittle(driver, "Accounts");

        searchTF.sendKeys(orgName);
        searchBtn.click();
        driver.findElement(By.linkText(orgName)).click();

        wutil.swithbacktoParent(driver, parentId);
    }

    public void clickSave() {
        saveBtn.click();
    }
}
