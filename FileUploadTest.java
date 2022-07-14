package testsAdvanced;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }


    @Test
    public void fileUploadTest() {
        driver.findElement(By.cssSelector("input[id=file-upload]")).sendKeys(System.getProperty("user.dir") + "/src/test/java/Typos.java");
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "Typos.java");

    }
}
