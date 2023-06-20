package Gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;

import java.net.MalformedURLException;
import java.time.Duration;

import static utils.Device.*;
import static utils.App.*;



public class Test5 {

    // Appium'u programaticly calistirmak icin
    AppiumDriverLocalService service;
    WebDriverWait wait;
    AppiumDriver<?> driver;


    public void startAppium(){
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();
    }


    public AppiumDriver<?> getDriver(Device device, App app){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:udid", device.getUdid());
        caps.setCapability("appium:version", device.getVersion());
        caps.setCapability("appium:deviceName",device.getDeviceName());
        caps.setCapability("platformName", device.getPlatformName());

        caps.setCapability("appium:appPackage", app.getAppPackage());
        caps.setCapability("appium:appActivity", app.getAppActivity());

        return new AndroidDriver<>(service.getUrl(), caps);
    }


    @BeforeTest
    public void beforeTest(){
        startAppium();
        driver = getDriver(SAMSUNG_A33, APIDEMOS);
        wait = new WebDriverWait(driver, 20);
    }


    @Test
    public void testService(){
        
        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        By okButton2 = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");

        By  country = By.id("com.touchboarder.android.api.demos:id/edit");

        click(continueButton);
        click("OK");
        click(okButton2);
        click("API Demos");
        click("Views");
        click("Auto Complete");
        click("1. Screen Top");
        sendKeys(country, "Turkey");
        click(country);
        sleep(3000);
        driver.hideKeyboard();
    }

    public void click(String text){
        click(textLocator(text));
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeys(By locator, CharSequence text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }


    public By textLocator(String text){
        return By.xpath("//*[@text='" + text + "']");
    }

    @AfterTest
    public void afterTest(){
        driver.closeApp();
        driver.quit();
        service.stop();
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
