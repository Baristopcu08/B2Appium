package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    private static AppiumDriverLocalService service;
    private static AppiumDriver<?> driver;


    private static void startAppium(){
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();
    }

    public static AppiumDriver<?> getDriver(){
        if (driver != null)
            return driver;
        else
            throw new RuntimeException("Driver is not created");
    }


    public static AppiumDriver<?> getDriver(Device device, App app){
        if (driver == null) {
            startAppium();
            String apkPath = "src/test/resources/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:udid", device.getUdid());
            caps.setCapability("appium:version", device.getVersion());
            caps.setCapability("appium:deviceName", device.getDeviceName());
            caps.setCapability("platformName", device.getPlatformName());
            if (app.app.length()>0)
                caps.setCapability("appium:app", apkPath + app.app);

            caps.setCapability("appium:appPackage", app.getAppPackage());
            caps.setCapability("appium:appActivity", app.getAppActivity());

            driver = new AndroidDriver<>(service.getUrl(), caps);
        }
        return driver;
    }

    public static void stop(){
        driver.quit();
        service.stop();
    }

    /*
        RemoteWebDriver
            WebDriver
                AppiumDriver
                    AndroidDriver
                    IOSDriver


        WebElement
            AndroidElement
            IOSElement


     */


}
