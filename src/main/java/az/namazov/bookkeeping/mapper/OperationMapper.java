package az.namazov.bookkeeping.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import az.namazov.bookkeeping.dto.OperationDTO;
import az.namazov.bookkeeping.entity.Operation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperationMapper {

    Operation toEntity(OperationDTO operationDTO);

    OperationDTO toDTO(Operation operation);
}
