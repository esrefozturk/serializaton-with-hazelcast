package com.hazelcast.serializable;

import mainbenchmark.AbstractCustomer;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

public class Customer extends AbstractCustomer implements Serializable {
    public Customer (){}

    public Customer( String name , Date birthday , Sex gender , String emailAddress , long[] longArray ){
        super( name , birthday , gender , emailAddress , longArray );
    }
}
