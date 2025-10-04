package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.tests.data.ContactData;
import com.phonebook.tests.data.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().ClickOnLoginLink();
        app.getUser().FillRegisterLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LastName)
                .setPhone(ContactData.Phone)
                .setEmail(ContactData.Email)
                .setAddress(ContactData.Address)
                .setDescription(ContactData.Description));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter= app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

}



