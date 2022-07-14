package testsAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControls extends BaseTest {


    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void dynamicControlsTest() {
        By checkboxLocator = By.cssSelector("input[type=checkbox]");
        By inputEnablingButton = By.xpath("//button[text()='Enable']");
        By inputElement = By.cssSelector("input[type=text]");
        By removeButton = By.xpath("//button[text()='Remove']");

        driver.findElement(checkboxLocator).click();
        driver.findElement(removeButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        boolean isAbsent = driver.findElements(checkboxLocator).isEmpty();
        Assert.assertTrue(isAbsent);

        Assert.assertFalse(driver.findElement(inputElement).isEnabled());
        driver.findElement(inputEnablingButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String expectedResult = "11";
        driver.findElement(inputElement).sendKeys(expectedResult);
        Assert.assertEquals(driver.findElement(inputElement).getAttribute("value"), expectedResult);


    }
}
