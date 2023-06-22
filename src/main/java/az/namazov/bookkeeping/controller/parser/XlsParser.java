package az.namazov.bookkeeping.controller.parser;

import org.springframework.web.multipart.MultipartFile;

import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsBook;

public interface XlsParser {

    TinkoffXlsBook fromXls(MultipartFile file);
}
