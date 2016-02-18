package com.talker.suits;

import com.talker.config.Driver;
import com.talker.data.DialogAndChats;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by kdl on 16.02.16.
 */
public class Groups {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static TouchActions touchScreen;
    DialogAndChats chatsTester;

    Groups() {
        driver = Driver.initDriver();
        wait = new WebDriverWait(driver, 5);
        touchScreen = new TouchActions(driver);
        chatsTester = new DialogAndChats(driver, wait, touchScreen);
    }

    @Test (groups = {"createGroup"}, priority = 0, enabled = true)
    public void createGroupFromDialog() throws InterruptedException {
    assertTrue(chatsTester.createChatFromDialogTab("алексей кононенко"));
    }

    @AfterTest
    public void closeApp() {
        driver.quit();
    }

}
