package com.jike.qa.androiduiautotest.utils;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import com.jike.qa.androiduiautotest.constants.Constants;

public class Click {
    //找到id所代表的元素并且点击，点击后延迟2秒
    public static void clickById(String id, UiDevice mDevice) throws UiObjectNotFoundException, InterruptedException {
        UiObject object =  mDevice.findObject(new UiSelector().resourceId(id));
        object.click();
        Thread.sleep(Constants.CLICK_TIMEOUT);
    }

    public static void clickByText(String text, UiDevice mDevice) throws UiObjectNotFoundException, InterruptedException {
        UiObject object = mDevice.findObject(new UiSelector().text(text));
        object.click();
        Thread.sleep(Constants.CLICK_TIMEOUT);
    }

    public static void clickByDesc(String desc, UiDevice mDevice) throws UiObjectNotFoundException, InterruptedException {
        UiObject object = mDevice.findObject(new UiSelector().description(desc));
        object.click();
        Thread.sleep(Constants.CLICK_TIMEOUT);
    }

    public static void clickByClass(String clazz,UiDevice mDevice) throws UiObjectNotFoundException, InterruptedException {
        UiObject object = mDevice.findObject(new UiSelector().className(clazz));
        object.click();
        Thread.sleep(Constants.CLICK_TIMEOUT);
    }

}
