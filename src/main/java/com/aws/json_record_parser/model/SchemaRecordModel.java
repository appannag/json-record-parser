package com.aws.json_record_parser.model;



import lombok.Builder;
import lombok.Data;
import org.json.simple.JSONObject;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class SchemaRecordModel implements Serializable {
    private String type;
    private List<FieldModel> fields;
    private Boolean optional;
    JSONObject payload;
}
