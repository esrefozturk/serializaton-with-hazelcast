package serializable;

import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

public class Customer implements Serializable {
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

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException{
        //System.out.println("I am reading a Customer");
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException{
        //System.out.println("I am writing a Customer");
        objectOutputStream.defaultWriteObject();
    }

}
