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
    public Summary get(long sensorId, Set<MeasurementType> types, Set<SummaryType> summaryTypes) {
        return repository.findBySensorId(sensorId,
                        types == null ? Set.of(MeasurementType.values()) : types,
                        summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes)
                .orElseThrow(SensorNFE::new);
    }
}
