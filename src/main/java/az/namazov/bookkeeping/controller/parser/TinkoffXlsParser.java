package az.namazov.bookkeeping.controller.parser;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsBook;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsRow;
import az.namazov.bookkeeping.enums.bank.tinkoff.TinkoffCategory;
import az.namazov.bookkeeping.enums.bank.tinkoff.xls.TinkoffXlsColumns;
import az.namazov.bookkeeping.exception.IllegalArgumentException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TinkoffXlsParser implements XlsParser {

    @Override
    public TinkoffXlsBook fromXls(MultipartFile file){
        try {
            return parseXls(file);
        } catch (IOException | ParseException e) {
            throw new IllegalArgumentException("Ошибка при обработке файла XLS");
        }
    }

    private TinkoffXlsBook parseXls(MultipartFile file) throws IOException, ParseException {
        TinkoffXlsBook tinkoffBook = new TinkoffXlsBook();
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        HSSFSheet worksheet = workbook.getSheetAt(0);
        HSSFRow headRow = worksheet.getRow(0);
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            HSSFRow row = worksheet.getRow(i);
            TinkoffXlsRow tinkoffRow = new TinkoffXlsRow();
            try {
                tinkoffRow.setOperationDate(row.getCell(getIndex(TinkoffXlsColumns.OPERATION_DATE, headRow)).getStringCellValue());
                tinkoffRow.setPaymentDate(row.getCell(getIndex(TinkoffXlsColumns.PAYMENT_DATE, headRow)).getStringCellValue());
                tinkoffRow.setCardNumber(row.getCell(getIndex(TinkoffXlsColumns.CARD_NUMBER, headRow), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                tinkoffRow.setStatus(row.getCell(getIndex(TinkoffXlsColumns.STATUS, headRow)).getStringCellValue());
                tinkoffRow.setOperationSum(row.getCell(getIndex(TinkoffXlsColumns.OPERATION_SUM, headRow)).getNumericCellValue());
                tinkoffRow.setOperationCurrency(row.getCell(getIndex(TinkoffXlsColumns.OPERATION_CURRENCY, headRow)).getStringCellValue());
                tinkoffRow.setPaymentSum(row.getCell(getIndex(TinkoffXlsColumns.PAYMENT_SUM, headRow)).getNumericCellValue());
                tinkoffRow.setPaymentCurrency(row.getCell(getIndex(TinkoffXlsColumns.PAYMENT_CURRENCY, headRow)).getStringCellValue());
                tinkoffRow.setCashBack(row.getCell(getIndex(TinkoffXlsColumns.CASH_BACK, headRow), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
                tinkoffRow.setCategory(TinkoffCategory.getCategory(row.getCell(getIndex(TinkoffXlsColumns.CATEGORY, headRow)).getStringCellValue()));
                tinkoffRow.setMcc(row.getCell(getIndex(TinkoffXlsColumns.MCC, headRow), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
                tinkoffRow.setDescription(row.getCell(getIndex(TinkoffXlsColumns.DESCRIPTION, headRow)).getStringCellValue());
                tinkoffRow.setBonusWithCashback(row.getCell(getIndex(TinkoffXlsColumns.BONUS_WITH_CASH_BACK, headRow)).getNumericCellValue());
                tinkoffRow.setRoundingOnInvestmentAccount(row.getCell(getIndex(TinkoffXlsColumns.ROUNDING_ON_INVESTMENT_ACCOUNT, headRow)).getNumericCellValue());
                tinkoffRow.setOperationSumWithRounding(row.getCell(getIndex(TinkoffXlsColumns.OPERATION_SUM_WITH_ROUNDING, headRow)).getNumericCellValue());
                tinkoffBook.getSheet().add(tinkoffRow);
            } catch (NullPointerException e) {
                log.info("Empty cell in exel");
            }
        }
        return tinkoffBook;
    }

    private int getIndex(TinkoffXlsColumns column, HSSFRow headRow) {
        int a = -1;
        for (int i = 0; i <= headRow.getLastCellNum(); i++) {
             if (headRow.getCell(i).getStringCellValue().equals(column.getColumnName())) {
                 a = i;
                 break;
            }
        }
        if (a == -1) {
            throw new IllegalArgumentException("Отсутствует нужная колонка в xls файле");
        }
        return a;
    }
}
