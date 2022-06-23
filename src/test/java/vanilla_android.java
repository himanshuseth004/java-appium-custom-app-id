import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class vanilla_android {
    public static String userName = System.getenv("LT_USERNAME") == null ? "LT_USERNAME"  //Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "LT_ACCESS_KEY" //Add accessKey here
            : System.getenv("LT_ACCESS_KEY");

    private static AppiumDriver driver;

    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Galaxy S20");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("isRealMobile", true);
            
            //Enter the Custom_ID here that was used to upload your application
            capabilities.setCapability("app", "ENTER_CUSTOM_ID_HERE");

            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("build", "Java Vanilla - iOS");
            capabilities.setCapability("name", "Sample Test Java");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);

            driver = new AppiumDriver(new URL("https://" +userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);

            MobileElement color = (MobileElement) driver.findElement(MobileBy.id("com.lambdatest.proverbial:id/color"));
            color.click();

            MobileElement text = (MobileElement) driver.findElement(MobileBy.id("com.lambdatest.proverbial:id/Text"));
            //Changes the text to proverbial
            text.click();

            //toast is visible
            MobileElement toast = (MobileElement) driver.findElement(MobileBy.id("com.lambdatest.proverbial:id/toast"));
            toast.click();

            //notification is visible
            MobileElement notification = (MobileElement) driver.findElement(MobileBy.id("com.lambdatest.proverbial:id/notification"));
            notification.click();


        } catch (AssertionError a) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            a.printStackTrace();
        }
        driver.quit();
    }
    }