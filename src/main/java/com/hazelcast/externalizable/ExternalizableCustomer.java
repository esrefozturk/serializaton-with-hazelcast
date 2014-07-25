package com.hazelcast.externalizable;

import java.util.Date;
import java.io.IOException;
import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.lang.ClassNotFoundException;
import com.hazelcast.mainbenchmark.AbstractCustomer;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 18.06.2014.
 */

public class ExternalizableCustomer extends AbstractCustomer implements Externalizable
{
    ExternalizableCustomer() {}

    ExternalizableCustomer(String name, Date birthday, Sex gender, String emailAddress, long[] longArray)
    {
        super(name, birthday, gender, emailAddress, longArray);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException
    {
        name = objectInput.readUTF();
        birthday = new Date(objectInput.readLong());
        gender = Sex.valueOf(objectInput.readUTF());
        emailAddress = objectInput.readUTF();
        int len = objectInput.readInt();
        longArray = new long[len];
        Long tmp;
        for(int i = 0; i < len; i++)  {  tmp = objectInput.readLong(); longArray[i] = tmp; }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException
    {
        objectOutput.writeUTF(name);
        objectOutput.writeLong(birthday.getTime());
        objectOutput.writeUTF(gender.toString());
        objectOutput.writeUTF(emailAddress);
        objectOutput.writeInt(longArray.length);
        for(int i = 0; i < longArray.length; i++) objectOutput.writeLong(longArray[i]);
    }
}