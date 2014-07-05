package com.hazelcast.mainbenchmark;

import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 05.07.2014.
 */

public abstract class  AbstractCustomer {
    public enum Sex { MALE, FEMALE }
    public String name;
    public Date birthday;
    public Sex gender;
    public String emailAddress;
    public long[] longArray;

    public AbstractCustomer (){}

    public AbstractCustomer( String name , Date birthday , Sex gender , String emailAddress , long[] longArray ){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.longArray = longArray;
    }
}