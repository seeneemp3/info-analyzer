package com.personal.infostore.service;

import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Operation;
import com.personal.infostore.model.OperationType;
import com.personal.infostore.model.exception.SensorNFE;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationRepository repository;

    @Override
    public Operation get(long sensorId, Set<MeasurementType> types, Set<OperationType> operationTypes) {
        return repository.findBySensorId(sensorId,
                types == null ? Set.of(MeasurementType.values()) : types,
                operationTypes == null ? Set.of(OperationType.values()) : operationTypes)
                .orElseThrow(SensorNFE::new);
    }
}
