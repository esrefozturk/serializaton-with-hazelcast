package portable;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableWriter;
import com.hazelcast.nio.serialization.PortableReader;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

public class Customer implements Portable {
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    ArrayList<Long> longArray;

    public int getFactoryId(){
        return 0;
    }

    public int getClassId(){
        return 0;
    }

    public void readPortable( PortableReader portableReader) throws IOException
    {
        name = portableReader.readUTF("name");
        birthday = new Date(Long.valueOf(portableReader.readUTF("birthday")).longValue());
        gender = Sex.valueOf(portableReader.readUTF("gender"));
        emailAddress = portableReader.readUTF("emailAddress");
        int len = portableReader.readInt("size");
        longArray = new ArrayList<Long>(len);
        Long tmp;
        for(int i = 0; i < len; i++)  {  tmp = portableReader.readLong("arrayElem"); longArray.add(tmp); }
    }

    public void writePortable( PortableWriter portableWriter ) throws IOException
    {
        portableWriter.writeUTF("name", name);
        Format formatter = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
        String s = formatter.format(birthday);
        portableWriter.writeUTF("birthday", s);
        portableWriter.writeUTF("gender", gender.toString());
        portableWriter.writeUTF("emailAddress", emailAddress);
        portableWriter.writeInt("size", longArray.size());
        for(int i = 0; i < longArray.size(); i++) portableWriter.writeLong("arrayElem", longArray.get(i));
    }
}
