package com.example.jazs22622NBP.controller;

import com.example.jazs22622NBP.model.CurrencyDetails;
import com.example.jazs22622NBP.service.CurrencyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/NBP")
public class CurrencyRestController {

    @Autowired
    CurrencyService currencyService;


    @GetMapping("/{wartosc}/{fromDate}/{toDate}")
    @ApiOperation("Return currencies below provided value of currency in selected range of dates")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 502, message = "bad gataway"),
    })


    public ResponseEntity<CurrencyDetails> getCurrency(@PathVariable String wartosc, @PathVariable String fromDate, @PathVariable String toDate) {

        double value= Double.parseDouble(wartosc);

        return ResponseEntity.ok(currencyService.getCurrency(value, fromDate, toDate));
    }

}