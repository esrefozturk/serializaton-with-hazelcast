package com.hazelcast.kryo;

import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.Input;
import com.hazelcast.nio.serialization.StreamSerializer;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.ObjectDataInput;
import com.esotericsoftware.kryo.Kryo;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

public class CustomerKryoSerializer implements StreamSerializer<KryoCustomer> {

    private static ThreadLocal<Kryo>  kryoThreadLocal = new ThreadLocal(){
        protected Kryo initialValue(){
            Kryo kryo = new Kryo();
            kryo.register(KryoCustomer.class);
            return kryo;
        }
    };

    public void write( ObjectDataOutput objectDataOutput, KryoCustomer customer ) throws IOException{
        Kryo kryo = kryoThreadLocal.get();
        Output output = new Output((OutputStream) objectDataOutput);
        kryo.writeObject( output , customer );
        output.flush();
    }

    public KryoCustomer read(ObjectDataInput objectDataInput) throws IOException{
        Input input = new Input( (InputStream) objectDataInput  );
        return kryoThreadLocal.get().readObject( input , KryoCustomer.class );
    }

    public int getTypeId(){
        return 1;
    }

    public void destroy(){}

}
