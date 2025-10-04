package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getHome().isHomeComponentPresent()){
            app.getHome().clickOnHomeLink();
        }
    }
    @Test
    public void isHomeComponentPresentTest() {
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        //System.out.println("isHomeComponentPresent - "+isHomeComponentPresent());
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }

}

