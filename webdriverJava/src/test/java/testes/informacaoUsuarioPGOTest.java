package testes;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.loginPage;
import suporte.web;

import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacaoUsuarioPGOTest.csv")

public class informacaoUsuarioPGOTest {
    private WebDriver navegador;

    @Before
    public  void setUp(){
        navegador = web.createBrowserStack();
    }

    @Test
    public void testAdicionarInformaaoAdicionaUsuario(@Param(name="login")String login,
                                                      @Param(name="senha")String senha,
                                                      @Param(name="tipo")String tipo,
                                                      @Param(name="contato")String contato,
                                                      @Param(name="mensagem")String mensagemEsperada){
        String textoToast = new loginPage(navegador)
                .clicarSignin()
                .fazerLogin(login,senha)
                .clicarEmMe()
                .clicarAbaMoreDataAboutYou()
                .clicarBotaoAddMoreDataAboutYou()
                .adicionarContato(tipo,contato)
                .capturarMensagemToast();
        assertEquals(mensagemEsperada,textoToast);
    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}