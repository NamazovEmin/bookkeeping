package az.namazov.bookkeeping.mapper;

import az.namazov.bookkeeping.controller.parser.data.XlsBook;

public interface XlsMapperFabric {

    XlsMapper getXlsMapper(XlsBook Book);
}
