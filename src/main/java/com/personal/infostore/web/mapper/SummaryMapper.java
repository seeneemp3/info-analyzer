package com.personal.infostore.web.mapper;

import com.personal.infostore.model.Summary;
import com.personal.infostore.web.dto.SummaryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto> {


}
