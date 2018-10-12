package com.jike.qa.androiduiautotest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;

public class LoginPage extends BasePage {
    public LoginPage(UiDevice mDevice){
        super(mDevice);
    }

    public void loginWithQQ() throws UiObjectNotFoundException, InterruptedException {
        Click.clickById("com.ruguoapp.jike:id/lay_qq", mDevice);
        CheckFlag.isObjectFoundById("com.tencent.mobileqq:id/ivTitleName", mDevice);

        Click.clickByText("登录",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_profile_desc", mDevice);
    }
}
