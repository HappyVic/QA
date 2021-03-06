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
    }

    public void switchToDiscoverPage() throws InterruptedException, UiObjectNotFoundException {
        Click.clickByText("发现",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/lay_entrance_daily",mDevice);
    }

    public void switchToFirstPage() throws InterruptedException, UiObjectNotFoundException {
        Click.clickByText("首页",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/lay_chat_entrance",mDevice);
    }

    public void switchToSettingPage() throws InterruptedException, UiObjectNotFoundException {
        this.switchToMinePage();
        Click.clickById("com.ruguoapp.jike:id/menu_setting",mDevice);
    }

    public void switchToRecommendPage() throws UiObjectNotFoundException, InterruptedException {
        this.switchToFirstPage();
        Click.clickByText("推荐",mDevice);
    }

    public void switchToPersonalPage(String screenName) throws InterruptedException, UiObjectNotFoundException {
        Click.clickById(screenName,mDevice);
    }
}


