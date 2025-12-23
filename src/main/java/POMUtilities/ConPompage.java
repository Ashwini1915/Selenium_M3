package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConPompage {

    @FindBy(xpath="//img[@title='Create Contact...']")
    private WebElement plusicon;

    public ConPompage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void getPlusicon() {
        plusicon.click();
    }
}
