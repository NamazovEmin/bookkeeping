/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package az.namazov.bookkeeping.mapper.xls;

import org.springframework.stereotype.Component;

import az.namazov.bookkeeping.controller.parser.data.XlsBook;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsBook;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class XlsMapperFabricImpl implements XlsMapperFabric {

    private final TinkoffXlsMapper tinkoffXlsMapper;

    @Override
    public XlsMapper getXlsMapper(XlsBook book) {
        if (book instanceof TinkoffXlsBook) {
            return tinkoffXlsMapper;
        }
        return null;
    }
}
