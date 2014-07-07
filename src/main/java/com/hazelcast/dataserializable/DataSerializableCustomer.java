package com.hazelcast.dataserializable;

import com.hazelcast.mainbenchmark.AbstractCustomer;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 07.07.2014.
 */

public class DataSerializableCustomer extends AbstractCustomer implements DataSerializable {
    public DataSerializableCustomer() {}

    public DataSerializableCustomer(String name, Date birthday, Sex gender, String emailAddress, long[] longArray) {
        super(name, birthday, gender, emailAddress, longArray);
    }

    public void readData( ObjectDataInput objectDataInput ) throws IOException {
        name = objectDataInput.readUTF();
        birthday = new Date( objectDataInput.readLong() );
        gender = Sex.valueOf( objectDataInput.readUTF() );
        emailAddress = objectDataInput.readUTF();
        longArray = objectDataInput.readLongArray();
    }

    public void writeData( ObjectDataOutput objectDataOutput ) throws IOException{
        objectDataOutput.writeUTF( name );
        objectDataOutput.writeLong( birthday.getTime() );
        objectDataOutput.writeUTF( gender.toString() );
        objectDataOutput.writeUTF( emailAddress );
        objectDataOutput.writeLongArray( longArray );
    }

}