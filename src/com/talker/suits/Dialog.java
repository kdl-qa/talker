package com.talker.suits;

import com.talker.config.Driver;
import com.talker.config.Helpers;
import com.talker.data.DialogAndChats;
import com.talker.page_object.android.ScreenTitles;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.talker.page_object.android.ScreenTitles.*;
import static org.testng.Assert.assertTrue;


/**
 * Created by kdl on 03.02.16.
 */
public class Dialog {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static TouchActions touchScreen;
    DialogAndChats chatsTester;
    Helpers helper;

    Dialog() {
        driver = Driver.initDriver();
        wait = new WebDriverWait(driver, 5);
        touchScreen = new TouchActions(driver);
        chatsTester = new DialogAndChats(driver, wait, touchScreen);
        helper = new Helpers(driver, wait);
    }

    @Test (groups = {"sideBarNavigation"}, priority = 0, enabled = false)
    public void openMenu() throws InterruptedException {
        assertTrue(chatsTester.tapMenuIcon());
        assertTrue(chatsTester.tapSideBarMenuText("чаТы"));
    }

    @Test (groups = {"messaging"}, priority = 0, enabled = false)
    public void checkDialogSendMsgStatus() throws InterruptedException {
        chatsTester.openDialogByName("алексей берлин");
        chatsTester.sendDialogMsg();
        chatsTester.checkSentMsgStatus();
    }

    @Test (groups = {"messaging"}, priority = 1, enabled = true)
    public void dialogSendGeoMsg() throws InterruptedException {
        assertTrue(chatsTester.openDialogByIndex(1));
        assertTrue(helper.checkScreenTitle(DIALOG_SCREEN, "АЛЕКСЕЙ КОНОНЕНКО"));
        assertTrue(chatsTester.sendDialogGeo());
    }

    @Test (groups = {"messaging"}, priority = 2, enabled = false)
    public void dialogSendImageMsg() throws InterruptedException {
//        chatsTester.openDialogByIndex(1);
        assertTrue(chatsTester.sendDialogImage(0, 3));
    }

    @Test (groups = {"createDialog"}, priority = 0, enabled = false)
    public void us21_createDialog() throws InterruptedException {
//        assertTrue(helper.checkScreenTitle(ScreenTitles.CHATS_SCREEN, "Чаты"));
        assertTrue(helper.openChatsTab(0));
        chatsTester.createChatFromDialogTab("алексей берлин");
        assertTrue(helper.checkContactPresence("алексей берлин"));
        assertTrue(helper.tapOnContact("алексей берлин"));
    }



    @AfterClass
    public void closeApp() {
        driver.quit();
    }
}
