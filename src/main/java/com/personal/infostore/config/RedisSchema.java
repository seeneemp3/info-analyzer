package com.personal.infostore.config;

import com.personal.infostore.model.OperationType;

public class RedisSchema {

    public static String sensorKeys() {
        return KeyHelper.getKey("sensors");
    }

    public static String operationKey(
            long sensorId,
            OperationType type
    ) {
        return KeyHelper.getKey("sensors:" + sensorId + ":" + type.name().toLowerCase());
    }

}
