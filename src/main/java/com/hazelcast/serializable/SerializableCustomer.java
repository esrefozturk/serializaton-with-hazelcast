package com.hazelcast.serializable;

import com.hazelcast.mainbenchmark.AbstractCustomer;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 06.07.2014.
 */
public class SerializableCustomer extends AbstractCustomer implements Serializable {
    public SerializableCustomer (){}

    public SerializableCustomer( String name , Date birthday , Sex gender , String emailAddress , long[] longArray ){
        super( name , birthday , gender , emailAddress , longArray );
    }
}