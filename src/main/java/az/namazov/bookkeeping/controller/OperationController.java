package az.namazov.bookkeeping.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import az.namazov.bookkeeping.controller.parser.XlsParser;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsBook;
import az.namazov.bookkeeping.dto.OperationDTO;
import az.namazov.bookkeeping.entity.Operation;
import az.namazov.bookkeeping.mapper.dto.OperationMapper;
import az.namazov.bookkeeping.mapper.xls.XlsMapper;
import az.namazov.bookkeeping.mapper.xls.XlsMapperFabric;
import az.namazov.bookkeeping.service.OperationService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/operation")
public class OperationController {

    private final OperationService operationService;
    private final OperationMapper operationMapper;
    private final XlsParser tinkofXlsParser;
    private final XlsMapperFabric xlsMapperFabric;


    @PostMapping
    public ResponseEntity<OperationDTO> save(@RequestBody OperationDTO operationDTO) {
        Operation operation = operationMapper.toEntity(operationDTO);
        Operation save = operationService.save(operation);
        OperationDTO body = operationMapper.toDTO(save);
        return ResponseEntity.ok(body);
    }

    @PostMapping("/file")
    public void mapReapExcelDataToDB(@RequestParam("file") MultipartFile file) {
        TinkoffXlsBook book = tinkofXlsParser.fromXls(file);
        XlsMapper xlsMapper = xlsMapperFabric.getXlsMapper(book);
        List<Operation> operations = xlsMapper.toOperationList(book);
        operationService.saveAll(operations);

    }
}
