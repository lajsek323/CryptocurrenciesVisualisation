package com.example.integracjaprojekt;

import org.javatuples.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface CryptoRepository extends CrudRepository<Crypto,Long> {


    @Query("select c from Crypto c")
    public List<Crypto> getCryptoByTicker(String ticker);
    @Query("select c.Market_Cap,c.Date from Crypto c")
    public List<Double> getMarketCapByTicker(String ticker);

    @Query("select c from Crypto c WHERE c.Date BETWEEN :dateFrom AND :dateTo AND c.ticker = :ticker")
    List<Crypto> getCryptoByFilterCriteria(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo, @Param("ticker") String ticker);

    @Query(value = "select  MAX(c.Date), c.Open, c.ticker from Crypto c GROUP BY c.ticker",nativeQuery = true)
    List<Object[]> getCryptoLatestPrices();

    @Query("select c.ticker from Crypto c GROUP BY c.ticker")
    List<String> getTickers();





    //Query(value = "select c from Crypto c where c.Date > :dte")
    //public List<Crypto> getCryptoWhileWar(@Param("dte") Date dte, String ticker);

}
