package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class AppOrderTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
//        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest() {
        driver.get("http://0.0.0.0:9999/");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Раз Два");
        driver.findElement(By.cssSelector("[type=tel]")).sendKeys("+79123456789");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

}
