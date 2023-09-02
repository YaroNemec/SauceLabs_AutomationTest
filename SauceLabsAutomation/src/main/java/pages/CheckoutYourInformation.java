package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformation {

    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstNameTextBox;

    @FindBy(id = "last-name")
    WebElement lastNameTextBox;

    @FindBy(id = "postal-code")
    WebElement zipCodeTextBox;


    @FindBy(id="continue")
    WebElement continueButton;

    public CheckoutYourInformation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameTextBox(String firstName){

        firstNameTextBox.sendKeys(firstName);
    }

    public void setLastNameTextBox(String lastName){

        lastNameTextBox.sendKeys(lastName);
    }

    public void setZipCodeTextBox(String zipCode){

        zipCodeTextBox.sendKeys(zipCode);
    }

    public void clickOnContinueButton(){

        continueButton.click();
    }

}
