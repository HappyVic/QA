package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;

import org.junit.Test;

public class BlockUserTest extends BaseTest {
    @Test
    public void blockUser() throws Exception {
        postsPage.switchToPostsPage();
        postsPage.visitPersonalPage();
        String screenName1 = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/tv_username")).getText();

        personalPage.blockUser();
        settingPage.switchToSettingPage();
        settingPage.privacy();

        Click.clickByText("黑名单",mDevice);
        String screenName2 = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/tv_username")).getText();

        if (!screenName1.equals(screenName2)){
            throw new Exception("黑名单中最新的昵称没对上刚刚拉黑的名字");
        }

        mDevice.pressBack();
        mDevice.pressBack();
    }
}
