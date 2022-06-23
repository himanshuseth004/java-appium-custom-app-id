import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class vanilla_ios {

    public static String userName = System.getenv("LT_USERNAME") == null ? "LT_USERNAME"  //Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "LT_ACCESS_KEY" //Add accessKey here
            : System.getenv("LT_ACCESS_KEY");

    public static IOSDriver driver = null;

    public static void main(String[] args) throws Exception {

       try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformVersion", "15");
            caps.setCapability("deviceName", "iPhone 12");
            caps.setCapability("isRealMobile", true);
            
            //Enter the Custom_ID here that was used to upload your application
            caps.setCapability("app", "ENTER_CUSTOM_ID_HERE");
         
            caps.setCapability("platformName", "iOS");
            caps.setCapability("build", "Java Vanilla - iOS");
            caps.setCapability("name", "Sample Test Java");
            caps.setCapability("devicelog", true);
            caps.setCapability("network", true);

        driver = new IOSDriver(new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), caps);


            Thread.sleep(2000);

            driver.findElement(MobileBy.id("color")).click();
            Thread.sleep(1000);

            driver.findElement(MobileBy.id("Text")).click();
            Thread.sleep(1000);
            driver.findElement(MobileBy.id("toast")).click();
            Thread.sleep(1000);
            driver.findElement(MobileBy.id("notification")).click();
            Thread.sleep(2000);

            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
            driver.quit();

        } catch (Exception t) {
           System.out.println(t);
           driver.quit();

       }
    }
}