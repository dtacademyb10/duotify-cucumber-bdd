package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

public class AlbumDetailsPage {



    public AlbumDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement getAlbumName() {
        return albumName;
    }

    public WebElement getArtistName() {
        return artistName;
    }

    public WebElement getSongCount() {
        return songCount;
    }

    @FindBy (tagName =  "h2")
    private WebElement albumName;

    @FindBy (xpath =  "//p[@role='link']")
    private WebElement artistName;

    @FindBy (xpath =  "(//div[@class='rightSection']//p)[2]")
    private WebElement songCount;


    public void clickOnSongByText(String song) {
        String xpath = "//span[@class='trackName'][.='"+song+"']/parent::div/preceding-sibling::div/img";
        SeleniumUtils.jsClick( Driver.getDriver().findElement(By.xpath(xpath)));
    }
}
