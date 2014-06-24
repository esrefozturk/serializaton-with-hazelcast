package bytearrayserializer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 23.06.2014.
 */

public class Customer {
    public enum Sex { MALE, FEMALE }
    public String name;
    public Date birthday;
    public Sex gender;
    public String emailAddress;
    public long[] longArray;

    public Customer(){}

    public Customer( String name , Date birthday , Sex gender , String emailAddress , long[] longArray ){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.longArray = longArray;
    }

}
