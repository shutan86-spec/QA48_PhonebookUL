package com.phonebook.tests;

import com.phonebook.models.User;
import com.phonebook.tests.data.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test(priority = 1)
    public void loginPositiveTest(){
        logger.info("Login with email: "+UserData.EMAIL+" and password: "+UserData.PASSWORD);
        app.getUser().ClickOnLoginLink();
        app.getUser().FillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutRresent());
    }
    @Test(priority = 2)
    public void loginNegativeWithoutEmailTest(){
        app.getUser().ClickOnLoginLink();
        app.getUser().FillRegisterLoginForm(new User().setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }
}
