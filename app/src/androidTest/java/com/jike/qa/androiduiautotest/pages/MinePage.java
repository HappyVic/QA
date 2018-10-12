package com.jike.qa.androiduiautotest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;

public class MinePage extends BasePage {

    public MinePage(UiDevice mDevice){
        super(mDevice);
    }

    public void clickMySubscribetopics() throws UiObjectNotFoundException, InterruptedException {
        Click.clickByText("我关注的主题", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/menu_search", mDevice);
    }

    public void clickSettingBtn() throws UiObjectNotFoundException, InterruptedException {
        Click.clickById("com.ruguoapp.jike:id/menu_setting", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/lay_push",mDevice);
    }

    public void toLoginPage() throws UiObjectNotFoundException, InterruptedException {
        Click.clickById("com.ruguoapp.jike:id/lay_user_info", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_login_with_phone_password", mDevice);
    }

    public void toPersonalPage() throws InterruptedException, UiObjectNotFoundException {
        Click.clickById("com.ruguoapp.jike:id/tv_username", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_description", mDevice);
    }


}
