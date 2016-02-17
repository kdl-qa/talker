package com.talker.page_object.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by kdl on 02.02.16.
 */
public class Chats {

    /*====================== Dialog & Group =========================*/


    @FindBy(name = "Чаты")
    public static WebElement chatsTitle;

    //todo => tab by class or id (for search by index)
    @FindBy(className = "android.support.v7.app.ActionBar$Tab")
    public static List<WebElement> actionTabs;

    @FindBy(id = "toolbar")
    public static WebElement actionBar;

    @FindBy(className = "android.widget.TextView")
    public static WebElement s_text;

    @FindBy(id = "fab_contacts")
    public static WebElement createChat;

    @FindBy(className = "android.widget.ImageButton")
    public static WebElement menuIcon;

    @FindBy(id = "list_chats")
    public static WebElement dialogListView;

    @FindBy(id = "text_view_chat_name")
    public static List<WebElement> dialogName;

    /*===========================Side Bar==========================*/
    @FindBy(id = "design_navigation_view")
    public static WebElement sideBar;

    @FindBy(id = "design_menu_item_text")
    public static List<WebElement> sideBarMenuItems;

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

    @FindBy(id = "image")
    public static List<WebElement> list;

    @FindBy(id = "fab_done")
    public static WebElement gallerySubmit, previewSubmit, submitCrtBtn;

    @FindBy(id = "delete")
    public static WebElement previewDelImage;


    /*=============================Test==================================*/



}
