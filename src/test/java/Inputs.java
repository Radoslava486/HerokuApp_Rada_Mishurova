import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Inputs extends BasicTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/inputs");
    }



    @Test
    public void inputsTest() {
        driver.findElement(By.tagName("input")).sendKeys("jkk");
        String letterResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(letterResult, "", "Only numbers can be entered");

        driver.findElement(By.tagName("input")).sendKeys("2",Keys.ARROW_DOWN,
                Keys.ARROW_DOWN);
        String downResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(downResult, "0");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("12", Keys.ARROW_UP);
        String upResult = driver.findElement(By.xpath("//input")).getAttribute("value");
        assertEquals(upResult, "13");
    }
}
