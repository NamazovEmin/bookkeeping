package az.namazov.bookkeeping.controller.parser.data;

import java.util.List;

public abstract class XlsBook<T> {
    public abstract List<T> getSheet();
}
