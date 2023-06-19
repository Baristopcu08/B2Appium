package Gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;

import java.net.MalformedURLException;


public class Test4 {

    // Appium'u programaticly calistirmak icin
    AppiumDriverLocalService service;
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver;



    @BeforeTest
    public void beforeTest(){
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        //service.clearOutPutStreams();
        service.start();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("appium:udid", Device.SAMSUNG_A33.getUdid());
        caps.setCapability("appium:version", Device.SAMSUNG_A33.getVersion());
        caps.setCapability("appium:deviceName",Device.SAMSUNG_A33.getDeviceName());
        caps.setCapability("platformName", Device.SAMSUNG_A33.getPlatformName());

        caps.setCapability("appium:appPackage", App.APIDEMOS.getAppPackage());
        caps.setCapability("appium:appActivity", App.APIDEMOS.getAppActivity());

        driver = new AndroidDriver<>(service.getUrl(), caps);
        wait = new WebDriverWait(driver, 20);
    }


    @Test
    public void testService() throws MalformedURLException {
        
        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();

        By okButton = By.xpath("//*[@text='OK']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(okButton)).click();

        By okButton2 = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
        wait.until(ExpectedConditions.visibilityOfElementLocated(okButton2)).click();

        By apiDemosLink = By.xpath("//*[@text='API Demos']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(apiDemosLink)).click();

    }

    @AfterTest
    public void afterTest(){
        driver.closeApp();
        driver.quit();
        service.stop();
    }
}
