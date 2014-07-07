package com.hazelcast.jacksonsmile;

import com.hazelcast.mainbenchmark.AbstractCustomer;

import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 07.07.2014.
 */
public class JacksonSmileCustomer  extends AbstractCustomer {
    public JacksonSmileCustomer(){}

    public JacksonSmileCustomer(String name, Date birthday, Sex gender, String emailAddress, long[] longArray) {
        super(name, birthday, gender, emailAddress, longArray);
    }
}

