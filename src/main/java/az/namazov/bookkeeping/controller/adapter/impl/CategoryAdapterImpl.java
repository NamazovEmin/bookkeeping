/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package az.namazov.bookkeeping.controller.adapter.impl;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import az.namazov.bookkeeping.controller.adapter.CategoryAdapter;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsRow;
import az.namazov.bookkeeping.enums.operation.Category;

@Component
public class CategoryAdapterImpl implements CategoryAdapter {

    private static final String bankName = "Тиньков";

    @Override
    public Category compare(TinkoffXlsRow row) {
        return Arrays.stream(Category.values())
                .filter(i -> i.getCompareList().get(bankName).contains(row.getCategory().name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No current category in enum Category"));
    }
}
