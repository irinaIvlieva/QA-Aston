import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;

public class Lesson_15 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPaymentBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(., 'Онлайн пополнение')]")));

        // Заменяем переносы на пробелы и нормализуем пробелы
        String normalizedText = title.getText().replace("\n", " ").replaceAll("\\s+", " ").trim();
        Assertions.assertEquals("Онлайн пополнение без комиссии", normalizedText);
    }

    @Test
    public void testPaymentSystemLogos() {
        // Проверка наличия логотипов платёжных систем
        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners li img"));
        Assertions.assertEquals(5, logos.size(), "Должно быть 5 логотипов платёжных систем");

        // Проверка, что логотипы отображаются
        for (WebElement logo : logos) {
            Assertions.assertTrue(logo.isDisplayed(), "Логотип должен отображаться");
        }
    }

    @Test
    public void testDetailsLink() {
        // Проверка работы ссылки «Подробнее о сервисе»
        WebElement detailsLink = driver.findElement(
                By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        Assertions.assertTrue(detailsLink.isDisplayed(), "Ссылка должна отображаться");

        String expectedUrl = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assertions.assertTrue(detailsLink.getAttribute("href").contains(expectedUrl),
                "Ссылка должна вести на правильную страницу");
    }

    @Test
    public void testPaymentForm() {
        // Проверка работы формы оплаты (услуги связи)
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-phone")));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        WebElement submitButton = driver.findElement(
                By.xpath("//form[@id='pay-connection']//button[@type='submit']"));

        // Заполнение полей
        phoneInput.sendKeys("297777777");
        sumInput.sendKeys("10");
        emailInput.sendKeys("test@example.com");

        // Проверка, что кнопка активна
        Assertions.assertTrue(submitButton.isEnabled(), "Кнопка должна быть активна после заполнения полей");
    }
}
