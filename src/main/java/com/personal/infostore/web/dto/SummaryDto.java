package com.personal.infostore.web.dto;

import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Summary;
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

