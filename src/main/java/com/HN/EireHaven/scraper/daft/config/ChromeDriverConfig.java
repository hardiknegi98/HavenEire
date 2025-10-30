package com.HN.EireHaven.scraper.daft.config;


import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChromeDriverConfig {

    @Bean
    public ChromeDriver chromeDriver() {
        String driver_home = "chromedriver-win64/chromedriver.exe";
        return new com.frogking.chromedriver.ChromeDriverBuilder().build(driver_home);
    }
}
