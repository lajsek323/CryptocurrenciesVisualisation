package com.example.integracjaprojekt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.Date;

@Getter
@Setter
@Builder
public class CryptoQueryFilterDTO {



    @NonNull
    private Date dateFrom;

    @NonNull
    private Date dateTo;

    @NonNull
    private String ticker;


}
