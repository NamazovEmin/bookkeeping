package az.namazov.bookkeeping.dto;

import java.util.Date;

import az.namazov.bookkeeping.controller.enums.Category;
import az.namazov.bookkeeping.controller.enums.Source;
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
