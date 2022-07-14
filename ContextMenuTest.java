package testsAdvanced;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ContextMenuTest extends BaseTest {


    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }


    @Test
    public void contextMenuTest() {
        WebElement whiteBoxLink = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(whiteBoxLink).build().perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedResult = "You selected a context menu";
        Assert.assertEquals(alertText, expectedResult);
        alert.accept();
        driver.switchTo().defaultContent();


    }
}