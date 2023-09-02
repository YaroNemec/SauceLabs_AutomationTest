import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.HomeSocial;
import pages.LoginPage;
import pages.YourCartPage;
import pages.ProductDetailsPage;
import pages.CheckoutOverview;
import pages.CheckoutYourInformation;
import utilities.DriverManager;

public class Practica2 extends BaseTest {
    @Test
    public void TestBotonTwitter() throws InterruptedException {
        // Login
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);

        // Verificar que el login fue exitoso
        Assertions.assertTrue(homePage.pageTitleIsDisplayed());

         //Ingresar a pagina de Twitter
        homePage.clickOnSocialTwitter();
        Thread.sleep(1000);
        HomeSocial homeSocial = new HomeSocial(DriverManager.getDriver().driver);

        //Verificar que se ingresó a Twitter
        homeSocial.isTwitterPage();
        Thread.sleep(5000);
    }

    @Test
    public void TestBotonFacebook() throws InterruptedException {
        // Login
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);

        // Verificar que el login fue exitoso
        Assertions.assertTrue(homePage.pageTitleIsDisplayed());

        //Ingresar a pagina de Twitter
        homePage.clickOnSocialTwitter();
        Thread.sleep(1000);
        HomeSocial homeSocial = new HomeSocial(DriverManager.getDriver().driver);

        //Verificar que se ingresó a Facebook
        homeSocial.isFacebookPage();
        Thread.sleep(5000);
    }

    @Test
    public void TestBotonLinkedin() throws InterruptedException {
        // Login
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);

        // Verificar que el login fue exitoso
        Assertions.assertTrue(homePage.pageTitleIsDisplayed());

        //Ingresar a pagina de Twitter
        homePage.clickOnSocialTwitter();
        Thread.sleep(1000);
        HomeSocial homeSocial = new HomeSocial(DriverManager.getDriver().driver);

        //Verificar que se ingresó a Linkedin
        homeSocial.isLinkedInPage();
        Thread.sleep(5000);
    }

    @Test
    public void TestNumeroCarrito() throws  InterruptedException{
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnProduct();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(DriverManager.getDriver().driver);

        Assertions.assertTrue(productDetailsPage.isProductNameDisplayed("Sauce Labs Bike Light"));
        Assertions.assertTrue(productDetailsPage.imageProductIsDisplayed());
        Assertions.assertTrue(productDetailsPage.detailsProductIsDisplayed());
        Assertions.assertTrue(productDetailsPage.isProductPriceDisplayed("$9.99"));
        productDetailsPage.clickOnAddToCartButton();
        Assertions.assertTrue(productDetailsPage.isEqualNumberShoppingCartWithNumberProduct("1"));
        Thread.sleep(5000);
    }

    @Test
    public void TestBotonAbout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnBurgerButton();
        homePage.clickOnAboutLink();

        HomeSocial homeSocial = new HomeSocial(DriverManager.getDriver().driver);

        //Verificar que se ingresó a Linkedin
        homeSocial.isSauceLabsInPage();
        Thread.sleep(5000);

    }

    @Test
    public void TestResetPage() throws  InterruptedException{
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnProduct();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(DriverManager.getDriver().driver);

        productDetailsPage.clickOnAddToCartButton();
        Assertions.assertTrue(productDetailsPage.isEqualNumberShoppingCartWithNumberProduct("1"));

        productDetailsPage.clickOnBurgerButton();
        productDetailsPage.clickOnResetLink();
        Assertions.assertTrue(productDetailsPage.isEqualNumberShoppingCartWithNumberProduct(""));

        Thread.sleep(5000);
    }

    @Test
    public void TestCheckout() throws  InterruptedException{

        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
        yourCartPage.clickOnCheckoutButton();

        CheckoutYourInformation checkoutYourInformationPage = new CheckoutYourInformation(DriverManager.getDriver().driver);

        checkoutYourInformationPage.setFirstNameTextBox("Yaro");
        checkoutYourInformationPage.setLastNameTextBox("Nemec");
        checkoutYourInformationPage.setZipCodeTextBox("0000");
        checkoutYourInformationPage.clickOnContinueButton();

        CheckoutOverview checkoutOverviewPage = new CheckoutOverview(DriverManager.getDriver().driver);
        Assertions.assertTrue(checkoutOverviewPage.pageTitleOverviewIsDisplayed());
        Thread.sleep(5000);
    }


}
