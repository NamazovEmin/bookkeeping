package az.namazov.bookkeeping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import az.namazov.bookkeeping.controller.parser.XlsParser;
import az.namazov.bookkeeping.dto.PaymentDTO;
import az.namazov.bookkeeping.mapper.PaymentMapper;
import az.namazov.bookkeeping.service.OperationService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/operation")
public class OperationController {

    private final OperationService operationService;
    private final PaymentMapper paymentMapper;
    private final XlsParser tinkofXlsParser;


    @PostMapping
    public ResponseEntity<PaymentDTO> save(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.ok(paymentMapper.toDTO(operationService.save(paymentMapper.toEntity(paymentDTO))));
    }

    @PostMapping("/file")
    public void mapReapExcelDataToDB(@RequestParam("file") MultipartFile file) {
       tinkofXlsParser.fromXls(file);
    }
}
