package com.example.demo.utils;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBReader;

public class JsonToGeometryDeserializer extends JsonDeserializer<Geometry> {

    @Override
    public Geometry deserialize(com.fasterxml.jackson.core.JsonParser jp,
    com.fasterxml.jackson.databind.DeserializationContext ctxt)  throws IOException,  com.fasterxml.jackson.core.JsonProcessingException {
        try {
    		String text = jp.getText();
    		byte[] aux = WKBReader.hexToBytes(text);
            Geometry geom = new WKBReader().read(aux);
            geom.setSRID(22185);
            return geom;
        }
        catch(Exception e){
            return null;
        }
    }

}