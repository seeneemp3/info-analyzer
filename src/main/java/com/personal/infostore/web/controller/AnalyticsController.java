package com.personal.infostore.web.controller;

import com.personal.infostore.model.Operation;
import com.personal.infostore.model.OperationDto;
import com.personal.infostore.model.OperationType;
import com.personal.infostore.model.SummaryDto;
import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.service.OperationService;
import com.personal.infostore.web.mapper.OperationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {
    private final OperationService service;
    private final OperationMapper mapper;

    @GetMapping("/summary/{sensorId}")
    public OperationDto getSummary(@PathVariable long sensorId,
                                   @RequestParam(value = "mt", required = false) Set<MeasurementType> measurementTypes,
                                   @RequestParam(value = "ot", required = false)Set<OperationType> operationTypes){
        Operation operation = service.get(sensorId, measurementTypes, operationTypes);
        return mapper.toDto(operation);
    }
}
