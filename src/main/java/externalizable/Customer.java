package externalizable;

import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import java.util.Date;
import java.io.IOException;
import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.ClassNotFoundException;
import java.util.ArrayList;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
*/

public class Customer implements Externalizable {
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    ArrayList<Long> longArray;

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        name = in.readLine();
        birthday = new Date(Long.valueOf(in.readLine()).longValue());
        gender = Sex.valueOf(in.readLine());
        emailAddress = in.readLine();
        int len = in.readInt();
        longArray = new ArrayList<Long>(len);
        Long tmp;
        for(int i = 0; i < len; i++)  {  tmp = in.readLong(); longArray.add(tmp); }
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeChars(name);
        Format formatter = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
        String s = formatter.format(birthday);
        out.writeChars(s);
        out.writeChars(gender.toString());
        out.writeChars(emailAddress);
        out.writeInt(longArray.size());
        for(int i = 0; i < longArray.size(); i++) out.writeLong(longArray.get(i));
    }
}
