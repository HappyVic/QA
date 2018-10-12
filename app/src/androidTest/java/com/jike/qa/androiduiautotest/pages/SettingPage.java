package com.jike.qa.androiduiautotest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;

public class SettingPage extends BasePage {

    public SettingPage(UiDevice mDevice){
        super(mDevice);
    }

    public void logout() throws InterruptedException, UiObjectNotFoundException {
        Click.clickById("com.ruguoapp.jike:id/lay_logout", mDevice);
        Click.clickById("android:id/button1",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_lead_to_login",mDevice);
    }
}
