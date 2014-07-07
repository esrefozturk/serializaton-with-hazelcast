package com.hazelcast.bytearrayserializer;

import com.hazelcast.mainbenchmark.AbstractCustomer;

import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 07.07.2014.
 */
public class ByteArraySerializerCustomer extends AbstractCustomer {
    public ByteArraySerializerCustomer() {}

    public ByteArraySerializerCustomer(String name, Date birthday, Sex gender, String emailAddress, long[] longArray) {
        super(name, birthday, gender, emailAddress, longArray);
    }
}
