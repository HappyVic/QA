package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.jike.qa.androiduiautotest.utils.Click;

import org.junit.Test;

public class UnblockUserTest extends BaseTest {
    @Test
    public void unblockUser() throws Exception {
        settingPage.switchToSettingPage();
        settingPage.privacy();
        Click.clickByText("黑名单",mDevice);

        String screenName = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/tv_username")).getText();

        Click.clickById("com.ruguoapp.jike:id/tv_remove_block",mDevice);
        Click.clickById("android:id/button1",mDevice);

        //暂时用校验黑名单里面是否有此人来判断是否解除成功，日后写了搜索功能，会去个人主页再检查一下
        if(mDevice.findObject(new UiSelector().text(screenName)).exists()){
            throw new Exception("解除黑名单不成功，此人还在名单里！");
        }

        mDevice.pressBack();
        mDevice.pressBack();
    }
}
