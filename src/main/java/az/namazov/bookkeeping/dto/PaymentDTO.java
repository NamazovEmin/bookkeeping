package az.namazov.bookkeeping.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PaymentDTO {

    private Date date;

    private String type;

    private Long cost;

    private String name;

    private String category;
}
