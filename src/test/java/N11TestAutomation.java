import org.testng.annotations.Test;

public class N11TestAutomation extends BaseTest {

    User testUser = new User("kubraozdemir06@hotmail.com", "test1234");

    String searchData = "Samsung";
    String menuLocation = "İstek Listem / Favorilerim";
    //User testUser = new User(TestData.email, TestData.pass);


    @Test(enabled = true,description = "N11 sistem üzerinde gerekli koşullar yerine getirilerek yapılan işlemler")
    public void chromeTest() throws InterruptedException{
        testStatus("Chrome N11 Sistem ", "Test Başlangıcı");


        loginChrome(testUser);
        Thread.sleep(6000);
        new N11PageBusiness()
                .fillSearchArea(searchData)
                .clickSearchButton()
                .checkSearchResultList()
                .changePage()
                .checkSearchResultList()
                .addFavorite()
                .openMyFavoritesPage(menuLocation)
                .checkMyWishListAndFavoritesIsExist()
                .checkMyFavoritesIsExist(true)
                .deleteFavorite()
                .checkMyFavoritesIsExist(false);

    }
}
