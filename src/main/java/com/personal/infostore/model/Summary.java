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
public class Summary {
    private long sensorId;
    private Map<MeasurementType, List<SummaryEntry>> values;

    public Summary() {
        this.values = new HashMap<>();
    }

    public void addValue(MeasurementType measurementType, SummaryEntry value) {
        if (values.containsKey(measurementType)) {
            List<SummaryEntry> entries = new ArrayList<>(values.get(measurementType));
            entries.add(value);
            values.put(measurementType, entries);
        } else {
            values.put(measurementType, List.of(value));
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class SummaryEntry {
        private SummaryType type;
        private double value;

    }
}
