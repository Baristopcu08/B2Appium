package Gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Test2 {

    // Appium'u programaticly calistirmak icin
    AppiumDriverLocalService service;

    @BeforeTest
    public void beforeTest(){
        // appium'un hangi IP ve Port'tan calistirilmasi gerektigini belirtiyorum
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(4723)        // 4723 portundan calissin
                .usingAnyFreePort()         // bos olan herhangi porttan calissin
                .build();
        service.start();
    }

    @Test
    public void testService() throws MalformedURLException {

        // baglanti bilgileri icin desired capabilities olusturuldu
        DesiredCapabilities caps = new DesiredCapabilities();

        // baglanilacak cihaz bilgileri girildi
        caps.setCapability("appium:udid", "RZCT40MN7MY");
        caps.setCapability("appium:version", "12");
        caps.setCapability("appium:deviceName","Samsung A33");
        caps.setCapability("platformName", "Android");

        // kullanilacak App'in appPackage ve appActivity'si
        /* cmd'de
            adb shell
	            dumpsys window | grep -E 'mCurrentFocus'
         */
        caps.setCapability("appium:appPackage", "com.touchboarder.android.api.demos");
        caps.setCapability("appium:appActivity", "com.touchboarder.androidapidemos.MainActivity");

        // driver tanimliyoruz
        AppiumDriver<MobileElement> driver;

        driver = new AndroidDriver<>(service.getUrl(), caps);


        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        driver.findElement(continueButton).click();

        By okButton = By.xpath("//*[@text='OK']");
        driver.findElement(okButton).click();

        By okButton2 = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
        driver.findElement(okButton2).click();

        By apiDemosLink = By.xpath("//*[@text='API Demos']");
        driver.findElement(apiDemosLink).click();

        driver.closeApp();
        driver.quit();

    }

    @AfterTest
    public void afterTest(){
        service.stop();
    }
}
