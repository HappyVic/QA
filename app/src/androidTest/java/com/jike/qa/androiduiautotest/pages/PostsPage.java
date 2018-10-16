package com.jike.qa.androiduiautotest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;
import com.jike.qa.androiduiautotest.utils.PutText;
import com.jike.qa.androiduiautotest.utils.Watcher;

public class PostsPage extends BasePage {
    public PostsPage (UiDevice mDevice){
        super(mDevice);
    }

    public void createPureTextOriginalPost() throws InterruptedException, UiObjectNotFoundException {
        Click.clickByText("发布动态...",mDevice);
        Watcher.PostGuideWatcher(mDevice);

        PutText.clearAndInput("123","com.ruguoapp.jike:id/et_input",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_send",mDevice);
        CheckFlag.isObjectFoundByText("刚刚",mDevice);
    }

    public void createOriginalPostWithPic(int count) throws InterruptedException, UiObjectNotFoundException {
        //count是决定发几张图
        Click.clickByText("发布动态...",mDevice);
        Watcher.PostGuideWatcher(mDevice);
        PutText.clearAndInput("一二三","com.ruguoapp.jike:id/et_input",mDevice);

        //选图了
        Click.clickById("com.ruguoapp.jike:id/lay_add_pic",mDevice);
        Click.clickById("com.ruguoapp.jike:id/iv_pic",mDevice);
        Click.clickById("com.ruguoapp.jike:id/lay_check",mDevice);
        for (int i = 0; i < count-1; i++){
            mDevice.swipe(850,1000,300,1000,100);
            Click.clickById("com.ruguoapp.jike:id/lay_check",mDevice);
        }
        Click.clickByText("确定",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_send",mDevice);

        CheckFlag.isObjectFoundByText("刚刚",mDevice);
    }

    public void scrollUp() throws UiObjectNotFoundException {
        UiScrollable postsFeed = new UiScrollable(new UiSelector().className("android.support.v7.widget.RecyclerView"));
//        postsFeed.flingForward();
        postsFeed.flingToEnd(10);
    }

    //这个方法我没能验证赞数是否增加，获取不到数字，以后再说吧
    public void likePost() throws Exception {
        Click.clickById("com.ruguoapp.jike:id/iv_like", mDevice);

    }

    public void commentPost() throws InterruptedException, UiObjectNotFoundException {
        //如果界面上没有评论按钮，就一只向下滚动直到找到为止

        CheckFlag.flingIfNotFoundById("com.ruguoapp.jike:id/iv_comment","android.support.v7.widget.RecyclerView",mDevice);
        Click.clickById("com.ruguoapp.jike:id/iv_comment",mDevice);

        PutText.clearAndInput("123","com.ruguoapp.jike:id/et_input",mDevice);
        Click.clickById("com.ruguoapp.jike:id/lay_send",mDevice);
        Thread.sleep(4000);

        UiObject guideArgeeBtn = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/tv_confirm"));
        if (guideArgeeBtn.exists()){
            guideArgeeBtn.click();
        }
        CheckFlag.isObjectFoundByText("刚刚",mDevice);
    }

    public void repost() throws UiObjectNotFoundException, InterruptedException {
        //如果界面上没有转发按钮，就一只向下滚动直到找到为止
        CheckFlag.flingIfNotFoundById("com.ruguoapp.jike:id/iv_repost","android.support.v7.widget.RecyclerView",mDevice);
        Click.clickById("com.ruguoapp.jike:id/iv_repost",mDevice);

        PutText.clearAndInput("123","com.ruguoapp.jike:id/et_input",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_send",mDevice);
        switchToPostsPage();
        CheckFlag.isObjectFoundByText("刚刚",mDevice);
    }

    public void collectPost() throws UiObjectNotFoundException, InterruptedException {
        CheckFlag.flingIfNotFoundById("com.ruguoapp.jike:id/iv_menu","android.support.v7.widget.RecyclerView",mDevice);
        Click.clickById("com.ruguoapp.jike:id/iv_menu",mDevice);

        Click.clickByText("加入收藏",mDevice);
        //检查
        Click.clickById("com.ruguoapp.jike:id/iv_menu",mDevice);
        CheckFlag.isObjectFoundByText("取消收藏",mDevice);
    }

    public void visitPersonalPage() throws UiObjectNotFoundException, InterruptedException {
        CheckFlag.flingIfNotFoundById("com.ruguoapp.jike:id/tv_username","android.support.v7.widget.RecyclerView",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_username",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_description",mDevice);
    }

    public void sharePostToTimeline() throws UiObjectNotFoundException, InterruptedException {
        CheckFlag.flingIfNotFoundById("com.ruguoapp.jike:id/iv_share","android.support.v7.widget.RecyclerView",mDevice);
        Click.clickById("com.ruguoapp.jike:id/iv_share",mDevice);
        Click.clickByText("朋友圈",mDevice);
        Click.clickByText("发表",mDevice);
    }

//    这个方法算了，也没啥必要
//    public void sharePostCardToTimeline() throws UiObjectNotFoundException, InterruptedException {
//        CheckFlag.flingIfNotFoundById("com.ruguoapp.jike:id/iv_share","android.support.v7.widget.RecyclerView",mDevice);
//        Click.clickById("com.ruguoapp.jike:id/iv_share",mDevice);
//        Click.clickByText("动态卡片",mDevice);
//        //不知道为什么，"朋友圈"通过text和classname都无法获取
//        Click.clickByClass("android.widget.LinearLayout",mDevice);
//        Click.clickByText("发表",mDevice);
//    }

}
