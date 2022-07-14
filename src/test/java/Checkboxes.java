import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Checkboxes extends BasicTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }


    @Test
    public void selectCheckboxestest() {
       List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertEquals(checkBoxes.get(0).isSelected(), false, "the 1st checkbox is unchecked");
        checkBoxes.get(0).click();
        Assert.assertEquals(checkBoxes.get(0).isSelected(), true, "the 1st checkbox is checked");
        Assert.assertEquals(checkBoxes.get(1).isSelected(), true, "the 2nd checkbox is checked");
        checkBoxes.get(1).click();
        Assert.assertEquals(checkBoxes.get(1).isSelected(), false, "the 2nd checkbox is unchecked");
    }

}
