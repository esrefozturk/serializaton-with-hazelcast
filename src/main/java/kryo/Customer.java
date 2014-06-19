package kryo;

import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

public class Customer {
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    long[] longArray;

    public Customer(){}

    public Customer( String name , Date birthday , Sex gender , String emailAddress , long[] longArray ){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.longArray = longArray;
    }

}
