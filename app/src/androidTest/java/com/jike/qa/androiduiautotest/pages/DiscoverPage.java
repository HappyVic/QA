package com.jike.qa.androiduiautotest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;
import com.jike.qa.androiduiautotest.utils.FlingFeeds;

public class DiscoverPage extends BasePage {
    public DiscoverPage(UiDevice mDevice){
        super(mDevice);
    }

    //查看小报、浏览小报、加鸡腿、分享小报到朋友圈、查看往期、翻页
    public void dailyPaper() throws InterruptedException, UiObjectNotFoundException {
        Click.clickById("com.ruguoapp.jike:id/lay_entrance_daily",mDevice);

        for(int i = 0; i < 20; i++){
            FlingFeeds.flingFoward("android.support.v7.widget.RecyclerView",mDevice);
        }


        FlingFeeds.scrollToObject("android.support.v7.widget.RecyclerView","加鸡腿",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/btn_right",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/lay_share",mDevice);

        Click.clickByText("加鸡腿",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_percent",mDevice);

        Click.clickById("com.ruguoapp.jike:id/lay_share",mDevice);
        Click.clickByText("朋友圈",mDevice);
        CheckFlag.isObjectFoundByText("发表",mDevice);
        CheckFlag.isObjectFoundByText("所在位置",mDevice);
        Click.clickByText("发表",mDevice);

        Click.clickById("com.ruguoapp.jike:id/btn_right",mDevice);
        CheckFlag.isObjectFoundByText("往期小报",mDevice);

        for(int i = 0; i < 20; i++){
            FlingFeeds.flingFoward("android.support.v7.widget.RecyclerView",mDevice);
        }
        mDevice.pressBack();
    }
}
