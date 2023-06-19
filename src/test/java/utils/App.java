package utils;

public enum App {

    APIDEMOS(
            "com.touchboarder.android.api.demos",
            "com.touchboarder.androidapidemos.MainActivity"
    ),

    CALCULATOR(
            "com.sec.android.app.popupcalculator",
            "Calculator"
    )
    ;

    String appPackage;
    String appActivity;

    App(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }
}
