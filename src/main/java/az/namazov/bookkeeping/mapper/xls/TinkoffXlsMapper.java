package az.namazov.bookkeeping.mapper.xls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import az.namazov.bookkeeping.controller.adapter.CategoryAdapter;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsBook;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsRow;
import az.namazov.bookkeeping.entity.Operation;
import az.namazov.bookkeeping.enums.operation.Source;
import az.namazov.bookkeeping.exception.IllegalArgumentException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class TinkoffXlsMapper implements XlsMapper {

    private final CategoryAdapter categoryAdapter;
    private final SimpleDateFormat paymentDateParser = new SimpleDateFormat("dd.MM.yyyy");
    private final SimpleDateFormat operationDateParser = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


    @Override
    public Operation toOperation(TinkoffXlsRow row) {
        Operation operation = new Operation();
        operation.setDate(formOperationDate(row.getOperationDate()));
        operation.setSource(Source.TINKOFF);
        operation.setCost(row.getOperationSum());
        operation.setDetails(row.getDescription());
        operation.setCategory(categoryAdapter.compare(row));
        return operation;
    }

    private Date formOperationDate(String operationDate) {
        try {
            return operationDateParser.parse(operationDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Tinkoff Mapper can't parse OperationDate to Date");
        }
    }

    @Override
    public List<Operation> toOperationList(TinkoffXlsBook book) {
        return book.getSheet().stream().map(this::toOperation).toList();
    }
}
