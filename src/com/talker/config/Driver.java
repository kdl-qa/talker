package com.talker.config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by kdl on 02.02.16.
 */
public class Driver {
    public static AndroidDriver driver;

    public static AndroidDriver initDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Android");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("unicodeKeyboard", true);
//        capabilities.setCapability("resetKeyboard", true);
            capabilities.setCapability("appPackage", "ua.my.im.android.myua");
            capabilities.setCapability("appActivity", "ua.my.im.android.myua.screens.activities.LoginActivity");

            driver = new SwipeableDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//            driver = new SwipeableDriver(new URL("http://10.0.1.69:4745/wd/hub"), capabilities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

}
