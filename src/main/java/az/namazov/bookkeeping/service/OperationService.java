package az.namazov.bookkeeping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import az.namazov.bookkeeping.entity.Operation;
import az.namazov.bookkeeping.repozitory.OperationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;

    public Operation save(Operation operation) {
        return operationRepository.save(operation);
    }

    public List<Operation> saveAll(List<Operation> operations) {
        return operationRepository.saveAll(operations);
    }
}
