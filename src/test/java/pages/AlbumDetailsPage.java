package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

public class AlbumDetailsPage {



    public AlbumDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void clickOnSongByText(String song) {
        String xpath = "//span[@class='trackName'][.='"+song+"']/parent::div/preceding-sibling::div/img";
        SeleniumUtils.jsClick( Driver.getDriver().findElement(By.xpath(xpath)));
    }
}
