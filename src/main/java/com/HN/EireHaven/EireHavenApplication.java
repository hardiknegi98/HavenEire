package com.HN.EireHaven;

import com.HN.EireHaven.scraper.daft.ScraperService.DaftScraperService;
import com.HN.EireHaven.scraper.daft.ScraperService.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EireHavenApplication implements CommandLineRunner {
    @Autowired
    DaftScraperService daftScraper;


    public static void main(String[] args) throws Exception {
        SpringApplication.run(EireHavenApplication.class, args);
    }

    @Override
    public void run(String... args)  {
        try {
//            System.out.println("start: "+System.currentTimeMillis());
//            List<Listing> result =  daftScraper.scrapeDaft();
//            System.out.println("check "+result.size());
//            System.out.println("end: "+System.currentTimeMillis());
//            System.out.println("...");
            Test.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
