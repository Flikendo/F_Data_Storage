package com.flikendo.F_Data_Storage.Constants;

/**
 * Date: 03-12-2023
 * Author: Flikendo
 *
 * DataInfo class. Contains constant info variables
 */
public class DataInfo {
    /**
     * Kafka properties
     */
    public static final String SEPARATOR = ":";
    public static final String BOOTSTRAP_SERVERS_IP = "localhost";
    public static final String BOOTSTRAP_SERVERS_PORT = "9092";
    public static final String GROUP_ID =  "protobuf-consumer-group";
    public static final String AUTO_OFFSET_RESET = "earliest";
    public static final String SCHEMA_REGISTRY_URL = "http://localhost";
    public static final String SCHEMA_REGISTRY_PORT = "8081";
    public static final int MILLIS = 100;
    public static final String TOPIC = "protoTub";

    /**
     * MongoDB properties
     */
}
