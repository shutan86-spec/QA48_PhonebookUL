package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]>addNewContact(){
        List<Object[]>list=new ArrayList<>();
        list.add(new Object[]
                {"Oliver","Kan","1234567890","kan@gmail.com","Tel Aviv","QA"});
        list.add(new Object[]
                {"Oliver","Kan","1234567111","kan1@gmail.com","Tel Aviv","QA"});
        list.add(new Object[]
                {"Oliver","Kan","1234567221","kan2@gmail.com","Tel Aviv","QA"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addNewContactWithCsv() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=
                new BufferedReader(new FileReader
                        (new File("src/test/resources/Contact1.csv")));
        String line= reader.readLine();
        while (line!=null){
            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line= reader.readLine();}

        return list.iterator();
    }
}
