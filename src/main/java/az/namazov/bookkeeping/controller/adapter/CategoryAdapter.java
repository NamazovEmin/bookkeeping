package az.namazov.bookkeeping.controller.adapter;

import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsRow;
import az.namazov.bookkeeping.enums.operation.Category;

public interface CategoryAdapter {

    Category compare(TinkoffXlsRow row);
}
