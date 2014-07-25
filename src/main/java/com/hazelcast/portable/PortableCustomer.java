package com.hazelcast.portable;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableWriter;
import com.hazelcast.nio.serialization.PortableReader;
import java.util.Date;
import java.io.IOException;
import com.hazelcast.mainbenchmark.AbstractCustomer;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 18.06.2014.
 */

public class PortableCustomer extends AbstractCustomer implements Portable
{
    PortableCustomer() {}

    PortableCustomer(String name, Date birthday, Sex gender, String emailAddress, long[] longArray)
    {
        super(name, birthday, gender, emailAddress, longArray);
    }

    public int getFactoryId(){
        return 1;
    }

    public int getClassId(){
        return 1;
    }

    public void readPortable( PortableReader portableReader) throws IOException
    {
        name = portableReader.readUTF("name");
        birthday = new Date(portableReader.readLong("birthday"));
        gender = Sex.valueOf(portableReader.readUTF("gender"));
        emailAddress = portableReader.readUTF("emailAddress");
        longArray = portableReader.readLongArray("longArray");
    }

    public void writePortable( PortableWriter portableWriter ) throws IOException
    {
        portableWriter.writeUTF("name", name);
        portableWriter.writeLong("birthday", birthday.getTime());
        portableWriter.writeUTF("gender", gender.toString());
        portableWriter.writeUTF("emailAddress", emailAddress);
        portableWriter.writeInt("size", longArray.length);
        portableWriter.writeLongArray("longArray", longArray);
    }
}