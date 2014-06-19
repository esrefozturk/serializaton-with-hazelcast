package identifieddataserializable;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 18.06.2014.
 */

public class Customer implements IdentifiedDataSerializable
{
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    ArrayList<Long> longArray;

    public int getFactoryId(){
        return 0;
    }

    public int getId(){
        return 0;
    }

    public void readData( ObjectDataInput objectDataInput ) throws IOException
    {
        name = objectDataInput.readLine();
        birthday = new Date(Long.valueOf(objectDataInput.readLine()).longValue());
        gender = Sex.valueOf(objectDataInput.readLine());
        emailAddress = objectDataInput.readLine();
        int len = objectDataInput.readInt();
        longArray = new ArrayList<Long>(len);
        Long tmp;
        for(int i = 0; i < len; i++)  {  tmp = objectDataInput.readLong(); longArray.add(tmp); }
    }

    public void writeData( ObjectDataOutput objectDataOutput ) throws IOException
    {
        objectDataOutput.writeChars(name);
        Format formatter = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
        String s = formatter.format(birthday);
        objectDataOutput.writeChars(s);
        objectDataOutput.writeChars(gender.toString());
        objectDataOutput.writeChars(emailAddress);
        objectDataOutput.writeInt(longArray.size());
        for(int i = 0; i < longArray.size(); i++) objectDataOutput.writeLong(longArray.get(i));
    }
}
