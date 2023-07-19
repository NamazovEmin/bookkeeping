package az.namazov.bookkeeping.dto;

import java.util.Date;

import az.namazov.bookkeeping.enums.operation.Category;
import az.namazov.bookkeeping.enums.operation.Source;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OperationDTO {

    private Date date;

    private Source source;

    private Long cost;

    private String details;

    private Category category;
}
