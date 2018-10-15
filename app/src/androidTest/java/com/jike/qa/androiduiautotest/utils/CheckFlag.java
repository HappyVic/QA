package com.jike.qa.androiduiautotest.utils;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

public class CheckFlag {
    //检查页面有没有id代表的元素，没有就抛出异常，此方法用来检查case是否通过
    public static void isObjectFoundById(String id, UiDevice mDevice)throws UiObjectNotFoundException{
        Boolean flag = mDevice.findObject(new UiSelector().resourceId(id)).exists();
        if (!flag){
            throw new UiObjectNotFoundException("cannot find object when check page");
        }
    }

    //检查页面有没有text代表的元素，没有就抛出异常，此方法用来检查case是否通过
    public static void isObjectFoundByText(String text, UiDevice mDevice)throws UiObjectNotFoundException{
        Boolean flag = mDevice.findObject(new UiSelector().text(text)).exists();
        if (!flag){
            throw new UiObjectNotFoundException("cannot find object when check page");
        }
    }

    //此方法用来检查fatherClass里面有没有id代表的元素，没有就滚动到有为止
    public static void flingIfNotFoundById(String id, String fatherClass,UiDevice mDevice)throws UiObjectNotFoundException{
        UiObject object = mDevice.findObject(new UiSelector().resourceId(id));
        while (!object.exists()){
            FlingFeeds.flingFoward(fatherClass,mDevice);
        }
    }

}
