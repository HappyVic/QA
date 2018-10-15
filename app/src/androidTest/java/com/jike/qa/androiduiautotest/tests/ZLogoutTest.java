package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

public class ZLogoutTest extends BaseTest {
    @Test
    public void logout() throws UiObjectNotFoundException, InterruptedException {
        minePage.switchToMinePage();
        minePage.clickSettingBtn();
        settingPage.logout();
    }


}

