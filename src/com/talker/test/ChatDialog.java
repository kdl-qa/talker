package com.talker.test;

import com.android.ddmlib.Log;
import com.talker.data.Messages;
import com.talker.page_object.android.Chats;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kdl on 02.02.16.
 */
public class ChatDialog {
    public ChatDialog(AndroidDriver driver, WebDriverWait wait, TouchActions touchScreen) {
        this.wait = wait;
        this.touchScreen = touchScreen;
        this.driver = driver;

        PageFactory.initElements(driver, Chats.class); //path to locator class???
    }

    private WebDriverWait wait;
    private TouchActions touchScreen;
    private WebDriver driver;


    public void tapActionBarTab(int index) {
        Chats.actionTabs.get(index).click();
    }

    public void tapMenuIcon() {
        if (Chats.actionBar.isDisplayed() & Chats.chatsTitle.isDisplayed()) {
            Chats.menuIcon.click();
        } else {
            System.out.println("Tap on the Menu button is failed!!!");
        }
    }

    public void openDialogByIndex(int index) {
        if (Chats.actionBar.isDisplayed() & Chats.chatsTitle.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("list_chats")));
            if (Chats.dialogName.isEmpty()) {
                System.out.println("You don't have any chats");
            } else {
                Chats.dialogName.get(index).click();
            }
        }
    }

    public void openDialogByName(String name) {
        if (Chats.actionBar.isDisplayed() & Chats.chatsTitle.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("list_chats")));
            if (Chats.dialogName.isEmpty()) {
                System.out.println("You don't have any chats");
            } else {
                for (WebElement dialog_name : Chats.dialogName) {
                    if (dialog_name.getText().equalsIgnoreCase(name)) {
                        dialog_name.click();
                        break;
                    } else {
                        System.out.println("It isn't dialog with the " + name + " !!!");
                    }
                }
            }
        }
    }

    public void sendDialogMsg() {
        if (Chats.msgBox.isDisplayed()) {
            Chats.msgTextField.click();
            Chats.msgTextField.sendKeys(Messages.simpleMsg);
            Chats.sendBtn.click();
        }
    }

    public void checkSentMsgStatus() {
        sendDialogMsg();
        if (Chats.bubbleMsgs.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bubble")));
        }
        for (WebElement msg : Chats.msgsLayout) {
            if (!msg.findElement(By.id("text_view_message")).getText().contentEquals(Messages.simpleMsg)) {
                continue;
            }
            if (msg.findElement(By.id("text_view_message")).getText().contentEquals(Messages.simpleMsg)) {
                System.out.println("You found a sent message: " + msg.findElement(By.id("text_view_message")).getText());
                System.out.println("Time of the message: " + msg.findElement(By.id("text_view_date")).getText());
            }
            try {
                Boolean status = msg.findElement(By.id("text_view_status")).isDisplayed();
                if (
                        msg.findElement(By.id("text_view_date")).isDisplayed() &&
                        msg.findElement(By.id("text_view_message")).getText().contentEquals(Messages.simpleMsg) &&
                        status) {
                    switch (msg.findElement(By.id("text_view_status")).getText()) {
                        case Messages.msgStatus0:
                            System.out.println("Message delivered to server!");
                            break;
                        case Messages.msgStatus1:
                            System.out.println("Message delivered to receiver!");
                            break;
                        default:
                            break;
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Message status is not displayed!");
            }

        }
    }

    public void sendDialogGeo() {
        if (Chats.msgBox.isDisplayed()) {
            Chats.attachIcon.click();
            Chats.attachList.get(0).click();
        }
    }

    public void sendDialogImage() {
        if (Chats.msgBox.isDisplayed()) {
            Chats.attachIcon.click();
            Chats.attachList.get(1).click();
        }
        if (!Chats.list.isEmpty()) {
            Chats.list.get(0).click();
//            for (WebElement image = Chats.list; ) //todo finish send images
        }
    }



}
