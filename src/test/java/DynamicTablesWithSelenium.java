import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicTablesWithSelenium {

    @Test
    public void dynamicWebTables() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        ///Below lines pf code to deal with WebTable
//
//        driver.navigate().to("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
//        driver.manage().
//        window().maximize();
//        driver.findElement(By.xpath("//p[contains(text(),'Consent')]")).click();
//       List <WebElement> first = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
//        System.out.println("Column count is : "+first.size());
//        for(int k=0;k< first.size();k++){
//            System.out.println("column title at index "+k+" is "+first.get(k).getText());
//        }

        ////Handle frames
        driver.navigate().to("https://letcode.in/frame");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//p[contains(text(),'Consent')]")).click();
        List<WebElement> iFrameCnt = driver.findElements(By.xpath("//iframe"));
        System.out.println("Number of frames found "+iFrameCnt.size());




    }
}
