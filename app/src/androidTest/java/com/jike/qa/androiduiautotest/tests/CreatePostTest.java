package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

public class CreatePostTest extends BaseTest {
    @Test
    public void createPost() throws UiObjectNotFoundException, InterruptedException {
        postsPage.switchToPostsPage();
//        postsPage.createPureTextOriginalPost();
        postsPage.createOriginalPostWithPic(2);
    }
}
