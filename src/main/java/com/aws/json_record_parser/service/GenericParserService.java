package com.aws.json_record_parser.service;

import com.aws.json_record_parser.model.FieldModel;
import com.aws.json_record_parser.model.SchemaRecordModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Date;
import java.util.List;

public class GenericParserService {

    public SchemaRecordModel parse(JSONObject jsonData){
        SchemaRecordModel schemaRecordModel = null;
        try{
            List<FieldModel> fieldModelList = jsonData.keySet().stream().map(jsonElement ->getField(jsonElement,jsonData.get(jsonElement))).toList();
            schemaRecordModel = SchemaRecordModel.builder()
                    .fields(fieldModelList)
                    .optional(false)
                    .type("struct")
                    .payload(jsonData)
                    .build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return schemaRecordModel;
    }

    FieldModel getField(Object key, Object value){
        return FieldModel.builder().type("string").optional(false).type(getTypeName(value)).field(String.valueOf(key)).build();
    }

    String toJson(SchemaRecordModel SchemaRecordModel){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(SchemaRecordModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    String getTypeName(Object value){
        if (value.getClass().equals(String.class)) {
            return "string";
        }else if (value.getClass().equals(Integer.class)){
            return "int";
        }else if (value.getClass().equals(Long.class)) {
            return "long";
        }else if (value.getClass().equals(Date.class)){
            return "date";
        }
        return "string";
    }
}
