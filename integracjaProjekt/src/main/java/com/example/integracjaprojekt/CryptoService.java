package com.example.integracjaprojekt;


import org.javatuples.Pair;
import org.springframework.stereotype.Service;
import com.example.integracjaprojekt.CryptoRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class CryptoService {

    private final CryptoRepository cryptoRepository;
    private final String warInUkraine = "25-02-2022";

    public CryptoService(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }


    public List<Crypto> getByFilterCriterion(CryptoQueryFilterDTO cryptoQueryFilterDTO){


        List<Crypto> toReturn = cryptoRepository.getCryptoByFilterCriteria(cryptoQueryFilterDTO.getDateFrom(), cryptoQueryFilterDTO.getDateTo(), cryptoQueryFilterDTO.getTicker());
        Collections.reverse(toReturn);

    return toReturn;
    }


    public List<Crypto> getCryptoWhileWar(String ticker) throws ParseException {


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        String dateInString = "2022-02-25";
        Date date = formatter.parse(dateInString);
        String dateInString2 = "2022-04-30";
        Date date2 = formatter.parse(dateInString2);
        System.out.println(date);
        System.out.println(date2);
        List<Crypto> toReturn = cryptoRepository.getCryptoByFilterCriteria(date,date2,ticker);
        Collections.reverse(toReturn);

        return toReturn;

    }

    public List<Crypto> getCryptoWhileEvent2(String ticker) throws ParseException {


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        String dateInString = "2021-09-22";
        Date date = formatter.parse(dateInString);
        String dateInString2 = "2021-10-26";
        Date date2 = formatter.parse(dateInString2);
        System.out.println(date);
        System.out.println(date2);
        List<Crypto> toReturn = cryptoRepository.getCryptoByFilterCriteria(date,date2,ticker);
        Collections.reverse(toReturn);

        return toReturn;

    }

    public List<Crypto> getCryptoWhileEvent3(String ticker) throws ParseException {


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        String dateInString = "2020-03-01";
        Date date = formatter.parse(dateInString);
        String dateInString2 = "2020-05-25";
        Date date2 = formatter.parse(dateInString2);
        System.out.println(date);
        System.out.println(date2);
        List<Crypto> toReturn = cryptoRepository.getCryptoByFilterCriteria(date,date2,ticker);
        Collections.reverse(toReturn);

        return toReturn;

    }





    public List<Object[]> getCryptoLatestPrices(){
        return cryptoRepository.getCryptoLatestPrices();
    }



    public void save(List<Crypto> users) {
        cryptoRepository.saveAll(users);
    }

    public List<Crypto> getCryptoByTicker(String ticker){
        return  cryptoRepository.getCryptoByTicker(ticker);
    }

    public List<Crypto> getAllCrypto(){
        return (List<Crypto>) cryptoRepository.findAll();
    }


    public List<Double> getMarkerCap(String ticker){
        return cryptoRepository.getMarketCapByTicker(ticker);
    }

 // nie dziala

    /*
    public List<Crypto> getCryptoWhileWarInUkraine(String ticker) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = formatter.parse(dateInString);
        return cryptoRepository.getCryptoWhileWar(date,ticker);
    }

     */




}
