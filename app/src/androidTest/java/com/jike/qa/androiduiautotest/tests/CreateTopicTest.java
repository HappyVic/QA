package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

public class CreateTopicTest extends BaseTest {
    @Test
    public void createTopic() throws InterruptedException, UiObjectNotFoundException {
        minePage.switchToMinePage();
        minePage.createTopic();
    }
}
