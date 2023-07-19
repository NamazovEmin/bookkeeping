package az.namazov.bookkeeping.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import az.namazov.bookkeeping.controller.parser.XlsParser;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsBook;
import az.namazov.bookkeeping.data.Range;
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
        Operation savedOperation = operationService.save(operation);
        OperationDTO savedOperationDTO = operationMapper.toDTO(savedOperation);
        return ResponseEntity.ok(savedOperationDTO);
    }

    @PostMapping("/file")
    public ResponseEntity<List<OperationDTO>> mapReapExcelDataToDB(@RequestParam("file") MultipartFile file) {
        TinkoffXlsBook book = tinkofXlsParser.fromXls(file);
        XlsMapper xlsMapper = xlsMapperFabric.getXlsMapper(book);
        List<Operation> operations = xlsMapper.toOperationList(book);
        List<Operation> savedOperationList = operationService.saveAll(operations);
        List<OperationDTO> operationDTOList = operationMapper.toDTO(savedOperationList);
        return ResponseEntity.ok(operationDTOList);
    }

    @GetMapping("/range")
    public ResponseEntity<List<OperationDTO>> getOperationsByDateRange(@RequestBody Range range) {
        List<Operation> operationByRange = operationService.getByRange(range);
        List<OperationDTO> operationDTOList = operationMapper.toDTO(operationByRange);
        return ResponseEntity.ok(operationDTOList);
    }
}
