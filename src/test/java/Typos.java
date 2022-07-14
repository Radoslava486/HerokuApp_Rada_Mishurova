import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Typos extends BasicTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/typos");
    }



    @Test
    public void typosTest() {
        List<WebElement> notificationMessage = driver.findElements(By.tagName("p"));
        String actualResult = notificationMessage.get(1).getText();
        Assert.assertEquals(actualResult, "Sometimes you'll see a typo, other times you won't."," The word 'won,t' is misspelled");

    }
}
