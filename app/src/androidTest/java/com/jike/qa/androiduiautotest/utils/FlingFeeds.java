package com.jike.qa.androiduiautotest.utils;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

public class FlingFeeds {
    public static void flingFoward(String clazz, UiDevice mDevice) throws UiObjectNotFoundException {
        UiScrollable feeds = new UiScrollable(new UiSelector().className(clazz));
        feeds.flingForward();
    }

    public static void flingBackward(String clazz,UiDevice mDevice) throws UiObjectNotFoundException {
        UiScrollable feeds = new UiScrollable(new UiSelector().className(clazz));
        feeds.flingBackward();
    }

    public static void scrollToEnd(String clazz,UiDevice mDevice) throws UiObjectNotFoundException {
        UiScrollable feeds = new UiScrollable(new UiSelector().className(clazz));
        feeds.scrollToEnd(100);
    }

    public static void scrollToObject(String clazz, String text, UiDevice mDevice) throws UiObjectNotFoundException {
        UiObject object = mDevice.findObject(new UiSelector().text(text));
        UiScrollable feeds = new UiScrollable(new UiSelector().className(clazz));
        feeds.scrollIntoView(object);
    }
}
