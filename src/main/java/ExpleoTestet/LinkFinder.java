package ExpleoTestet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class LinkFinder {


    /**
     * findLinks letar upp alla länkar ifrån en websida, jag har hårdkodat in eran ;)
     * <p>
     * Det står i uppgiften att jag inte fick använda något annat än Selenium Webdriver
     * Dock hade jag sjuka problem att få den att fungera och har därav tagit med
     * Geckodriver, Guava samt ett gäng med Maven dependencies.
     */
    public void findLinks(String url) {
        System.setProperty("webdriver.gecko.driver", "src//main//Gecko//geckodriver.exe");
        FirefoxOptions capabilities = new FirefoxOptions();
        WebDriver webdriver = new FirefoxDriver(capabilities);
        capabilities.setCapability("marionette", true);
        webdriver.get(url);
        List<WebElement> links = webdriver.findElements(By.tagName("a"));
        for (var link : links
        ) {
            System.out.println(link.getAttribute("href"));

        }
        webdriver.quit();
    }
}
