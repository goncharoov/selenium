package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AppOrderTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
    }

    @BeforeEach
    void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        Thread.sleep(25000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest() {
        driver.get("http://0.0.0.0:9999/");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Гарик Харламов");
        driver.findElement(By.cssSelector("[type=tel]")).sendKeys("+79123456789");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

}
