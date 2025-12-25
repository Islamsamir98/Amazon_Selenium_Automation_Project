package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    //driver
    private WebDriver driver;
    WebDriverWait wait;

    //constructor
    public HomePage(WebDriver driver){this.driver=driver;}


    //locators, Elements
    private By ArrowButton = By.xpath("//div[@id=\"nav-link-accountList\"]//button[@class=\"nav-flyout-button nav-icon nav-arrow\"]");
    private By SignInButton = By.xpath("//span[@class=\"nav-action-inner\"]");
    private By Login_Mail = By.xpath("//input[@id=\"ap_email_login\"]");
    private By ContinueButton = By.xpath("//input[@class=\"a-button-input\"]");
    private By Password = By.xpath("//input[@id=\"ap_password\"]");
    private By LoginButton = By.xpath("//input[@id=\"signInSubmit\"]");
    private By NotNowButton = By.xpath("//a[@id=\"ap-account-fixup-phone-skip-link\"]");
    private By AllMenu = By.xpath("//a[@id=\"nav-hamburger-menu\"]");
    private By SeeMore = By.xpath("//a[@aria-label=\"See All Categories\"]");
    private By VideoGames = By.xpath("//div[@id=\"hmenu-content\"]//a[normalize-space()='Video Games']");
    private By AllVideoGames = By.xpath("//div[@id='hmenu-content']//a[normalize-space()='All Video Games']");
    private By FreeShipping = By.xpath("//*[@id=\"s-refinements\"]/div[2]/ul/li/span/a/div[1]/label/i");
    private By New = By.xpath("//span[text()='New']");
    private By DropDown = By.xpath("//span[@class=\"a-button-text a-declarative\"]");
    private By HighToLow = By.xpath("//*[@id=\"s-result-sort-select_2\"]");
    private By AddToCart = By.xpath("//span[@class=\"nav-cart-icon nav-sprite\"]");
    private By ProceedToBuy = By.xpath("//input[@name=\"proceedToRetailCheckout\"]");
    private By DeliverButton = By.xpath("//input[@data-testid=\"bottom-continue-button\"]");
    private By PaymentButton = By.xpath("//input[@data-csa-c-slot-id=\"checkout-primary-continue-payselect\"]");















    //Methods
    public void navigateToURL (String URL) { driver.get(URL);}
    public void clickOnArrowButton(){driver.findElement(ArrowButton).click();}
    public void clickOnSignInButton(){driver.findElement(SignInButton).click();}
    public void clickOnLogin_Mail(String Mail){driver.findElement(Login_Mail).sendKeys(Mail);}
    public void clickOnContinueButton(){driver.findElement(ContinueButton).click();}
    public void clickOnPassword(String password){driver.findElement(Password).sendKeys(password);}
    public void clickOnLoginButton(){driver.findElement(LoginButton).click();}
    public void clickOnNotNowButton(){driver.findElement(NotNowButton).click();}
    public void clickOnAllMenu(){driver.findElement(AllMenu).click();}
    public void clickOnSeeMore(){driver.findElement(SeeMore).click();}
    public void clickOnVideoGames(){driver.findElement(VideoGames).click();}
    public void clickAllVideoGames(){driver.findElement(AllVideoGames).click();}
    public void clickOnFreeShipping(){driver.findElement(FreeShipping).click();}
    public void clickOnNew(){driver.findElement(New).click();}
    public void clickOnDropDown(){driver.findElement(DropDown).click();}
    public void clickOnHighToLow(){driver.findElement(HighToLow).click();}
    public void AddToCart(){driver.findElement(AddToCart).click();}
    public void ProceedToBuy(){driver.findElement(ProceedToBuy).click();}
    public void DeliverButton(){driver.findElement(DeliverButton).click();}
    public void PaymentButton(){driver.findElement(PaymentButton).click();}











}
