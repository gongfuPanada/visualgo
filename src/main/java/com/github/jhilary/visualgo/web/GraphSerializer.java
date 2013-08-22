package com.github.jhilary.visualgo.web;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.github.jhilary.visualgo.graph.Graph;

public class GraphSerializer extends JsonSerializer<Graph> {

    @Override
    public void serialize(Graph value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("GraphSerializer", value.getId());
        jgen.writeEndObject();
    }
}