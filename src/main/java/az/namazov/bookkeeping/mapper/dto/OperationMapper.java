/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package az.namazov.bookkeeping.mapper.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import az.namazov.bookkeeping.dto.OperationDTO;
import az.namazov.bookkeeping.entity.Operation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperationMapper {

    Operation toEntity(OperationDTO operationDTO);

    OperationDTO toDTO(Operation operation);

    List<OperationDTO> toDTO(List<Operation> operationList);
}
