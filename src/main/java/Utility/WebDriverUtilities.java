package Utility;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Ashwini
 * This class contains all reusable methods from selenium library
 */
public class WebDriverUtilities {

    //public WebDriver driver = null;

//    // ==================== BROWSER ====================
//    public void launchTheBroweser(String browser) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        } else {
//            driver = new ChromeDriver();
//        }
//    }

    public void navigateToApplication(WebDriver driver, String url) {
        driver.get(url);
    }

    public String fetchthetittle(WebDriver driver) {
        return driver.getTitle();
    }

    public String fetchthecurrenturl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String fetchpagesource(WebDriver driver) {
        return driver.getPageSource();
    }

    // ==================== WINDOW ====================
    public void MaximizeThebrowser(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void MinimizeThebrowser(WebDriver driver) {
        driver.manage().window().minimize();
    }

    public void windowfullscreen(WebDriver driver) {
        driver.manage().window().fullscreen();
    }

    public Dimension fetchsize(WebDriver driver) {
        return driver.manage().window().getSize();
    }

    public Point fetchtheposition(WebDriver driver) {
        return driver.manage().window().getPosition();
    }

    public void setthesize(WebDriver driver,int height, int width) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void setposition(WebDriver driver,int x, int y) {
        driver.manage().window().setPosition(new Point(x, y));
    }

    // ==================== NAVIGATION ====================
    public void navigateToPriviousPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void navigatetonextpage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshthepage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void navigateToTheWebPage(WebDriver driver,String url) {
        driver.navigate().to(url);
    }

    // ==================== CLOSE ====================
    public void closedBrowser(WebDriver driver) {
        driver.close();
    }

    public void QuitBrowser(WebDriver driver) {
        driver.quit();
    }

    // ==================== WINDOWS ====================
    public String fetchTheParentWindowId(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public void swithtoWindowIdusing_tittle(WebDriver driver, String title) {
        for (String wid : driver.getWindowHandles()) {
            driver.switchTo().window(wid);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }
    public void switchtoWindowsUsingUrl(WebDriver driver, String partialUrl) {
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String wid : allWindowIds) {
            driver.switchTo().window(wid);
            if (driver.getCurrentUrl().contains(partialUrl)) {
                break;
            }
        }
    }

    public void swithbacktoParent(WebDriver driver, String parentId) {
        driver.switchTo().window(parentId);
    }


    // ==================== FRAMES ====================
    public void switchtoFrame_Index(WebDriver driver,int index) {
        driver.switchTo().frame(index);
    }

    public void switchtoFrameUsing_id(WebDriver driver,String id) {
        driver.switchTo().frame(id);
    }

    public void switchtoFrameUsing_element(WebDriver driver,WebElement ele) {
        driver.switchTo().frame(ele);
    }

    public void switchFromFrameToMainWindowPage(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void switchFromFrametoParentFrame(WebDriver driver,String pwid) {
        driver.switchTo().window(pwid);
    }

    // ==================== ALERT ====================
    public void switchto_Alert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void switchtoalert_usingCancle(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String switchToAlert_fetchthetext(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void switchToAlert_EnterText(WebDriver driver,String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    // ==================== WAIT ====================
    public void ImplicitWait(WebDriver driver,String time) {
        long timeout = Long.parseLong(time);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public void waitUntileEle_displayed(WebDriver driver,String time, WebElement ele) {
        long timeout = Long.parseLong(time);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitUntilElement_clickable(WebDriver driver,String time, WebElement ele) {
        long timeout = Long.parseLong(time);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void waitUntilTitleContains(WebDriver driver,String time, String title) {
        long timeout = Long.parseLong(time);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.titleContains(title));
    }

    // ==================== DROPDOWN ====================
    public void selectDDByIndex(WebDriver driver,WebElement ddel, int index) {
        new Select(ddel).selectByIndex(index);
    }

    public void selectDDByValue(WebDriver driver,WebElement ddel, String value) {
        new Select(ddel).selectByValue(value);
    }

    public void selectDDByText(WebDriver driver,WebElement ddel, String text) {
        new Select(ddel).selectByVisibleText(text);
    }

    public void DiselectDDByindex(WebDriver driver,WebElement ddel, int index) {
        new Select(ddel).deselectByIndex(index);
    }

    public void DiselectDDByValue(WebDriver driver,WebElement ddel, String value) {
        new Select(ddel).deselectByValue(value);
    }

    public void DiselectDDByText(WebDriver driver,WebElement ddel, String text) {
        new Select(ddel).deselectByVisibleText(text);
    }

    public void DiselectDDAll(WebDriver driver,WebElement ddel) {
        new Select(ddel).deselectAll();
    }

    public WebElement fetchFirstSelectedOption(WebDriver driver,WebElement ddel) {
        return new Select(ddel).getFirstSelectedOption();
    }

    public List<WebElement> fetchAllSelectOptions(WebDriver driver,WebElement ddel) {
        return new Select(ddel).getAllSelectedOptions();
    }

    public boolean Ismultiple(WebDriver driver,WebElement ddel) {
        return new Select(ddel).isMultiple();
    }

    // ==================== ACTIONS ====================
    public void dragAndDrop(WebDriver driver,WebElement src, WebElement dest) {
        new Actions(driver).dragAndDrop(src, dest).perform();
    }

    public void UsingMousehover(WebDriver driver, WebElement hover) {
        Actions act = new Actions(driver);
        act.moveToElement(hover).perform();
    }

    

    public void UsingRightClick(WebDriver driver,WebElement right) {
        new Actions(driver).contextClick(right).perform();
    }

    public void UsingScrollByAmount(WebDriver driver,int y) {
        new Actions(driver).scrollByAmount(0, y).perform();
    }

    public void UsingScrollByElement(WebDriver driver,WebElement ele) {
        new Actions(driver).scrollToElement(ele).perform();
    }

    public void UsingClickAndHold(WebDriver driver,WebElement ele) {
        new Actions(driver).clickAndHold(ele).perform();
    }

    public void DoubleClick(WebDriver driver,WebElement ele) {
        new Actions(driver).doubleClick(ele).perform();
        
    }

	
}
