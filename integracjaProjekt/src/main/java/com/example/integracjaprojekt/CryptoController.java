package com.example.integracjaprojekt;


import org.javatuples.Pair;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class CryptoController {


    private final CryptoService cryptoService;


    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Crypto> getCryptoByFilter(@RequestBody CryptoQueryFilterDTO filter) {
         return cryptoService.getByFilterCriterion(filter);
      }

  @GetMapping("/cryptucurrencies/{ticker}/WarInUkraine")
  public List<Crypto> getCryptoWhileWar(@PathVariable String ticker) throws ParseException {


      return cryptoService.getCryptoWhileWar(ticker);
  }

    @GetMapping("/cryptucurrencies/{ticker}/Pandemic")
    public List<Crypto> getCryptoWhileEvent3(@PathVariable String ticker) throws ParseException {


        return cryptoService.getCryptoWhileEvent3(ticker);
    }

    @GetMapping("/cryptucurrencies/{ticker}/Event2")
    public List<Crypto> getCryptoWhileEvent2(@PathVariable String ticker) throws ParseException {


        return cryptoService.getCryptoWhileEvent2(ticker);
    }




  @GetMapping("/cryptucurrencies/prices")
  public List<Object[]> getCryptoLatestPrices(){
        return cryptoService.getCryptoLatestPrices();
  }





    @GetMapping("/cryptocurrencies/{ticker}")
    public List<Crypto> getCrypto(@PathVariable String ticker){

        return cryptoService.getCryptoByTicker(ticker);
    }
    @GetMapping("/cryptocurrencies/{ticker}/marketcap")
    public List<Double> getMarkerCap(String ticker){
        return cryptoService.getMarkerCap(ticker);
    }








}
