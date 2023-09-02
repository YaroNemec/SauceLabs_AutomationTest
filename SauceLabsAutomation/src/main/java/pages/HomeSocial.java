package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeSocial {
    WebDriver driver;
    @FindBy(className = "css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0")
    WebElement pageTitle;
    public HomeSocial(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTwitterPage() {
        return driver.getCurrentUrl().contains("twitter.com/saucelabs");
    }

    public boolean isLinkedInPage() {
        return driver.getCurrentUrl().contains("linkedin.com");
    }
    public boolean isFacebookPage() {
        return driver.getCurrentUrl().contains("facebook.com/saucelabs");
    }

    public boolean isSauceLabsInPage() {
        return driver.getCurrentUrl().contains("https://saucelabs.com/");
    }

}
