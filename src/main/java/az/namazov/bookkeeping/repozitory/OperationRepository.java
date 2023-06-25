package az.namazov.bookkeeping.repozitory;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.namazov.bookkeeping.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    Optional<List<Operation>> findAllByDateBetween(Date from, Date to);
}
