package selenium_apis;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class FileUploadTest  {

    private WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test
    public void fileUploadUsingSendKeys() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file-upload"))).sendKeys(System.getProperty("user.dir") + "/src/test/resources/testdata/Inspiration.png");
        //driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/testdata/Inspiration.png");
        Thread.sleep(3000);

    }

    @Test
    public void fileUploadUsingRobotClass() throws AWTException, InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("drag-drop-upload")).click();
        Thread.sleep(3000);


        StringSelection filePath = new StringSelection(System.getProperty("user.dir") + "/src/test/resources/testdata/Inspiration.png" + "\n" +
                System.getProperty("user.dir") + "/src/test/resources/testdata/uml.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(3000);


    }

    @Test
    public void fileUploadUsingAutoIt() throws IOException {
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        Runtime.getRuntime().exec("path to .exe file");
    }
}
