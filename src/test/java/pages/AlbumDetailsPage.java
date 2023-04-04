package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class AlbumDetailsPage {



    public AlbumDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy (tagName =  "h2")
    private WebElement albumName;

    @FindBy (xpath =  "//p[@role='link']")
    private WebElement artistName;

    @FindBy (xpath =  "(//div[@class='rightSection']//p)[2]")
    private WebElement songCount;

    @FindBy (xpath =  "//ul[@class='tracklist']//div[@class='trackInfo']//span[@class='trackName']")
    private List<WebElement> allTrackNames;

    @FindBy (xpath =  "//ul[@class='tracklist']//div[@class='trackInfo']//span[@class='artistName']")
    private List<WebElement> allArtistNames;

    @FindBy (xpath =  "//ul[@class='tracklist']//div[@class='trackDuration']//span[@class='duration']")
    private List<WebElement> allTrackDurations;



    public List<List<String>> getSongInfoAsList(){

        List<List<String >> songs =  new ArrayList<>();
        List<String> allTrackNames1 = SeleniumUtils.getElementsText(allTrackNames);
        List<String> allArtistNames1 = SeleniumUtils.getElementsText(allArtistNames);
        List<String> allTrackDurations1 = SeleniumUtils.getElementsText(allTrackDurations);

        for (int i = 0; i < allArtistNames1.size(); i++) {
           songs.add (  List.of(allTrackNames1.get(i),allArtistNames1.get(i), allTrackDurations1.get(i)));
        }



        return  songs;
    }







    public void clickOnSongByText(String song) {
        String xpath = "//span[@class='trackName'][.='"+song+"']/parent::div/preceding-sibling::div/img";
        SeleniumUtils.jsClick( Driver.getDriver().findElement(By.xpath(xpath)));
    }
}
