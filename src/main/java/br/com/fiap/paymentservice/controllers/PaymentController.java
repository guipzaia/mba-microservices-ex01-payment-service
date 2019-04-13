package br.com.fiap.paymentservice.controllers;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import java.util.ArrayList;

@Slf4j
@RestController
@Api(value = "Payment", description = "Payment REST API")
@RequestMapping("payments")
public class PaymentController {

    @GetMapping()
    @ApiOperation(httpMethod = "GET", value = "Get all payments")
    	@ApiResponses(value = {
    		@ApiResponse(
                code = 200,
                message = "Get all payments",
                response = ArrayList.class
            )
        })
    public ResponseEntity<ArrayList<PaymentDTO>> all(){

        log.info("All payments");

        ArrayList<PaymentDTO> payments = new ArrayList<>();

        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    @ApiOperation(httpMethod = "GET", value = "Get a payment by Id")
	@ApiResponses(value = {
		@ApiResponse(
            code = 200,
            message = "Get a payment by Id",
            response = PaymentDTO.class
        )
    })
    public ResponseEntity<PaymentDTO> findById(
    		@ApiParam( value = "Payment Id", required = true)
    		@PathVariable(value = "uuid", required = true) String uuid){

        log.info("Load payment {}", uuid);

        PaymentDTO PaymentDTO = new PaymentDTO();

        return new ResponseEntity<>(PaymentDTO, HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(httpMethod = "POST", value = "Save a payment")
	@ApiResponses(value = {
		@ApiResponse(
            code = 200,
            message = "Save a payment",
            response = PaymentDTO.class
        )
    })
    public ResponseEntity<PaymentDTO> save(@RequestBody PaymentDTO PaymentDTO){

        log.info("Save payment {}", PaymentDTO);

        return new ResponseEntity<>(PaymentDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    @ApiOperation(httpMethod = "PUT", value = "Update a payment by Id")
		@ApiResponses(value = {
			@ApiResponse(
	            code = 200,
	            message = "Update a payment by Id",
	            response = PaymentDTO.class
	        )
	    })
    public ResponseEntity<PaymentDTO> update(
    		@ApiParam( value = "Payment Id", required = true) 
    		@PathVariable("uuid") String uuid, @RequestBody PaymentDTO PaymentDTO){

        log.info("Update payment {} {}", uuid, PaymentDTO);

        return new ResponseEntity<>(PaymentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    @ApiOperation(httpMethod = "DELETE", value = "Delete a payment by Id")
	@ApiResponses(value = {
		@ApiResponse(
            code = 200,
            message = "Delete a payment by Id",
            response = PaymentDTO.class
        )
    })
    public ResponseEntity<PaymentDTO> delete(@PathVariable("uuid") String uuid){

        log.info("Delete payment {}", uuid);

        return new ResponseEntity(uuid, HttpStatus.OK);
    }

}
