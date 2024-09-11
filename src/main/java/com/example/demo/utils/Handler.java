package com.example.demo.utils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

// Handler value: example.HandlerString
public class Handler implements RequestHandler<Object, String>{

    @Override
    /*
     * Takes a String as input, and converts all characters to lowercase.
     */
    public String handleRequest(Object event, Context context)
    {
        LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + event.getClass().toString());
        logger.log("MESSAGE " + event.toString());
        return "RESPONSE: " + event.toString();

//        try {
//
//            ObjectMapper mapper = new ObjectMapper();
//            Map<String, Object> jsonMap = mapper.readValue(event,
//                    new TypeReference<Map<String,Object>>(){});
//
//        }catch(Exception e)
//        {
//            e.printStackTrace();
//            return null;
//        }
    }
}