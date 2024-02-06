package com.personal.infostore.service;

import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Operation;
import com.personal.infostore.model.OperationType;

import java.util.Set;

public interface OperationService {
    Operation get(long sensorId, Set<MeasurementType> types, Set<OperationType> operationTypes);
}
