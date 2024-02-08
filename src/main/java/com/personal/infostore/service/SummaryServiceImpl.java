package com.personal.infostore.service;

import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Summary;
import com.personal.infostore.model.SummaryType;
import com.personal.infostore.model.exception.SensorNFE;
import com.personal.infostore.repository.SummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepository repository;

    @Override
    public Summary get(long sensorId, Set<MeasurementType> mTypes, Set<SummaryType> sTypes) {
        return repository.findBySensorId(sensorId,
                        mTypes == null ? Set.of(MeasurementType.values()) : mTypes,
                        sTypes == null ? Set.of(SummaryType.values()) : sTypes)
                .orElseThrow(SensorNFE::new);
    }
}
