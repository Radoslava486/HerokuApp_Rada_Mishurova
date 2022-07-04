import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMessages extends BasicTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }



    @Test
    public void notificationMessageTest() {
        driver.findElement(By.xpath("<a href=\\\"/notification_message\\\">Click here</a>")).click();
        String expectedResult = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedResult, " Action unsuccesful, please try again");
    }
    //не нашел клик
}
