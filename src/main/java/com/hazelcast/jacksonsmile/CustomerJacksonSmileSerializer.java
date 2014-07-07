package com.hazelcast.jacksonsmile;

import com.hazelcast.nio.serialization.ByteArraySerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.smile.SmileFactory;

import java.io.IOException;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 07.07.2014.
 */
public class CustomerJacksonSmileSerializer implements ByteArraySerializer<JacksonSmileCustomer> {
    ObjectMapper mapper = new ObjectMapper(new SmileFactory());
    public byte[] write(JacksonSmileCustomer object) throws IOException {
        return mapper.writeValueAsBytes(object);
    }

    public JacksonSmileCustomer read(byte[] buffer) throws IOException {
        return mapper.readValue( buffer , 0 , buffer.length , JacksonSmileCustomer.class );
    }

    public int getTypeId() {
        return 1;
    }

    public void destroy() {}
}
