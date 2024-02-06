package com.personal.infostore.web.controller;

import com.personal.infostore.model.SummaryDto;
import com.personal.infostore.web.mapper.SummaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {
    private final SummaryService service;
    private final SummaryMapper mapper;

    @GetMapping("/summary/{sensorId}")
    public SummaryDto getSummary(@PathVariable long sensorId,
                                 @RequestParam(value = "mt", required = false) Set )
}
