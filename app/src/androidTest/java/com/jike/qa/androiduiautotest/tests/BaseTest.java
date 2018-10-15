package com.jike.qa.androiduiautotest.tests;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import com.jike.qa.androiduiautotest.constants.Constants;
import com.jike.qa.androiduiautotest.pages.DiscoverPage;
import com.jike.qa.androiduiautotest.pages.LoginPage;
import com.jike.qa.androiduiautotest.pages.MinePage;
import com.jike.qa.androiduiautotest.pages.PostsPage;
import com.jike.qa.androiduiautotest.pages.SettingPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseTest {
    public UiDevice mDevice;

    public MinePage minePage;
    public SettingPage settingPage;
    public LoginPage loginPage;
    public PostsPage postsPage;
    public DiscoverPage discoverPage;

    public BaseTest(){
        this.mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        this.minePage = new MinePage(mDevice);
        this.settingPage = new SettingPage(mDevice);
        this.loginPage = new LoginPage(mDevice);
        this.postsPage = new PostsPage(mDevice);
        this.discoverPage = new DiscoverPage(mDevice);

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

    @Test
    public void fakeTest(){

    }

    @After
    public void end(){
        mDevice.pressBack();
        mDevice.pressBack();
        mDevice.pressBack();
    }

}
