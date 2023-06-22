/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package az.namazov.bookkeeping.mapper.xls;

import az.namazov.bookkeeping.controller.parser.data.XlsBook;

public interface XlsMapperFabric {

    XlsMapper getXlsMapper(XlsBook Book);
}
