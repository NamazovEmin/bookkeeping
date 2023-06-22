/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package az.namazov.bookkeeping.mapper;

import java.util.List;

import az.namazov.bookkeeping.controller.parser.data.XlsBook;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsRow;
import az.namazov.bookkeeping.entity.Operation;

public interface XlsMapper {

    Operation toOperation(TinkoffXlsRow row);
    List<Operation> toOperationList(XlsBook book);
}
