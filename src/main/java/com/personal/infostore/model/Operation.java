package com.personal.infostore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Operation {
    private long sensorId;
    private Map<MeasurementType, List<OperationEntry>> values;
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class OperationEntry {
        private MeasurementType measurementType;
        private double value;

    }
    public Operation(){
        this.values = new HashMap<>();
    }

    public void addValue(MeasurementType measurementType, OperationEntry value){
        if(values.containsKey(measurementType)){
            List<OperationEntry> entries = new ArrayList<>(values.get(measurementType));
            entries.add(value);
            values.put(measurementType, entries);
        } else {
            values.put(measurementType, List.of(value));
        }
    }
}
