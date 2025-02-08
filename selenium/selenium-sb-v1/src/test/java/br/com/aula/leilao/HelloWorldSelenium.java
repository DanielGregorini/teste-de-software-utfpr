package br.com.aula.leilao;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

    @Test
    public void hello() {
        // Definir o caminho absoluto do chromedriver no macOS
        System.setProperty("webdriver.chrome.driver",
                "/Users/daniel/Documents/codes/java/teste_software/selenium/op63k-2-2024/selenium/drivers/chromedriver");

        // Inicializar o WebDriver
        WebDriver browser = new ChromeDriver();
        browser.get("http://localhost:8080/leiloes");

        // Fecha o navegador após o teste
        browser.quit();
    }
}
