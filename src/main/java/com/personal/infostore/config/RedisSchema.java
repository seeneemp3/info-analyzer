package com.personal.infostore.config;

import com.personal.infostore.model.MeasurementType;

public class RedisSchema {

    public static String sensorKeys() {
        return KeyHelper.getKey("sensors");
    }

    public static String summaryKey(
            long sensorId,
            MeasurementType type
    ) {
        return KeyHelper.getKey("sensors:" + sensorId + ":" + type.name().toLowerCase());
    }

}
