import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Chrome {

    public static WebDriver driver;
    @Step("Chrome tarayısıcı ile n11 sistemine giriş için kullanılır")
    public Chrome openChrome() {

        System.setProperty(TestData.path, TestData.chromeDriverPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get(TestData.n11URL);
        driver.manage().window().maximize();
        Allure.addAttachment(TestData.n11URL, "Giriş yapıldığı kontrol edilir.");
        new Library().takeScreenshot();

        return this;
    }
}
