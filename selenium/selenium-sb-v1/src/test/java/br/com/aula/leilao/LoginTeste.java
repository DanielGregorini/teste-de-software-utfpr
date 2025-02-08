package br.com.aula.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTeste {

    private WebDriver browser;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", 
            "/Users/daniel/Documents/codes/java/teste_software/selenium/op63k-2-2024/selenium/drivers/chromedriver");

        browser = new ChromeDriver();
        browser.get("http://localhost:8080/login");
    }

    @Test
    public void deveriaFazerLoginComSucesso() {
        // Act
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("button-submit")).click();

        // Assert
        Assert.assertEquals("http://localhost:8080/leiloes", browser.getCurrentUrl());
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
    }

    @AfterEach
    public void afterEach() {
        if (browser != null) {
            browser.quit();
        }
    }
}

