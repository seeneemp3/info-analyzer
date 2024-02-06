package com.personal.infostore.web.mapper;

import com.personal.infostore.model.Operation;
import com.personal.infostore.model.OperationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper extends  Mappable<Operation, OperationDto> {


}
