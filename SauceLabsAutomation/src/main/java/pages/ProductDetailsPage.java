package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;

public class ProductDetailsPage {

    WebDriver driver;


    @FindBy(className = "inventory_details_name")
    WebElement productNameDetails;



    @FindBy(className = "inventory_details_img")
    WebElement imageProduct;


    @FindBy(className = "inventory_details_desc")
    WebElement detailsProduct;

    @FindBy(className = "inventory_details_price")
    WebElement priceDetails;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement AddToCartButton;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartDetails;


    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerButton;

    @FindBy(id = "reset_sidebar_link")
    WebElement ResetButton;


    public boolean isNotDisplayedCartLink(){
        boolean isDisplayed = shoppingCartDetails.isDisplayed();
        if (isDisplayed == true)
        {
            isDisplayed = false;
        }
        else
        {
            isDisplayed= true;
        }
        return  isDisplayed;
    }
    public void clickOnResetLink(){
        WebElement logoutLink = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link")));
        logoutLink.click();
    }

    public void clickOnBurgerButton(){
        burgerButton.click();
    }

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductNameDisplayed(String productNamePage) {
        if (productNameDetails.getText().equalsIgnoreCase(productNamePage)) {
            return true;
        }
        return false;
    }



    public boolean imageProductIsDisplayed(){
        boolean imageProductIsDisplayed = imageProduct.isDisplayed();
        return imageProductIsDisplayed;
    }


    public boolean detailsProductIsDisplayed(){
        boolean detailsProductIsDisplayed = detailsProduct.isDisplayed();
        return detailsProductIsDisplayed;
    }



    public boolean isProductPriceDisplayed(String productPrice) {
        if (priceDetails.getText().equalsIgnoreCase(productPrice)) {
            return true;
        }
        return false;
    }

    public void clickOnAddToCartButton(){
        AddToCartButton.click();
    }

    public boolean isEqualNumberShoppingCartWithNumberProduct(String numberAddToCart){
        if(shoppingCartDetails.getText().equalsIgnoreCase(numberAddToCart)){
            return true;
        }
        return false;
    }


}
