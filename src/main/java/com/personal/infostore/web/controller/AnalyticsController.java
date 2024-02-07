package com.personal.infostore.web.controller;

import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Summary;
import com.personal.infostore.model.SummaryDto;
import com.personal.infostore.model.SummaryType;
import com.personal.infostore.service.SummaryService;
import com.personal.infostore.web.mapper.SummaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {
    private final SummaryService service;
    private final SummaryMapper mapper;

    @GetMapping("/summary/{sensorId}")
    public SummaryDto getSummary(@PathVariable long sensorId,
                                 @RequestParam(value = "mt", required = false) Set<MeasurementType> measurementTypes,
                                 @RequestParam(value = "ot", required = false) Set<SummaryType> summaryTypes) {
        Summary summary = service.get(sensorId, measurementTypes, summaryTypes);
        return mapper.toDto(summary);
    }
}
