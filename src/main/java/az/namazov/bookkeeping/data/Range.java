package az.namazov.bookkeeping.data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Range {

    private Date fromDate;
    private Date toDate;
}
