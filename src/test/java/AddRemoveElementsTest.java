import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTest extends BasicTest {

        @BeforeMethod
        public void navigate() {
            driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        }

        @Test
        public void testButtons() {
            WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
            List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
            Assert.assertTrue(deleteButtons.isEmpty());
            addButton.click();
            addButton.click();
            deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
            deleteButtons.get(0).click();
            Assert.assertEquals(deleteButtons.size(), 1, "One button remains");
// этот провалился на проверке

        }
    }

