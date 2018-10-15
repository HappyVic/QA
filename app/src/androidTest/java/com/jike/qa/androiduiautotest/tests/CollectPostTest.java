package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.jike.qa.androiduiautotest.pages.BaseTest;

import org.junit.Test;

public class CollectPostTest extends BaseTest {
    @Test
    public void collectPost() throws UiObjectNotFoundException, InterruptedException {
        postsPage.switchToPostsPage();
        postsPage.collectPost();
    }
}
