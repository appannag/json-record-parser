package com.aws.json_record_parser.service;

import com.aws.json_record_parser.model.SchemaRecordModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class AswRecordParserService {

    public void parse(){
        JSONObject data = loadJson();
        //System.out.print(data.toString());
        GenericParserService genericParserService= new GenericParserService();
        SchemaRecordModel schemaRecordModel = genericParserService.parse(data);
        System.out.println(genericParserService.toJson(schemaRecordModel));
    }

    public JSONObject loadJson(){
        JSONObject data = null;
        try{
            JSONParser parser = new JSONParser();
             data = (JSONObject) parser.parse(
                    new FileReader("src/main/resources/input.json"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
