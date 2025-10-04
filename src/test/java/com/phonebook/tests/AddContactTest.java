package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.tests.data.ContactData;
import com.phonebook.tests.data.UserData;
import com.phonebook.utils.DataProviders;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().ClickOnLoginLink();
        app.getUser().FillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LastName)
                .setPhone(ContactData.Phone)
                .setEmail(ContactData.Email)
                .setAddress(ContactData.Address)
                .setDescription(ContactData.Description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.NAME));
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String lastName,
                                                       String phone, String email,
                                                       String address, String description)
    {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }

    @Test(dataProvider = "addNewContactWithCsv", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderWithCsvFileTest(Contact contact)
    {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();


    }

}



