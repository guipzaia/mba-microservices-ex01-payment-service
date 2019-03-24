package br.com.fiap.paymentservice.controllers;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("payments")
public class PaymentController {

    @GetMapping()
    public ResponseEntity<ArrayList<PaymentDTO>> all(){

        log.info("All payments");

        ArrayList<PaymentDTO> payments = new ArrayList<>();

        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable(value = "uuid", required = true) String uuid){

        log.info("Load payment {}", uuid);

        PaymentDTO PaymentDTO = new PaymentDTO();

        return new ResponseEntity<>(PaymentDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PaymentDTO> save(@RequestBody PaymentDTO PaymentDTO){

        log.info("Save payment {}", PaymentDTO);

        return new ResponseEntity<>(PaymentDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<PaymentDTO> update(@PathVariable("uuid") String uuid, @RequestBody PaymentDTO PaymentDTO){

        log.info("Update payment {} {}", uuid, PaymentDTO);

        return new ResponseEntity<>(PaymentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<PaymentDTO> delete(@PathVariable("uuid") String uuid){

        log.info("Delete payment {}", uuid);

        return new ResponseEntity(uuid, HttpStatus.OK);
    }

}
