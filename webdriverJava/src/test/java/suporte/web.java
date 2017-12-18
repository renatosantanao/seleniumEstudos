package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class web {

    public static final String USERNAME = "renatosantanadeo1";
    public static final String AUTOMATE_KEY = "BPtyTu3aqQLFsqmtaxqb";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.URLBrowserStack.com/wd/hub";

    public static WebDriver createChrome(){
        // abrindo o navegador
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Windows\\chromedriver.exe");
        WebDriver navegador =  new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // navegando para página  do taskit
        navegador.get("http://www.juliodelima.com.br/taskit/");

        return  navegador;
    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "60.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("URLBrowserStack.debug", "true");

        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
             navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

             // navegando para página  do taskit
             navegador.get("http://www.juliodelima.com.br/taskit/");

        } catch (MalformedURLException e) {
            System.out.println("Houve problema com a url"+e.getMessage());
        }

        return navegador;
    }
}
