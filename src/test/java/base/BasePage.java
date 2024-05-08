package base;

import helper.LoggerHelper;
import helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static base.BaseTest.driver;

public class BasePage {

    final static Logger log = LoggerHelper.getLogger(BasePage.class);
    @FindBy(css = ".//*")
    private List<WebElement> allPageElements;
    @FindBy(css = "a.navbar-brand")
    private WebElement logo;
    @FindBy(css = "a")
    private WebElement aTag;


    public BasePage() {

    }

    public WebElement getLogo() {
        return logo;

    }

    public List<WebElement> getAllElements() {
        log.info(allPageElements.size());
        return allPageElements;

    }

    public void getRectHeightAndWidthOfAnElement(WebElement element) {
        Point p = element.getLocation();
        log.info(p.getX());
        log.info(p.getY());
        Rectangle r = element.getRect();
        log.info(r.getX());
        log.info(r.getY());
    }

    public boolean checkForTitle(WebDriver driver, String title) {
        log.info(title);
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException(title);
        return driver.getTitle().trim().contains(title);
    }

    public boolean assertLogoIsDisplayed() {
        log.info("Logo is displayed: " + logo.isDisplayed());
        return new VerificationHelper(driver).isDisplayed(logo);

    }

    public String getLogoText() {
        return new VerificationHelper(driver).getText(logo);

    }

    public void clickLogoImage() {
        if (logo.isDisplayed() && logo.isEnabled()) {
            log.info("Logo is displayed: " + logo.isDisplayed());
            log.info("Logo is enabled: " + logo.isEnabled());
        }
        logo.click();

    }

    public String getTitle() {
        log.info("Title is: " + driver.getTitle());
        return new VerificationHelper(driver).getCurrentPageTitle();
    }


    public String getCurrentPageTitle() {
        log.info("Title is: " + driver.getTitle());
        return new VerificationHelper(driver).getTitle();
    }

    public String getCurrentPageUrl() {
        log.info("Current Page Url is: " + driver.getCurrentUrl());
        return new VerificationHelper(driver).getCurrentPageUrl();
    }


}
