package com.example.demo.utils;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBWriter;

public class GeometryToJsonSerializer extends JsonSerializer<Geometry> {

    @Override
    public void serialize(Geometry value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        
    	WKBWriter w = new WKBWriter();
		byte[] b = w.write(value);

        jgen.writeString(WKBWriter.toHex(b));

    }

}
