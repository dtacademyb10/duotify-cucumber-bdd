package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='gridViewItem']//span")
    private List<WebElement> albums;

    public List<WebElement> getAlbums() {
        return albums;
    }


    @FindBy(xpath = "//span[@class='trackName']//span")
    private WebElement currentSong;

    public String getCurrentlyPlayingSongText( ){
            return currentSong.getText();
    }


    public void clickOnLinkByText(String linkName) {
        String xpath = "//span[contains(text(), '"+linkName+"')]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void clickOnAlbumByText(String album) {
        Driver.getDriver().findElement(By.xpath("//span[contains(@onclick, 'openPage(\"album.php')]//div[.='"+album+"']")).click();
    }




}
