package com.jike.qa.androiduiautotest.utils;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

public class CheckFlag {
    public static void isObjectFoundById(String id, UiDevice mDevice)throws UiObjectNotFoundException{
        Boolean flag = mDevice.findObject(new UiSelector().resourceId(id)).exists();
        if (!flag){
            throw new UiObjectNotFoundException("cannot find object when check page");
        }
    }

    public static void isObjectFoundByText(String text, UiDevice mDevice)throws UiObjectNotFoundException{
        Boolean flag = mDevice.findObject(new UiSelector().text(text)).exists();
        if (!flag){
            throw new UiObjectNotFoundException("cannot find object when check page");
        }
    }
}
