package com.HN.EireHaven.scraper.daft.ScraperService;

import com.HN.EireHaven.scraper.daft.model.Listing;
import com.HN.EireHaven.scraper.daft.model.SubUnit;
import com.HN.EireHaven.scraper.daft.util.DaftScraperUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DaftScraperService {
    @Autowired
    DaftScraperUtil daftUtil;
    @Autowired
    ChromeDriver chromeDriver;

    Logger logger = LoggerFactory.getLogger("DaftScraperService.class");

    private int pageNo = 1;
    private boolean hasMorePages = true;

    private List<Listing> listingsList = new ArrayList<>();

    private ObjectMapper mapper = new ObjectMapper();


    public List<Listing> scrapeDaft() {
        logger.info("Daft Listings list started populating at {}", System.currentTimeMillis());
        try {
            while (hasMorePages) {

                String urlString = "https://www.daft.ie/property-for-rent/ireland?page=";
                chromeDriver.get(urlString + pageNo);

//                WebElement nextDataElement = chromeDriver.findElement(By.id("__NEXT_DATA__"));
//                String element__NEXT_DATA__ = nextDataElement.getText();
//

                WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
                WebElement nextDataElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("__NEXT_DATA__")));
                Thread.sleep(daftUtil.getRandomMillisecond(4000, 6000));
                String element__NEXT_DATA__ = nextDataElement.getDomProperty("textContent");

                JsonNode rootNode = mapper.readTree(element__NEXT_DATA__);
                JsonNode listingsNode = rootNode.path("props").path("pageProps").path("listings");

                //the next page after last page gives out empty listings, so traversing after last page can be stopped when listings array comes out empty
                if (listingsNode.isArray() && listingsNode.isEmpty()) {
                    logger.info("No more listings on page " + pageNo);
                    hasMorePages = false; // stop paging
                } else {

                    logger.info("Processing page " + pageNo + ", listings found: " + listingsNode.size());
                    fillListingsList(listingsNode);
                    pageNo++;
                }

                Thread.sleep(daftUtil.getRandomMillisecond(8000, 12000));//to make random seconds delays when moving to next page
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listingsList;
    }

    public void fillListingsList(JsonNode listingsNode) {


        for (int i = 0; i < listingsNode.size(); i++) {

            JsonNode listingNode = listingsNode.get(i).path("listing");
            Listing listing = new Listing();
            listing.setId(listingNode.path("id").asLong());
            listing.setTitle(listingNode.path("title").asText());
            listing.setPrice(listingNode.path("price").asText());
            listing.setAbbreviatedPrice(listingNode.path("abbreviatedPrice").asText());
            listing.setNumBedrooms(listingNode.path("numBedrooms").asText());
            listing.setPropertyType(listingNode.path("propertyType").asText());
            listing.setSaleType(listingNode.path("saleType").asText());
            listing.setBerRating(listingNode.path("ber").path("rating").asText());
            listing.setPublishDate(listingNode.path("publishDate").asLong());
            listing.setSimplePublishDate(listingNode.path("publishDate").asLong());
            listing.setSeoFriendlyPath(listingNode.path("seoFriendlyPath").asText());
            listing.setLatitude(listingNode.path("point").path("coordinates").get(1).asDouble());
            listing.setLongitude(listingNode.path("point").path("coordinates").get(0).asDouble());

            List<String> imageLinks = new ArrayList<>();
            JsonNode imagesArrayNode = listingNode.path("media").path("images");
            for (int ii = 0; ii < imagesArrayNode.size(); ii++) {
                String imageLink = imagesArrayNode.get(ii).path("size720x480").asText();
                imageLinks.add(imageLink);
            }
            listing.setImages(imageLinks);

            //subUnits
            JsonNode subUnitsNode = listingNode.path("prs").path("subUnits");
            if (!subUnitsNode.isEmpty()) {
                List<SubUnit> subUnitList = new ArrayList<>();
                for (int j = 0; j < subUnitsNode.size(); j++) {
                    JsonNode subUnitNode = subUnitsNode.get(j);
                    SubUnit subUnit = new SubUnit();
                    subUnit.setId(subUnitNode.path("id").asLong());
                    subUnit.setPrice(subUnitNode.path("price").asText());
                    subUnit.setNumBedrooms(subUnitNode.path("numBedrooms").asText());
                    subUnit.setNumBathrooms(subUnitNode.path("numBathrooms").asText());
                    subUnit.setPropertyType(subUnitNode.path("propertyType").asText());
                    subUnit.setBerRating(subUnitNode.path("ber").path("rating").asText());
                    subUnit.setSeoFriendlyPath(subUnitNode.path("seoFriendlyPath").asText());

                    List<String> subUnitsImageLinks = new ArrayList<>();
                    JsonNode subUnitsImagesArrayNode = subUnitNode.path("media").path("images");
                    for (int jj = 0; jj < subUnitsImagesArrayNode.size(); jj++) {
                        String subUnitImageLinkString = subUnitsImagesArrayNode.get(jj).path("size720x480").asText();
                        subUnitsImageLinks.add(subUnitImageLinkString);
                    }
                    subUnit.setImages(subUnitsImageLinks);

                    subUnitList.add(subUnit);
                }
                listing.setSubUnits(subUnitList);
            }
            listingsList.add(listing);
        }
        logger.info("Daft Listings List populated successfully at {}", System.currentTimeMillis());
    }

}
