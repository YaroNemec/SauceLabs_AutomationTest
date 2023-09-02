package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement pageTitleOverview;


    public CheckoutOverview(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean pageTitleOverviewIsDisplayed(){
        boolean pageTitleOverviewDisplayed = pageTitleOverview.isDisplayed();
        return pageTitleOverviewDisplayed ;
    }


}
