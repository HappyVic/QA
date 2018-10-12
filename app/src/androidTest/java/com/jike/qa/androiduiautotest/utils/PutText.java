package com.jike.qa.androiduiautotest.utils;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.jike.qa.androiduiautotest.constants.Constants;

public class PutText {
    public static void clearAndInput(String text,String id, UiDevice mDevice) throws UiObjectNotFoundException, InterruptedException {
        UiObject textField = mDevice.findObject(new UiSelector().resourceId(id));
        textField.clearTextField();
        textField.setText(text);
        Thread.sleep(Constants.CLICK_TIMEOUT);
    }
}
