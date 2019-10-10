import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class First {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.airasia.com/en/gb");
        driver.manage().window().maximize();
        Thread.sleep(7000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-title-flight")));
        //  WebElement flight = driver.findElement(By.id("product-tile-flight"));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginModal")));
        title.click();
        WebElement closeModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sso-close-btn")));
        closeModal.click();
        /*Actions action = new Actions(driver);
        action.moveToElement(title).click();
        action.moveByOffset(860, 66).build().perform();
        try{
        Thread.sleep(5000);
        action.click();
        }catch (Exception e){
        }
        */
        WebElement dropdown1 = driver.findElement(By.id("home-origin-autocomplete-heatmap"));
        dropdown1.click();
        driver.findElement(By.xpath("//*[@id='home-origin-autocomplete-heatmaplist-4']//span[text()='Ahmedabad']")).click();
//        WebElement dropdown2 = driver.findElement(By.xpath("//input[@id='home-destination-autocomplete-heatmap']"));
//        dropdown2.click();
        Thread.sleep(5000);
        /*driver.findElement(By.xpath("home-destination-autocomplete-heatmap")).sendKeys("Bali");*/
        driver.findElement(By.xpath("//li[@id='home-destination-autocomplete-heatmaplist-0']//span[text()='Bali']")).click();
        driver.findElement(By.id("home-depart-date-heatmap")).click();
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='radiobuttons'][2]")));
        driver.findElement(By.xpath("//label[contains(text(),'One way')]")).click();
        driver.findElement(By.id("home-depart-date-heatmap")).click();
        WebElement dates = driver.findElement(By.xpath("//*[@id='wcaMainContent']//div[2]//table//tr[3]//td[5]"));
        dates.click();
        WebElement calendarConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("calendar-button"))));
        calendarConfirm.click();
        driver.findElement(By.id("home-flight-search-airasia-button-inner-button-select-flight-heatmap")).click();
        Thread.sleep(6000);
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginModal")));
        title.click();
        closeModal.click();
        WebElement highAmt = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='airasia-fares-div-fare-to-hover-0-1-heatmap']/div"))));
        highAmt.click();
        WebElement lowAmt = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='airasia-fares-div-fare-to-hover-0-0-heatmap']//div"))));
        lowAmt.click();
        driver.findElement(By.id("select-bottom-booking-summary-airasia-button-inner-button-booking-summary-heatmap")).click();
        driver.findElement(By.id("addons-bottom-booking-summary-airasia-button-inner-button-booking-summary-heatmap")).click();
        String totalFare = driver.findElement(By.id("amount-text")).getText();
        driver.findElement(By.xpath("//*[@id='adult-0-addinfant-heatmap']/button")).click();
        String changedFare = driver.findElement(By.id("amount-text")).getText();
        Assert.assertFalse(totalFare.equalsIgnoreCase(changedFare),"This is wrong fare");
    }
}