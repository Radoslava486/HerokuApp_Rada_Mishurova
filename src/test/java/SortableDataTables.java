import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableDataTables extends BasicTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/tables");
    }


    @Test
    public void tablesTest() {
       String actualResultName =  driver.findElement(By.xpath("//table//tr[2]//td[2]")).getText();
        Assert.assertEquals(actualResultName, "Frank");

        String actualResultDue =  driver.findElement(By.xpath("//table//tr[2]//td[4]")).getText();
        Assert.assertEquals(actualResultDue, "$51.00");

        String actualResultEmail =  driver.findElement(By.xpath("//table//tr[3]//td[3]")).getText();
        Assert.assertEquals(actualResultEmail, "jdoe@hotmail.com");

        //failed
    }
}
