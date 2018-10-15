package com.jike.qa.androiduiautotest.tests;


import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.jike.qa.androiduiautotest.pages.DiscoverPage;
import com.jike.qa.androiduiautotest.pages.LoginPage;
import com.jike.qa.androiduiautotest.pages.MinePage;
import com.jike.qa.androiduiautotest.pages.PostsPage;
import com.jike.qa.androiduiautotest.pages.SettingPage;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LittleTest extends BaseTest {
    private MinePage minePage = new MinePage(mDevice);
    private SettingPage settingPage = new SettingPage(mDevice);
    private LoginPage loginPage = new LoginPage(mDevice);
    private PostsPage postsPage = new PostsPage(mDevice);
    private DiscoverPage discoverPage = new DiscoverPage(mDevice);

//    @Test
//    public void login() throws InterruptedException, UiObjectNotFoundException {
//        minePage.switchToMinePage();
//        minePage.toLoginPage();
//        loginPage.loginWithQQ();
//    }

    @Test
    public void logout() throws UiObjectNotFoundException, InterruptedException {
        minePage.switchToMinePage();
        minePage.clickSettingBtn();
        settingPage.logout();
    }

    @Test
    public void createPost() throws UiObjectNotFoundException, InterruptedException {
        postsPage.switchToPostsPage();
//        postsPage.createPureTextOriginalPost();
        postsPage.createOriginalPostWithPic(2);
    }

    @Test
    public void scrollUpPostsPage() throws UiObjectNotFoundException, InterruptedException {
        postsPage.switchToPostsPage();
        postsPage.scrollUp();
    }

    @Test
    public void likePost() throws Exception {
        postsPage.switchToPostsPage();
        postsPage.likePost();
    }

    @Test
    public void commentPost() throws UiObjectNotFoundException, InterruptedException {
        postsPage.switchToPostsPage();
        postsPage.commentPost();
    }

    @Test
    public void repost() throws UiObjectNotFoundException, InterruptedException {
        postsPage.switchToPostsPage();
        postsPage.repost();
    }

    @Test
    public void collectPost() throws UiObjectNotFoundException, InterruptedException {
        postsPage.switchToPostsPage();
        postsPage.collectPost();
    }

    @Test
    public void dailyPaper() throws UiObjectNotFoundException, InterruptedException {
        discoverPage.switchToDiscoverPage();
        discoverPage.dailyPaper();
    }

    @Test
    public void blockUser(){

    }

    @Test
    public void unblockUser(){
    }

}

