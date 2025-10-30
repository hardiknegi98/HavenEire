package com.HN.EireHaven.scraper.daft.ScraperService;

import com.frogking.chromedriver.ChromeDriverBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void test() {
        //bot test
        String driver_home = "chromedriver-win64/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_home);


        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("--window-size=1920,1080");


        ChromeDriver chromeDriver1 = new ChromeDriverBuilder()
                .build(chrome_options, driver_home);


        chromeDriver1.get("https://bot.sannysoft.com");
    }
}
