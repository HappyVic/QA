package com.jike.qa.androiduiautotest.tests;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import com.jike.qa.androiduiautotest.constants.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseTest {
    public UiDevice mDevice;

    public BaseTest(){
        this.mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Before
    public void launchApp(){
        mDevice.pressHome();
        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(Constants.PACKAGENAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        mDevice.wait(Until.hasObject(By.pkg(Constants.PACKAGENAME).depth(0)), Constants.LAUNCH_TIMEOUT);
    }

    @After
    public void end(){
        mDevice.pressBack();
        mDevice.pressBack();
        mDevice.pressBack();
    }

}
