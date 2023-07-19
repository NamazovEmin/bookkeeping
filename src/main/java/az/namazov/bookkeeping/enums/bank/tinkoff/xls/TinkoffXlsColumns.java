/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package az.namazov.bookkeeping.enums.bank.tinkoff.xls;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TinkoffXlsColumns {

    OPERATION_DATE("Дата операции"),
    PAYMENT_DATE("Дата платежа"),
    CARD_NUMBER("Номер карты"),
    STATUS("Статус"),
    OPERATION_SUM("Сумма операции"),
    OPERATION_CURRENCY("Валюта операции"),
    PAYMENT_SUM("Сумма платежа"),
    PAYMENT_CURRENCY("Валюта платежа"),
    CASH_BACK("Кэшбэк"),
    CATEGORY("Категория"),
    MCC("MCC"),
    DESCRIPTION("Описание"),
    BONUS_WITH_CASH_BACK("Бонусы (включая кэшбэк)"),
    ROUNDING_ON_INVESTMENT_ACCOUNT("Округление на инвесткопилку"),
    OPERATION_SUM_WITH_ROUNDING("Сумма операции с округлением");

    private final String columnName;
}
