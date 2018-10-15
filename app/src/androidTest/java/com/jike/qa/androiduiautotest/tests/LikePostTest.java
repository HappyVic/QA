package com.jike.qa.androiduiautotest.tests;

import org.junit.Test;

public class LikePostTest extends BaseTest {
    @Test
    public void likePost() throws Exception {
        postsPage.switchToPostsPage();
        postsPage.likePost();
    }
}
