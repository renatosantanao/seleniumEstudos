package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class addContactPage extends basePage{

    public addContactPage(WebDriver navegador) {
        super(navegador);
    }

    public addContactPage escolherTipoContato(String tipo){

        // no combo de name "type" escolher a opção "Phone"
        WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        return this;
    }

    public addContactPage digitarContato(String contato){
        navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);

        return this;
    }

    public mePage clicarSalvar(){
        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new mePage(navegador);
    }

    public mePage adicionarContato(String tipo, String contato){
        escolherTipoContato(tipo);
        digitarContato(contato);
        clicarSalvar();

        return new mePage(navegador);
    }
}
