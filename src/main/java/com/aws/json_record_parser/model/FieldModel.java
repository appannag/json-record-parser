package com.aws.json_record_parser.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class FieldModel implements Serializable {
    private String type;
    private Boolean optional;
    private String field;
}
