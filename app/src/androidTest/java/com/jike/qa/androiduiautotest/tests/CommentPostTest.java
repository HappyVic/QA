package com.jike.qa.androiduiautotest.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

public class CommentPostTest extends BaseTest {
    @Test
    public void commentPost() throws UiObjectNotFoundException, InterruptedException {
        postsPage.switchToPostsPage();
        postsPage.commentPost();
    }
}
