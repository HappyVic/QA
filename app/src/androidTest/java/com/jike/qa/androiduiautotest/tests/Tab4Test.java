package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

public class Tab4Test extends BaseTest {

    @Test
    public void clickEveryButton() throws InterruptedException, UiObjectNotFoundException {
        minePage.switchToMinePage();
        minePage.clickMySubscribetopics();
        minePage.clickMyCollection();
        minePage.clickMyNotification();
        minePage.clickMyTopics();
    }
}
