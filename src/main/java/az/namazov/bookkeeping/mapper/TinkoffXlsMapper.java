/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package az.namazov.bookkeeping.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import az.namazov.bookkeeping.controller.adapter.CategoryAdapter;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsBook;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsRow;
import az.namazov.bookkeeping.entity.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class TinkoffXlsMapper implements XlsMapper {

    private final CategoryAdapter categoryAdapter;

    @Override
    public Operation toOperation(TinkoffXlsRow row) {
        Operation operation = new Operation();
        operation.setCategory(categoryAdapter.compare(row));
        return operation;
    }

    @Override
    public List<Operation> toOperationList(TinkoffXlsBook book) {
        return book.getSheet().stream().map(this::toOperation).toList();
    }



}
