package com.hazelcast.identifieddataserializable;

import com.hazelcast.mainbenchmark.AbstractCustomer;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 18.06.2014.
 */

public class IdentifiedDataSerializableCustomer extends AbstractCustomer implements IdentifiedDataSerializable
{
    IdentifiedDataSerializableCustomer() {}

    IdentifiedDataSerializableCustomer(String name, Date birthday, Sex gender, String emailAddress, long[] longArray)
    {
        super(name, birthday, gender, emailAddress, longArray);
    }

    public int getFactoryId(){
        return 1;
    }

    public int getId(){
        return 1;
    }

    public void readData(ObjectDataInput objectDataInput) throws IOException
    {
        name = objectDataInput.readUTF();
        birthday = new Date(objectDataInput.readLong());
        gender = Sex.valueOf(objectDataInput.readUTF());
        emailAddress = objectDataInput.readUTF();
        int len = objectDataInput.readInt();
        longArray = new long[len];
        Long tmp;
        for(int i = 0; i < len; i++)  {  tmp = objectDataInput.readLong(); longArray[i] = tmp; }
    }

    public void writeData(ObjectDataOutput objectDataOutput) throws IOException
    {
        objectDataOutput.writeUTF(name);
        objectDataOutput.writeLong(birthday.getTime());
        objectDataOutput.writeUTF(gender.toString());
        objectDataOutput.writeUTF(emailAddress);
        objectDataOutput.writeInt(longArray.length);
        for(int i = 0; i < longArray.length; i++) objectDataOutput.writeLong(longArray[i]);
    }
}