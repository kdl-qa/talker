package com.talker.suits;

import com.talker.config.Driver;
import com.talker.test.ChatDialog;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by kdl on 03.02.16.
 */
public class Dialog {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static TouchActions touchScreen;

    Dialog() {
        driver = Driver.initDriver();
        wait = new WebDriverWait(driver, 4);
        touchScreen = new TouchActions(driver);
    }

//    @Test (priority = 1)
//    public void openMenu() throws InterruptedException {
//        ChatDialog dialog = new ChatDialog(driver, wait, touchScreen);
//        dialog.tapMenuIcon();
//    }

//    @Test (priority = 0)
//    public void checkDialogSendMsgStatus() throws InterruptedException {
//        ChatDialog dialog = new ChatDialog(driver, wait, touchScreen);
//        dialog.openDialogByName("Дима крАвченко");
//        dialog.sendDialogMsg();
//        dialog.checkSentMsgStatus();
//    }

    @Test (priority = 0)
    public void dialogSendGeoMsg() throws InterruptedException {
        ChatDialog dialog = new ChatDialog(driver,wait,touchScreen);
        dialog.openDialogByIndex(1);
        dialog.sendDialogGeo();
    }



}
