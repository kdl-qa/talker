package com.talker.config;

import com.talker.page_object.android.Chats;
import com.talker.page_object.android.Contacts;
import com.talker.page_object.android.ScreenTitles;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by kdl on 02.02.16.
 */
public class Helpers {

    private WebDriverWait wait;
    private TouchActions touchScreen;
    private AndroidDriver driver;

    public Helpers(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.touchScreen = touchScreen;
    }


    public static String generateText(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public void findAndClickGivenElement(WebDriver driver, List<WebElement> listOfElements, WebElement lastListElem, WebDriverWait wait, TouchActions touchScreen, String elementToFind) {
        while (true) {
            if (checkElementPresence(listOfElements, elementToFind)) {
                WebElement c = driver.findElement(By.name(elementToFind));
                c.click();
                break;
            } else {
                wait.until(presenceOfElementLocated(By.id("list")));
                touchScreen.flick(lastListElem, 0, -600, 80).perform();
            }
        }
    }


    // check given list for element presence
    public static boolean checkElementPresence(List<WebElement> listOfElements, String elementToFind) {
        for (WebElement elem : listOfElements) {
            System.out.println(elem.getText());
            if (elem.getText().equals(elementToFind)) { //also we could use "contains" to search
                System.out.println("true");
                elem.click();
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    public boolean openChatsTab(int actionTab) {
        switch (actionTab) {
            case 0:
                Chats.actionTabs.get(0).click();
                break;
            case 1:
                Chats.actionTabs.get(1).click();
                break;
            case 2:
                Chats.actionTabs.get(2).click();
                break;
            default:
                return false;
        }
        return true;
    }

    public boolean checkChatPresence(String chatName) {
        for (WebElement contact : Chats.dialogName)
            if (contact.getText().equalsIgnoreCase(chatName)) {
                break;
            } else System.out.println("Chat has another name!");
        return true;
    }

    public boolean checkContactPresence(String contactName) {
        for (WebElement contact : Contacts.contactName)
            if (contact.getText().equalsIgnoreCase(contactName)) return true;
        return false;
    }


    public boolean tapOnContact(String contactName) {
        for (WebElement contact : Contacts.contactName)
            if (contact.getText().equalsIgnoreCase(contactName)) {
                contact.click();
            }
        return false;
    }

    public boolean checkScreenTitle(ScreenTitles screenTitle, String expectedScreenTitle) {
        switch (screenTitle) {
            case CHATS_SCREEN:
                wait.until(ExpectedConditions.visibilityOf(Chats.chatsScreenTitle));
                return Chats.chatsScreenTitle.getText().equals(expectedScreenTitle);
            case DIALOG_SCREEN:
            case GROUP_SCREEN:
//                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(Chats.chat_title)));
                wait.until(ExpectedConditions.visibilityOf(Chats.chatTitle));
                return Chats.chatTitle.getText().equals(expectedScreenTitle);
            case VENUE_SCREEN:
                return true;
            case CREATE_CHAT_SCREEN:
                return true;
            case CONTACTS_SCREEN:
                return true;
            case CONTACT_PROFILE_SCREEN:
                return true;
            default:
                return false;
        }
    }


}
