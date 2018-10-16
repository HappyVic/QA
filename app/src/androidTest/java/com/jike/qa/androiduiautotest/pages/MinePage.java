package com.jike.qa.androiduiautotest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import com.jike.qa.androiduiautotest.utils.CheckFlag;
import com.jike.qa.androiduiautotest.utils.Click;
import com.jike.qa.androiduiautotest.utils.PutText;

import java.util.Random;

public class MinePage extends BasePage {

    public MinePage(UiDevice mDevice){
        super(mDevice);
    }

    public void clickMySubscribetopics() throws UiObjectNotFoundException, InterruptedException {
        Click.clickByText("我关注的主题", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/menu_search", mDevice);
        mDevice.pressBack();
    }

    public void clickMyCollection() throws UiObjectNotFoundException, InterruptedException {
        Click.clickByText("我的收藏", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/menu_search", mDevice);
        mDevice.pressBack();
    }

    public void clickMyNotification() throws InterruptedException, UiObjectNotFoundException {
        Click.clickByText("我的通知", mDevice);
        CheckFlag.isObjectFoundByText("系统通知",mDevice);

        Click.clickByText("系统通知", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_title",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_description",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_timestamp",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_action",mDevice);
        mDevice.pressBack();
        mDevice.pressBack();
    }

    public void clickMyTopics() throws InterruptedException, UiObjectNotFoundException {
        Click.clickByText("我创建的主题", mDevice);
        CheckFlag.isObjectFoundByText("创建新的主题",mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_remain_custom_topic_count",mDevice);
        mDevice.pressBack();
    }

    public void createTopic() throws InterruptedException, UiObjectNotFoundException {
        Random random = new Random(100);
        String topicName = "好疼的金圣叹" + random.nextInt(100) + random.nextInt(100) + random.nextInt(100);
        Click.clickByText("我创建的主题", mDevice);
        Click.clickByText("创建新的主题",mDevice);
        Click.clickById("com.ruguoapp.jike:id/gradual_mask",mDevice);

        Click.clickByText("指定商品有优惠",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_button",mDevice);

        Click.clickById("com.ruguoapp.jike:id/lay_click_assemble_bot",mDevice);
        PutText.clearAndInput("鞋","com.ruguoapp.jike:id/et_input",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_ok",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_ok",mDevice);

        Click.clickById("com.ruguoapp.jike:id/tv_next",mDevice);
        Click.clickById("com.ruguoapp.jike:id/edit_tab_name",mDevice);
        PutText.clearAndInput(topicName,"com.ruguoapp.jike:id/et_input",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_toolbar_action",mDevice);

        Click.clickById("com.ruguoapp.jike:id/tv_submit",mDevice);
        Click.clickById("android:id/button1",mDevice);
        Click.clickById("com.ruguoapp.jike:id/tv_cancel",mDevice);
        
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_msg_number",mDevice);
    }

    public void clickSettingBtn() throws UiObjectNotFoundException, InterruptedException {
        Click.clickById("com.ruguoapp.jike:id/menu_setting", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/lay_push",mDevice);
    }

    public void toLoginPage() throws UiObjectNotFoundException, InterruptedException {
        Click.clickById("com.ruguoapp.jike:id/lay_user_info", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_login_with_phone_password", mDevice);
    }

    public void toPersonalPage() throws InterruptedException, UiObjectNotFoundException {
        Click.clickById("com.ruguoapp.jike:id/tv_username", mDevice);
        CheckFlag.isObjectFoundById("com.ruguoapp.jike:id/tv_description", mDevice);
    }


}
