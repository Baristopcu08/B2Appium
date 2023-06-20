package Gun02;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;

public class Test7 extends BaseTest{


    public Test7() {
        super(Device.SAMSUNG_A33, App.APIDEMOS);
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
    public void test1(){
        click("API Demos");
        click(("Views"));
        click("Controls");
        click("01. Light Theme");


        By textField1 = xpathWithAttribute("edit");
        By textField2 = xpathWithAttribute("edit",2);
        //By checkBox1 = By.id("com.touchboarder.android.api.demos:id/check1");
        By checkBox1 = xpathWithAttribute("check1");
        By checkBox2 = By.id("com.touchboarder.android.api.demos:id/check2");
        By radio1 = By.id("com.touchboarder.android.api.demos:id/radio1");
        //By radio2 = By.id("com.touchboarder.android.api.demos:id/radio2");
        By radio2 = xpathWithAttribute("radio2");
        By star = By.id("com.touchboarder.android.api.demos:id/star");
        By toggle1 = By.id("com.touchboarder.android.api.demos:id/toggle1");
        By toggle2 = By.id("com.touchboarder.android.api.demos:id/toggle2");
        By dropDown = By.id("android:id/text1");

        sendKeys(textField1, "Text-1");
        sendKeys(textField2, "Text-2");
        click(checkBox1);
        Assert.assertEquals(driver.findElement(checkBox1).getAttribute("checked"), "true");
        click(radio2);

        System.out.println(driver.findElement(toggle1).getText());
        click(toggle1);
        System.out.println(driver.findElement(toggle1).getText());

        driver.hideKeyboard();
        click(dropDown);
        click("Jupiter");
        sleep(3000);

    }


    @Test
    public void testNotification(){
        click("API Demos");
        click(("App"));
        click(("Notification"));
        click(("IncomingMessage"));
        click(("SHOW APP NOTIFICATION"));
        swipeV(0, .5);
        By notifyText = By.xpath("//*[contains(@text, 'dinner')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(notifyText));
        swipeV(.5, .1);

    }


    @Test
    public void testNotification2(){
        click("API Demos");
        click(("App"));
        click(("Notification"));
        click(("IncomingMessage"));
        click(("SHOW APP NOTIFICATION"));
        ((AndroidDriver<?>) driver).openNotifications();

        waitFor("dinner", "hungry");
        driver.navigate().back();

    }

}
