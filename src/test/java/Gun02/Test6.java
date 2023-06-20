package Gun02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.App.APIDEMOS;
import static utils.Device.SAMSUNG_A33;


public class Test6 extends BaseTest{

    public Test6(){
        super(SAMSUNG_A33, APIDEMOS);
    }

    @BeforeClass
    public void beforeClass(){
        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        By okButton2 = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
        click(continueButton);
        click("OK");
        click(okButton2);
    }


    @Test
    public void testService(){

        By  country = By.id("com.touchboarder.android.api.demos:id/edit");
        click("API Demos");
        click("Views");
        click("Auto Complete");
        click("1. Screen Top");
        sendKeys(country, "Turkey");
        click(country);
        sleep(2000);
        driver.hideKeyboard();
    }

    @Test
    public void testSwipe(){
        click("API Demos");
        click("Views");
        swipeV(.7, .4);
        swipeV(.6, .5);
        swipeV(.3, .5);
        swipeV(.3, .7);
        sleep(2000);
    }

}
