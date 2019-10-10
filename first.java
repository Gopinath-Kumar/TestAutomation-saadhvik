package selenium;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.List;

public class first {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\GOPINATH\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.flipkart.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[contains(@class, '_2AkmmA _29YdH8')]")).click();
        driver.findElement(By.className("LM6RPg")).sendKeys("mobiles");
        driver.findElement(By.className("vh79eN")).click();
        ChromeOptions option = new ChromeOptions();
        option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        option.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        option.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,UnexpectedAlertBehaviour.IGNORE);
        driver.navigate().refresh();
        driver.findElement(By.id("pincodeInputId")).click();
        driver.findElement(By.id("pincodeInputId")).clear();
       /* driver.findElement(By.id("pincodeInputId")).click();
        driver.findElement(By.id("pincodeInputId")).sendKeys("600094")*/;
        driver.findElement(By.xpath("//*[contains(text(),'Check')]")).click();
        WebElement resText = driver.findElement(By.xpath("//span[contains(@class,'_2yAnYN')]"));
        String expectedText = resText.getText();
        System.out.println(expectedText);

        // Get the total list of rows
        List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'_1-2Iqu row')]"));
        int count = rows.size();
        final int expectedrow = 24;
        int rowCharRealme = 0;
        int rowCharRedmi = 0;
        System.out.println("Total no.of rows:" +count);

        // Verify total no.of rows is equals with expected
        Assert.assertTrue("Total no.of row count matchers", count == expectedrow);
        for(int i=0;i<count;i++) {
            String rowName = rows.get(i).getText();
            if(rowName.contains("Realme")){
                rowCharRealme = rowCharRealme + 1;
            }else if(rowName.contains("Redmi")){
                rowCharRedmi = rowCharRedmi + 1;
            }
        }
        // Verify total no.of rows that contains  Realme text
        System.out.println("Total No.of Rows with Realme Text : "+ rowCharRealme);

        // Verify total no.of rows that contains  Redmi text
        System.out.println("Total No.of Rows with Redmi Text : " + rowCharRedmi);
        driver.close();
    }
}
