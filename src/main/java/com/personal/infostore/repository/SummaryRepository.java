package com.personal.infostore.repository;

import com.personal.infostore.model.Data;
import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Summary;
import com.personal.infostore.model.SummaryType;

import java.util.Optional;
import java.util.Set;

public interface SummaryRepository {
    Optional<Summary> findBySensorId(long sensorId, Set<MeasurementType> types, Set<SummaryType> summaryTypes);
    void handle(Data data);
}
