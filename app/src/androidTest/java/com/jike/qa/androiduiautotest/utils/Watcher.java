package com.jike.qa.androiduiautotest.utils;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;

public class Watcher {
    //用来跳过发动态时的新手引导
    public static void PostGuideWatcher(UiDevice mDevice) {
        final UiObject question = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/tv_add_question"));
        final UiObject nextStep = mDevice.findObject(new UiSelector().text("下一步"));
        final UiObject iKnow = mDevice.findObject(new UiSelector().text("我知道了"));
        //UiWatcher防止发布动态新手引导
        mDevice.registerWatcher("PostGuide", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                while (!question.exists()) {
                    if (nextStep.exists()) {
                        try {
                            nextStep.click();
                        } catch (UiObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                        return true;
                    } else if (iKnow.exists()) {
                        try {
                            iKnow.click();
                        } catch (UiObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
    }
    //此方法没有执行到，不知道为什么
//    public static void CommentGuideWatcher(UiDevice mDevice){
//        final UiObject sendBtn = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/lay_send"));
//        final UiObject agreeBtn = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/tv_cancel"));
//
//        mDevice.registerWatcher("CommentGuide", new UiWatcher() {
//            @Override
//            public boolean checkForCondition() {
//                while (true) {
////                    if (agreeBtn.exists()) {
//                        try {
//                            agreeBtn.click();
//                        } catch (UiObjectNotFoundException e) {
//                            e.printStackTrace();
//                        }
//                        return true;
////                    }
//                }
////                return false;
//            }
//        });
//    }
}
