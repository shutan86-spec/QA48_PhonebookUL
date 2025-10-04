package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public boolean isLoginLinkPresent(){
        return isElementPresent(By.cssSelector("[href='/login']"));
    };

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegButton() {
        click(By.name("registration"));
    }

    public void FillRegisterLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void ClickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutRresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }
}
