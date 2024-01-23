package com.flikendo.datastorage;

import com.flikendo.datastorage.Connection.KafkaProtoConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FDataStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FDataStorageApplication.class, args);

		KafkaProtoConsumer.fillInProps();
		KafkaProtoConsumer.receiveProtobuf();
	}

}
