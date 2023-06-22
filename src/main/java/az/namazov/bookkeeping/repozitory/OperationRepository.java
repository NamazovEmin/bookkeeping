package az.namazov.bookkeeping.repozitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.namazov.bookkeeping.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
