package com.jike.qa.androiduiautotest.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;


import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;
import com.jike.qa.androiduiautotest.utils.PutText;
import com.jike.qa.androiduiautotest.utils.Watcher;

import java.util.LinkedList;
import java.util.List;

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
//        UiCollection feed = new UiCollection(new UiSelector().className("android.widget.RelativeLayout").index(1));
//        UiObject count = feed.getChild(new UiSelector().resourceId("com.ruguoapp.jike:id/iv_like"));
//        String count1 = count.getText();
//        int c = Integer.parseInt(count1);

//        String count1 = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/tv_popularity")).getText();
//
        Click.clickById("com.ruguoapp.jike:id/iv_like", mDevice);
//        String count2 = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/tv_popularity")).getText();
//        int num1 = Integer.parseInt(count1);
//        int num2 = Integer.parseInt(count2);
//        if (Integer.parseInt(count1) != Integer.parseInt(count2) - 1){
//            throw new Exception("点赞没点上");
//        }
    }

    public void commentPost() throws InterruptedException, UiObjectNotFoundException {
        //如果界面上没有评论按钮，就一只向下滚动直到找到为止
        UiObject commentBtn;
        commentBtn = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/iv_comment"));
        while (!commentBtn.exists()){
            UiScrollable postsFeed = new UiScrollable(new UiSelector().className("android.support.v7.widget.RecyclerView"));
            postsFeed.flingForward();
        }
        commentBtn.click();

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
        UiObject repostBtn;
        repostBtn = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/iv_repost"));
        while (!repostBtn.exists()){
            UiScrollable postsFeed = new UiScrollable(new UiSelector().className("android.support.v7.widget.RecyclerView"));
            postsFeed.flingForward();
        }
        repostBtn.click();

        PutText.clearAndInput("123","com.ruguoapp.jike:id/et_input",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_send",mDevice);
        switchToPostsPage();
        CheckFlag.isObjectFoundByText("刚刚",mDevice);
    }

    public void collectPost() throws UiObjectNotFoundException, InterruptedException {
        UiObject menuBtn;
        menuBtn = mDevice.findObject(new UiSelector().resourceId("com.ruguoapp.jike:id/iv_menu"));
        while (!menuBtn.exists()){
            UiScrollable postsFeed = new UiScrollable(new UiSelector().className("android.support.v7.widget.RecyclerView"));
            postsFeed.flingForward();
        }
        menuBtn.click();

        Click.clickByText("加入收藏",mDevice);
        //检查
        menuBtn.click();
        CheckFlag.isObjectFoundByText("取消收藏",mDevice);
    }

    public void sharePost(){

    }

}
