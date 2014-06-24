package externalizable;

import java.util.Date;
import java.io.IOException;
import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.lang.ClassNotFoundException;
import java.util.ArrayList;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 18.06.2014.
 */

public class Customer implements Externalizable
{
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    ArrayList<Long> longArray;

    Customer() {}

    Customer(String name, Date birthday, Sex gender, String emailAddress, ArrayList<Long> longArray)
    {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.longArray = longArray;
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException
    {
        name = objectInput.readUTF();
        birthday = new Date(objectInput.readLong());
        gender = Sex.valueOf(objectInput.readUTF());
        emailAddress = objectInput.readUTF();
        int len = objectInput.readInt();
        longArray = new ArrayList<Long>(len);
        Long tmp;
        for(int i = 0; i < len; i++)  {  tmp = objectInput.readLong(); longArray.add(tmp); }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException
    {
        objectOutput.writeUTF(name);
        objectOutput.writeLong(birthday.getTime());
        objectOutput.writeUTF(gender.toString());
        objectOutput.writeUTF(emailAddress);
        objectOutput.writeInt(longArray.size());
        for(int i = 0; i < longArray.size(); i++) objectOutput.writeLong(longArray.get(i));
    }
}