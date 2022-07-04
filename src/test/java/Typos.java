import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Typos extends BasicTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/typos");
    }



    @Test
    public void typosTest() {
        String actualResult = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actualResult, "Sometimes you'll see a typo, other times you won't."," The word 'won,t' is misspelled");
    //:(
    }
}
