package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //Click method
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
   /* public String getTextFromvalue(By by){
        return driver.findElement(by).getAttribute("");
    }*/

    //verified Data
    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    //selectDropdown by text
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        //create the object of select class
        Select select = new Select(dropdown);
       select.selectByValue(value);
        //select.selectByVisibleText(text);
       // select.selectByIndex(1);
    }
    public void selectByVisibleTextFromDropDown(By by,String text){
        WebElement dropdown=driver.findElement(by);
        //create the object of select class
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    //selectdropdown by index
    public void selectByIndexFromDropDown(By by, String index) {
        WebElement dropdown = driver.findElement(by);
        //create the object of select class
        Select select = new Select(dropdown);
        select.selectByIndex(Integer.parseInt(index));
    }
    /**
     * Click on checkbox with condition
     */
    public void clickOnCheckBoxAndRadioButton(By by) {
        WebElement element = driver.findElement(by);
        if(!element.isSelected()){
            element.click();
        }
    }
   //Asending order and desending order
    public void verifyElementsAssedingorder(String displayMessage, String expectedMessage, String actualValue) {
        Assert.assertEquals(displayMessage, expectedMessage, actualValue);
    }
    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    public void clearElement(By by){
        driver.findElement(by).clear();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

}
