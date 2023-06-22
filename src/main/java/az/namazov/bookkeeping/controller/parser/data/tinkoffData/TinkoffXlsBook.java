package az.namazov.bookkeeping.controller.parser.data.tinkoffData;

import java.util.ArrayList;
import java.util.List;

import az.namazov.bookkeeping.controller.parser.data.XlsBook;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TinkoffXlsBook extends XlsBook {

    private final List<TinkoffXlsRow> sheet = new ArrayList<>();

    @Override
    public List<TinkoffXlsRow> getSheet() {
        return sheet;
    }
}
