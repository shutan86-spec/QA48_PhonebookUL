package com.phonebook.tests;

import com.phonebook.models.User;
import com.phonebook.tests.data.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test(enabled = false)
    public void newUserRegPositiveTest() {
       // int i=(int)((System.currentTimeMillis()/1000)%3600);
        app.getUser().ClickOnLoginLink();
        app.getUser().FillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegButton();
        Assert.assertTrue(app.getUser().isSignOutRresent());
    }

    @Test
    public void existedUserRegNegativeTest() {
        app.getUser().ClickOnLoginLink();
        app.getUser().FillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegButton();
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();


    }

}
