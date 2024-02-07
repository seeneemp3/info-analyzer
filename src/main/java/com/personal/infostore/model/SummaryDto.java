package com.personal.infostore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class SummaryDto {
    private long sensorId;
    private Map<MeasurementType, List<Summary.SummaryEntry>> values;

}

