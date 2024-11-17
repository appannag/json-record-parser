package com.aws.json_record_parser;

import com.aws.json_record_parser.service.AswRecordParserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonRecordParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonRecordParserApplication.class, args);
		AswRecordParserService service = new AswRecordParserService();
		service.parse();
	}

}
