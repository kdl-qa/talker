package com.talker.page_object.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by kdl on 02.02.16.
 */
public class Chats {

    @FindBy(className = "android.support.v7.app.ActionBar$Tab")
    public static List<WebElement> actionTabs;

    @FindBy(id = "toolbar")
    public static WebElement actionBar;

    @FindBy(className = "android.widget.TextView")
    public static WebElement s_text;

    @FindBy(name = "Чаты")
    public static WebElement chatsTitle;

    //todo => tab by class or id (for search by index)

    @FindBy(className = "android.widget.ImageButton")
    public static WebElement menuIcon;

    @FindBy(id = "list_chats")
    public static WebElement dialogListView;

    @FindBy(id = "text_view_chat_name")
    public static List<WebElement> dialogName;

    /*============================Msg Box==========================*/

    @FindBy(id = "send_message_box")
    public static WebElement msgBox;

    @FindBy(id = "edit_text_send_message")
    public static WebElement msgTextField;

    @FindBy(id = "send_location_checkbox")
    public static WebElement locationIcon;

    @FindBy(id = "attach_something")
    public static WebElement attachIcon;

    @FindBy(id = "button_send")
    public static WebElement sendBtn;

    @FindBy(className = "android.widget.LinearLayout")
    public static List<WebElement> attachList;

    /*===========================Msg List============================*/

    @FindBy(id = "layout")
    public static List<WebElement> msgsLayout;

    @FindBy(id = "bubble")
    public static List<WebElement> bubbleMsgs;

    @FindBy(id = "text_view_message")
    public static List<WebElement> bubbleMsgsText;

    @FindBy(id = "text_view_date")
    public static List<WebElement> bubbleMsgsTime;

    @FindBy(id = "text_view_status")
    public static WebElement msgStatus;

    /*========================Attach List=============================*/

    @FindBy(id = "list")
    public static List<WebElement> list;


    @FindBy(id = "fab_done")
    public static WebElement gallerySubmit;

    @FindBy(id = "delete")
    public static WebElement previewDelImage;


/*=============================Test==================================*/

   /* public static WebElement element(By locator) {
        return driver.findElement(locator);
    }

    *//**
     * Return a list of elements by locator *
     *//*
    public static List<WebElement> elements(By locator) {
        return driver.findElements(locator);
    }


    *//**
     * Return a static text element by xpath index *
     *//*
    public static WebElement s_text(int xpathIndex) {
        return element(for_text(xpathIndex));
    }

    *//**
     * Return a static text locator by xpath index *
     *//*
    public static By for_text(int xpathIndex) {
        return By.xpath("//android.widget.TextView[" + xpathIndex + "]");
    }

    *//**
     * Return a static text element that contains text *
     *//*
    public static WebElement text(String text) {
        return element(for_text(text));
    }

    *//**
     * Return a static text locator that contains text *
     *//*
    public static By for_text(String text) {
        return By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]");
    }

    *//**
     * Return a static text element by exact text *
     *//*
    public static WebElement text_exact(String text) {
        return element(for_text_exact(text));
    }

    *//**
     * Return a static text locator by exact text *
     *//*
    public static By for_text_exact(String text) {
        return By.xpath("//android.widget.TextView[@text='" + text + "']");
    }*/

}
