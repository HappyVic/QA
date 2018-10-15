package com.jike.qa.androiduiautotest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;

public class PersonalPage extends BasePage {
    public PersonalPage(UiDevice mDevice){
        super(mDevice);
    }

    public void blockUser() throws InterruptedException, UiObjectNotFoundException {
        Click.clickById("com.ruguoapp.jike:id/btn_toolbar_action",mDevice);
        Click.clickByText("加入黑名单",mDevice);
        Click.clickById("android:id/button1",mDevice);

        Click.clickById("com.ruguoapp.jike:id/btn_toolbar_action",mDevice);
        CheckFlag.isObjectFoundByText("解除黑名单",mDevice);
        mDevice.pressBack();
        mDevice.pressBack();
    }
}
