package cucumber.stepdefs;

import cucumber.pages.BaseTestCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.App;
import utils.Device;
import utils.Driver;

public class MyStepdefs extends BaseTestCucumber {

    @Given("^user opens \"(APIDEMOS|CALCULATOR)\" on the phone \"(SAMSUNG_A33|EMULATOR)\"$")
    public void userOpensOnThePhone(String app, String device) throws Throwable {
        driver = Driver.getDriver(Device.valueOf(device), App.valueOf(app));
        wait = new WebDriverWait(driver, 20);
        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        By okButton2 = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
        click(continueButton);
        click("OK");
        click(okButton2);
    }

    @When("^user clicks \"([^\"]*)\"$")
    public void userClicks(String text) throws Throwable {
        swipeUntil(text);
        click(text);
    }

    @Then("^\"([^\"]*)\" should be visible$")
    public void shouldBeVisible(String text) throws Throwable {
        waitFor(text);
    }
}
