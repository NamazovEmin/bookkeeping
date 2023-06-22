package az.namazov.bookkeeping.controller.adapter;

import az.namazov.bookkeeping.controller.enums.Category;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsRow;

public interface CategoryAdapter {

    Category compare(TinkoffXlsRow row);
}
