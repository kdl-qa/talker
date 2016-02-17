package com.talker.page_object.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by kdl on 17.02.16.
 */
public class Contacts {

    /*======================== List contacts ============================*/
    @FindBy(id = "root_view")
    public static List<WebElement> contactsList;

    @FindBy(id = "text_view_contact_name")
    public static WebElement contactName;

}
