package com.personal.infostore.repository;

import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Operation;
import com.personal.infostore.model.OperationType;
import com.personal.infostore.service.OperationService;

import java.util.Optional;
import java.util.Set;

public interface OperationRepository {
    Optional<Operation> findBySensorId(long sensorId, Set<MeasurementType> types,
                                       Set<OperationType> operationTypes);
}
