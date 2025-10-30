package com.HN.EireHaven.scraper.daft.util;

import org.springframework.stereotype.Component;

@Component
public class DaftScraperUtil {
    //to get random milliseconds in range of max and min milliseconds
    public int getRandomMillisecond(int minMilliSecond, int maxMilliSecond) {
        return (int) ((Math.random() * (maxMilliSecond - minMilliSecond)) + minMilliSecond);
    }
}
