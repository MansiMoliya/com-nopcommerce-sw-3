package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    String menu, expectedText, actualText;

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        List<WebElement> menulist = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
        for (WebElement name : menulist) {
            System.out.println(name.getText());
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
            // menu=getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        }
    }

    //  clickonElement(By.xpath("//ul[@class='top-menu notmobile']/li"));
    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        verifyElements("error msg", "Computers", By.xpath("//h1[contains(text(),'Computers')]"));
    }
    @Test
    public void verifyApparel(){
        selectMenu("Apparel");
        verifyElements("error msg","Apparel",By.xpath("//h1[contains(text(),'Apparel')]"));
    }

    @After
    public void tearDown() {
        //   closeBrowser();
    }
}
