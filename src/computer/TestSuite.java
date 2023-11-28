package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 click on computer menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 click on Desktop
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        //verifyElements("error","Name: Z to A",By.xpath("//option[contains(text(),'Name: Z to A')]"));
        //Thread.sleep(2000);
        //desending order
        boolean decendingOrderValue = verifyTheListIsDescendingOrder(By.xpath("//select[@id='products-orderby']"));
        verifyElementsAssedingorder("Verify the Product will arrange in Decending order.", "true", String.valueOf(decendingOrderValue));

    }

    /**
     * Verify that list is in Ascending order
     */
    public boolean verifyTheListIsAscendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAscending = true;

        for (int i = 1; i < list.size(); i++) {
            // System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAscending = false;
            }
        }
        return isAscending;
    }

    /**
     * Verify that list is in decending order
     */
    public boolean verifyTheListIsDescendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isDescending = true;

        for (int i = 1; i < list.size(); i++) {
            // System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) {
                isDescending = false;
            }
        }
        return isDescending;
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 click on computer menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //2.2 click on Desktop
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        //select sort by asending
        boolean asendingOrderValue = verifyTheListIsAscendingOrder(By.xpath("//select[@id='products-orderby']"));
        verifyElementsAssedingorder("Verify the Product will arrange in aesending order.", "true", String.valueOf(asendingOrderValue));
        //  2.4 click on Add to cart
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        //2.5 Verify the Text "Build your own computer"
        verifyElements("error msg", "Build your own computer", By.xpath("//h1[normalize-space()='Build your own computer']"));
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByIndexFromDropDown(By.id("product_attribute_1"), "1");
        //  2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //        2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnCheckBoxAndRadioButton(By.id("product_attribute_5_10"));
        clickOnCheckBoxAndRadioButton(By.id("product_attribute_5_12"));
        //2.11 Verify the price "$1,475.00"
        verifyElements("error msg", "$1,475.00", By.xpath("//span[normalize-space() = '$1,475.00']"));
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        // 2.13 Verify the Message "The product has been added to your shopping cart" on To green Bar
        verifyElements("", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        //sleep(2);
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        //2.15 Verify the message "Shopping cart"
        verifyElements("", "Shopping cart", By.tagName("h1"));
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearElement(By.className("qty-input"));
        sendTextToElement(By.className("qty-input"), "2");
        clickOnElement(By.id("updatecart"));
        //        2.17 Verify the Total"$2,950.00"
        String updateCartValue = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals("$2,950.00", updateCartValue);
//        2.18 click on checkbox “I agree with the terms of service”
        clickOnCheckBoxAndRadioButton(By.id("termsofservice"));
//        2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        // sleep(2);
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyElements("Verify Total Price", "Welcome, Please Sign In!", By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
//        2.21Click on “CHECKOUT AS GUEST” Tab
        // sleep(2);
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
//        2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Prime");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Testing");
        sendTextToElement(By.id("BillingNewAddress_Email"), "prime123@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "Algeria");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "A-65, capthrone Avenue");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "NW12SW");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07432222225");
//        2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
//        2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnCheckBoxAndRadioButton(By.id("shippingoption_1"));
//        2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
//        2.26 Select Radio Button “Credit Card”
        clickOnCheckBoxAndRadioButton(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
//        2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");
//        2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Prime Test");
        sendTextToElement(By.id("CardNumber"), "5425233430109903");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "04");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");
        sendTextToElement(By.id("CardCode"), "456");
//        2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
//        2.30 Verify “Payment Method” is “Credit Card”
        verifyElements("Verify “Payment Method” is “Credit Card”", "Credit Card", By.xpath("//span[normalize-space()='Credit Card']"));
//        2.32 Verify “Shipping Method” is “Next Day Air”
        verifyElements("Verify “Shipping Method” is “Next Day Air”", "Next Day Air", By.xpath("//span[normalize-space()='Next Day Air']"));
//        2.33 Verify Total is “$2,950.00”
        verifyElements("Verify Total is “$2,950.00”", "$2,950.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
//        2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
//        2.35 Verify the Text “Thank You”
        verifyElements("Verify the Text “Thank you”", "Thank you", By.xpath("//h1[normalize-space()='Thank you']"));
//        2.36 Verify the message “Your order has been successfully processed!”
        verifyElements("Verify the message “Your order has been successfully processed!”", "Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
//        2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
//        2.38 Verify the text “Welcome to our store”
        verifyElements("Verify the text “Welcome to our store”", "Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
