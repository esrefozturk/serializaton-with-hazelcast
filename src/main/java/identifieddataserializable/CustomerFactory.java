package identifieddataserializable;

import com.hazelcast.nio.serialization.DataSerializableFactory;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 20.06.2014.
 */

public class CustomerFactory implements DataSerializableFactory
{
    @Override
    public IdentifiedDataSerializable create(int x)
    {
        return new Customer();
    }
}

