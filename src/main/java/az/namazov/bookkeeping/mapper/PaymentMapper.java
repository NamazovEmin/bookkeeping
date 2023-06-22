package az.namazov.bookkeeping.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import az.namazov.bookkeeping.dto.PaymentDTO;
import az.namazov.bookkeeping.entity.Operation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {

    Operation toEntity(PaymentDTO paymentDTO);

    PaymentDTO toDTO(Operation operation);
}
