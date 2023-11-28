package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
@Test
public void  verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
   // 1.1 Mouse Hover on “Electronics” Tab
    mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
    //1.2Mouse Hover on “Cell phones” and click
    mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
    clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
   // 1.3 Verify the text “Cell phones"
    verifyElements("error","Cell phones",By.xpath("//h1[normalize-space()='Cell phones']"));
    //2.4 Click on List View Tab
}
@Test
public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully(){
    // 1.1 Mouse Hover on “Electronics” Tab
    mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
    //1.2Mouse Hover on “Cell phones” and click
    mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
    clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
    // 1.3 Verify the text “Cell phones"
    verifyElements("error","Cell phones",By.xpath("//h1[normalize-space()='Cell phones']"));
//    2.4 Click on List View Tab
    clickOnElement(By.xpath("//a[normalize-space()='List']"));
//    2.5 Click on product name “Nokia Lumia 1020” link
    clickOnElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
//    2.6 Verify the text “Nokia Lumia 1020”
    clickOnElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
//    2.7 Verify the price “$349.00”
    verifyElements("","$349.00",By.xpath("//span[@id='price-value-20']"));
//    2.8 Change quantity to 2
    clearElement(By.xpath("//span[@id='price-value-20']"));
    sendTextToElement(By.xpath("//span[@id='price-value-20']"),"2");
//    2.9 Click on “ADD TO CART” tab
    clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
//    2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
    verifyElements("", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
//    After that close the bar clicking on the cross button.
    clickOnElement(By.xpath("//span[@title='Close']"));
//    2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    mouseHoverToElement(By.xpath("//a[normalize-space()='shopping cart']"));
    clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
//    2.12 Verify the message "Shopping cart"
    verifyElements("error","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));
//    2.13 Verify the quantity is 2
    verifyElements("error","2",By.xpath("//input[@class = 'qty-input']"));
//    2.14 Verify the Total $698.00
    verifyElements("","$698.00",By.xpath(",//span[text()='$698.00'][@class = 'product-subtotal']"));
//    2.15 click on checkbox “I agree with the terms of service”
    clickOnElement(By.id("termsofservice"));
//    2.16 Click on “CHECKOUT”
    clickOnElement(By.id("checkout"));
//    2.17 Verify the Text “Welcome, Please Sign In!”
    verifyElements("","Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')"));
//    2.18 Click on “REGISTER” tab
    clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
//    2.19 Verify the text “Register”
    verifyElements("","Register",By.xpath("//h1[contains(text(),'Register')]"));
//    2.20 Fill the mandatory fields
    clickOnElement(By.id("gender-male"));
    sendTextToElement(By.id("FirstName"), "mansi");
    sendTextToElement(By.id("LastName"), "patel");
    sendTextToElement(By.id("Email"), "mansi25@gmail.com");
    sendTextToElement(By.id("Password"), "1234@Ma");
    sendTextToElement(By.id("ConfirmPassword"), "1234@Ma");
//    2.21 Click on “REGISTER”Button
    clickOnElement(By.id("register-button"));
    //2.22 Verify the message “Your registration completed”
    verifyElements("Verify the message “Your registration completed”", "Your registration completed", By.xpath("//div[@class='result']"));
    //2.23 Click on “CONTINUE” tab
    clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    //2.24 Verify the text “Shopping card”
   // sleep(2);
    verifyElements("Verify the text “Shopping card”", "Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));
    //       clickOnElement(By.xpath("//a[normalize-space()='Log in']"));
//        sendTextToElement(By.id("Email"), "email");
//        sendTextToElement(By.id("Password"), "JamesBond123");
//        clickOnElement(By.xpath("//button[normalize-space()='Log in']"));
    //2.25 click on checkbox “I agree with the terms of service”
    clickOnElement(By.id("termsofservice"));
    //2.26 Click on “CHECKOUT”
    clickOnElement(By.id("checkout"));
    //2.27 Fill the Mandatory fields
    sendTextToElement(By.id("FirstName"), "mansi");
    sendTextToElement(By.id("LastName"), "patel");
    sendTextToElement(By.id("Email"), "mansi25@gmail.com");
    selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "Angola");
    sendTextToElement(By.id("BillingNewAddress_City"), "London");
    sendTextToElement(By.id("BillingNewAddress_Address1"), "Oxford Road");
    sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "NW1 2ZQ");
    sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07432543216");
    //2.28 Click on “CONTINUE”
    clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
    //2.29 Click on Radio Button “2nd Day Air ($0.00)”
    clickOnCheckBoxAndRadioButton(By.tagName("body"));
    //2.30 Click on “CONTINUE”
    clickOnElement(By.className("button-1 shipping-method-next-step-button"));
    //2.31 Select Radio Button “Credit Card”
    clickOnCheckBoxAndRadioButton(By.xpath("//label[normalize-space()='Credit Card']"));
    clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
    //2.32 Select “Visa” From Select credit card dropdown
    selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
    //2.33 Fill all the details
    sendTextToElement(By.id("CardholderName"), "James Bond");
    sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4001919257537193");
    sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "9");
    sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2026");
    sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
    //2.34 Click on “CONTINUE”
    clickOnElement(By.className("button-1 payment-info-next-step-button"));
    //2.35 Verify “Payment Method” is “Credit Card”
    verifyElements("Verify “Payment Method” is “Credit Card”", "Payment Method: Credit Card", By.xpath("//li[@class='payment-method']"));
    //2.36 Verify “Shipping Method” is “2nd Day Air”
    verifyElements("Verify “Shipping Method” is “2nd Day Air”", "Shipping Method: Next Day Air", By.xpath("//span[normalize-space()='Next Day Air']"));
    //2.37 Verify Total is “$698.00”
    verifyElements("Verify Total is “$698.00”", "Total:\t$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
    //2.38 Click on “CONFIRM”
    clickOnElement(By.className("button-1 confirm-order-next-step-button"));
    //2.39 Verify the Text “Thank You”
    verifyElements("Verify the Text “Thank You”", "Thank you", By.xpath("//h1[normalize-space()='Thank you']"));
    //2.40 Verify the message “Your order has been successfully processed!”
    verifyElements("Verify the message “Your order has been successfully processed!”", "Your order has been successfully processed!", By.xpath("//div[@class='section order-completed']//div[@class='title']"));
    //2.41 Click on “CONTINUE”
    clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
    //2.42 Verify the text “Welcome to our store”
    verifyElements("Verify the text “Welcome to our store”", "Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));
    //2.43 Click on “Logout” link
    clickOnElement(By.xpath("//a[normalize-space()='Log out']"));
    //2.44 Verify the URL is “https://demo.nopcommerce.com/”
    verifyElements("Verify the URL is “https://demo.nopcommerce.com/”", "https://demo.nopcommerce.com/", By.xpath("https://demo.nopcommerce.com/"));

}
    @After
    public void tearDown() {
        closeBrowser();
    }
}
