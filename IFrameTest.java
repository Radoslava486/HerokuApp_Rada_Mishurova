package testsAdvanced;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void IFrameTest() {

        driver.switchTo().frame("mce_0_ifr");
        String frameText = driver.findElement(By.cssSelector("#tinymce p")).getText();
        String expectedResult = "Your content goes here.";
        Assert.assertEquals(frameText, expectedResult);

    }

}

