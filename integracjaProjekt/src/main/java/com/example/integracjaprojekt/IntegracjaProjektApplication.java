package com.example.integracjaprojekt;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import org.apache.tomcat.jni.File;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class IntegracjaProjektApplication {

    public static void main(String[] args) {

        SpringApplication.run(IntegracjaProjektApplication.class, args);

    }

    // import json to pojo -> db

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }

    /*

    @Bean
    CommandLineRunner runner(CryptoService cryptoService) {
        return args -> {
            Gson gson = new Gson();
            try (Reader reader = new FileReader("/integracjaProjekt/src/main/resources/json/DATASET.json")) {

                Type collectionType = new TypeToken<Collection<Crypto>>(){}.getType();
                Collection<Crypto> cryptoList = gson.fromJson(reader, collectionType);

                cryptoService.save((List<Crypto>) cryptoList);

            } catch (IOException e) {
                e.printStackTrace();
            }
            // export from db to json file
            List<Crypto> toFile = cryptoService.getAllCrypto();
            gson.toJson(toFile,new FileWriter("/integracjaProjekt/src/main/resources/json/toJSON.json"));


        };
    }

*/
// import xml to pojo -> db

    @Bean
    CommandLineRunner runner(CryptoService cryptoService) {
        return args -> {


            Reader file = new FileReader("/integracjaProjekt/src/main/resources/xml/DATASETXML.xml");
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(CryptoList.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                CryptoList cryptoList = (CryptoList) jaxbUnmarshaller.unmarshal(file);

                List<Crypto> listToPush = cryptoList.getCrypto();

                cryptoService.save(listToPush);
                List<Crypto> toFile = cryptoService.getAllCrypto();
                ArrayList<Crypto> listCrypt = (ArrayList<Crypto>) toFile;
                CryptoList cryptoList1 = new CryptoList();
                cryptoList1.setCrypto(listCrypt);
                JAXBContext context = JAXBContext.newInstance(CryptoList.class);
                Marshaller jaxbMarshaller = context.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                OutputStream os = new FileOutputStream("/integracjaProjekt/src/main/resources/xml/toXML.xml");
                jaxbMarshaller.marshal(cryptoList1, os);


            } catch (JAXBException e) {
                e.printStackTrace();
            }


        };


    }

}









