package testes;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Screenshot;
import suporte.generator;
import suporte.web;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "D:\\Workspace\\Selenium\\webdriverJava\\src\\test\\resource\\removerUmContatoDeUsuario.csv")

public class informacaoUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){

        navegador = web.createChrome();

        // clicar no link que tem o texto sign in
        navegador.findElement(By.linkText("Sign in")).click();

        // identificar o formulário de "login" com ID "Signinbox"
        WebElement formularioSigninBox = navegador.findElement(By.id("signinbox"));

        // digitar no campo name "login" que está dentro do formulário de ID "Signinbox" o texto "Julio0001"
        formularioSigninBox.findElement(By.name("login")).sendKeys("Julio0001");

        // digitar no campo name "password" que está dentro do formulário de ID "Signinbox" o texto "123456"
        formularioSigninBox.findElement(By.name("password")).sendKeys("123456");

        // clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        // clicar no link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        // clicar no link que possui "More data about you"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    @Test
    public void testAdicionarInformaaoAdicionaUsuario (@Param(name="tipo")String tipo,
                                                       @Param(name="contato")String contato,
                                                       @Param(name="mensagem")String mensagemEsperada){

        // clicar no botão atráves do seu xpath //[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // identificar a popup onde está o formulário de id addmoredata
        WebElement popupAddmoreData = navegador.findElement(By.id("addmoredata"));

        // no combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddmoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        // no campo de name "contact" digitar "+5531999993322"
        popupAddmoreData.findElement(By.name("contact")).sendKeys(contato);

        // clicar no link de text "SAVE" que está no popup
        popupAddmoreData.findElement(By.linkText("SAVE")).click();

        // na mensagem de id "toast-container" validar que o texto  é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada,mensagem);


        /*--------------------------------------------------------
        -------------------------- desabilitado ------------------
        / validar que dentro do elemento com class "me" possui o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe =  me.getText();

        assertEquals(  "Hi, Julio", textoNoElementoMe );*/
    }

    @Test
    public void removerUmContatoDeUsuario(){
        // clicar no elemento pelo xpath //span[text()="+551155443324"]/following-sibling::a
        navegador.findElement(By.xpath("//span[text()=\"+05131777774444\"]/following-sibling::a")).click();

        // confirmar janela java script
        navegador.switchTo().alert().accept();

        // valdar que a mensagem foi "Rest in peace, dear phone!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Rest in peace, dear phone!",mensagem);

        String screenshotArquivo = "D:\\temp\\evidencias\\" + generator.dataHoraParaArquivo()+ test.getMethodName()+".png";
        Screenshot.tirar(navegador, screenshotArquivo);

        // aguardar até 10 segundos para que a janela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        // clicar no link com o texto "Logout"
        navegador.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() {
        // fechar o navegador
        navegador.quit();
    }
}
