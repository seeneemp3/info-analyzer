package com.personal.infostore.service;

import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Summary;
import com.personal.infostore.model.SummaryType;

import java.util.Set;

public interface SummaryService {
    Summary get(long sensorId, Set<MeasurementType> types, Set<SummaryType> summaryTypes);
}
