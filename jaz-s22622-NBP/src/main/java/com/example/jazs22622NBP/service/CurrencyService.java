package com.example.jazs22622NBP.service;

import com.example.jazs22622NBP.model.Currency;
import com.example.jazs22622NBP.model.CurrencyDetails;
import com.example.jazs22622NBP.model.NBPdata;
import com.example.jazs22622NBP.repo.CurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;
    private final CurrencyRepository currencyRepository;

    public CurrencyService(RestTemplate restTemplate, CurrencyRepository currencyRepository) {
        this.restTemplate=restTemplate;
        this.currencyRepository=currencyRepository;
    }

    private final String url = "https://api.nbp.pl/api/exchangerates/tables/a";

    public CurrencyDetails getCurrency(double value, String fromDate, String toDate) {

        LocalDate from = LocalDate.parse(fromDate);
        LocalDate to = LocalDate.parse(toDate);


        System.out.println("Data poczatku " +from);
        System.out.println("Data konca " +to);
        NBPdata data = restTemplate.getForObject(url + "/{from}/{to}?format=json", NBPdata.class, from, to);



        BigDecimal avg = BigDecimal.valueOf(data.getRates().stream().map(Currency::getMid).mapToDouble(s -> s).average().orElseThrow())
                .round(new MathContext(3));


        if (value<avg)
        CurrencyDetails response = new CurrencyDetails(avg, value, from, to);
        CurrencyDetails waluty = new CurrencyDetails(avg, value, from, to);

        currencyRepository.save(response);

        return waluty ;
    }



}