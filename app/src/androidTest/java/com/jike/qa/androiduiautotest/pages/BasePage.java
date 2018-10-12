package com.jike.qa.androiduiautotest.pages;


import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.jike.qa.androiduiautotest.utils.*;

public class BasePage {

    public UiDevice mDevice;

    public BasePage(UiDevice mDevice){
        this.mDevice = mDevice;
    }


    public void switchToMinePage() throws UiObjectNotFoundException, InterruptedException {
        Click.clickByText("我的", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/lay_my_topics", mDevice);
    }

    public void switchToPostsPage() throws InterruptedException, UiObjectNotFoundException {
        Click.clickByText("动态",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/lay_chat_entrance",mDevice);
        UiObject object = mDevice.findObject(new UiSelector().resourceId("xxx").text("xxx"));
        UiObject2 object1 = mDevice.findObject(By.res("xxx"));
    }
}


