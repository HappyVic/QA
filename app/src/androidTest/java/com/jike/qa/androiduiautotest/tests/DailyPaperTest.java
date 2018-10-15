package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.jike.qa.androiduiautotest.pages.BaseTest;

import org.junit.Test;

public class DailyPaperTest extends BaseTest {
    @Test
    public void dailyPaper() throws UiObjectNotFoundException, InterruptedException {
        discoverPage.switchToDiscoverPage();
        discoverPage.dailyPaper();
    }
}
