import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class JUnitAssertionTest {
    @Test
    public void junitAssertionValidation() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.navigate().to("https://letcode.in/frame");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//p[contains(text(),'Consent')]")).click();
        List<WebElement> iFrameCnt = driver.findElements(By.xpath("//iframe"));
        System.out.println("Number of frames found "+iFrameCnt.size());
        //////Assertions.assertEquals(10,iFrameCnt.size());
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(iFrameCnt.size()).isEqualTo(9);
        System.out.println("Expected is not equal to Actual.");
        driver.switchTo().frame("firstFr");
        //driver.findElement(By.xpath("//label[contains(text(),'First Name')]/following::input[1]")).sendKeys("VKR");
        //driver.findElement(By.xpath("//label[contains(text(),'First Name')]/following::input[2]")).sendKeys("VKR");
        driver.findElement(By.xpath("//*[text()='Enter Details']/following::input[@placeholder='Enter name']")).sendKeys("VKR");
        driver.findElement(By.xpath("//*[text()='Enter Details']/following::input[@placeholder='Enter email']")).sendKeys("SRK");
        WebElement frameWebElement = driver.findElement(By.xpath("//iframe[@class='has-background-white']"));

        driver.switchTo().frame(frameWebElement);
        ////driver.findElement(By.name("email")).sendKeys("tet");
        driver.findElement(By.xpath("//*[@name='email' and @placeholder='Enter email']")).sendKeys("tet");
        driver.switchTo().defaultContent();
        //driver.findElement(By.partialLinkText("Watch")).click();
        driver.findElement(By.cssSelector(".navbar-item[routerlink='/letxpath']")).click();

        Assert.assertEquals("Save your time while inspecting elements",driver.findElement(By.xpath("//h2[@class='subtitle has-text-info']")).getText());
        ///driver.quit();


    }

}
