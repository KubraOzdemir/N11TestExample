import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class N11PageBusiness extends Library {

    @Step("Arama alanına {searchText} ifadesi yazılır.")
    public N11PageBusiness fillSearchArea(String searchText) {
        driver.findElement(By.cssSelector("[class='container'] [class='logo']")).click();
        WebElement search = driver.findElement(By.id("searchData"));
        search.sendKeys(searchText);
        return this;
    }

    @Step("Arama Yap butonuna tıklanır.")
    public N11PageBusiness clickSearchButton() {
        clickJs(driver.findElement(By.cssSelector("span[class$='iconSearch']")));
        return this;
    }

    @Step("Arama sonuçlarının listelendiği görülür.")
    public N11PageBusiness checkSearchResultList() {
        String ekran = driver.findElement(By.cssSelector("[id='breadCrumb'] a span")).getText();
        Allure.addAttachment(ekran + "Listelendiği görülür", "");
        takeScreenshot();
        return this;
    }

    @Step("Listelenme alanında 2 sayfaya geçiş yapılır")
    public N11PageBusiness changePage() {
        clickJs(driver.findElement(By.cssSelector("#contentListing > div > div > div.productArea > div.pagination > a:nth-child(2)")));
        return this;
    }

    @Step("Aranan sonuçların listelendiği görülür")
    public N11PageBusiness checkSearchResultListWithPage() {
        String ekran = driver.findElement(By.cssSelector("#contentListing > div > div > div.productArea > div.pagination > a.active")).getText();
        Allure.addAttachment(ekran + " Sayfanın Açıldığı görülür", "");
        takeScreenshot();
        return this;
    }

    @Step("Listeleme ekranında 3. sıradaki ürünün favorilere ekleme butonuna tıklanır.")
    public N11PageBusiness addFavorite() {
        clickJs(driver.findElement(By.cssSelector("#p-267468598 > div.proDetail > span")));
        return this;
    }

    @Step("Üst menüde hesabım işlemlerinde {menu} ekranına giriş yapılır.")
    public N11PageBusiness openMyFavoritesPage(String menu) {
        WebElement favori = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[1]/a"));
        Actions act = new Actions(driver);
        act.moveToElement(favori).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText(menu)).click();
        return this;
    }

    @Step("İstek Listem / Favorilerim ekranından favorilerim ekranına gidilir.")
    public N11PageBusiness checkMyWishListAndFavoritesIsExist() {

        driver.findElement(By.xpath("//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a")).click();

        return this;
    }

    @Step("Favorilerim ekranında seçilen ürünün listelendiği görülür")
    public N11PageBusiness checkMyFavoritesIsExist(boolean durum) {
        if (durum) {
            String urunler = driver.findElement(By.cssSelector("[class='group listingGroup wishListGroup'] [class='pro'] h3")).getText();
            Allure.addAttachment(urunler + "Listelendiği Görülür", "");
        } else {
            Allure.addAttachment("Ürünün Liştelenmediği görülür", "");
        }
        takeScreenshot();

        return this;
    }

    @Step("Favorilere eklenen ürünün sil butonuna tıklanır")
    public N11PageBusiness deleteFavorite() throws InterruptedException {
        clickJs(driver.findElement(By.cssSelector("[class='deleteProFromFavorites']")));
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[class='btn btnBlack confirm']")).click();
        return this;
    }


}
