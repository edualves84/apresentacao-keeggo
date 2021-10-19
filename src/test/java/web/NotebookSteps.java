package web;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home;
import pages.Resultado;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class NotebookSteps {
    WebDriver driver;
    String casoDeTeste = "consultar notebook";
    static  String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
    String url = "https://www.mercadolivre.com.br/";
    Home home;
    Resultado resultado;
    Evidencia evidencia;

    @Before
    public void startTest (){

        System.setProperty("webdriver.chrome.driver" , "driver/94/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        evidencia = new Evidencia();
        home = new Home(driver);
        resultado = new Resultado(driver);
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

    }

    @After
    public void driverfinish (){

        driver.quit();

    }


    @Given("^que eu acesso o site do mercado livre$")
    public void queEuAcessoOSiteDoMercadoLivre() throws IOException {
       driver.get(url);
       evidencia.print(driver,dataHora,casoDeTeste,"passo 1 - acessando o site");

    }

    @When("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String arg0) throws IOException {
        home.pesquisarNotebook(arg0);
        evidencia.print(driver,dataHora,casoDeTeste,"passo 2 - escrevendo na caixa de pesquisa");
    }

    @And("^clico na lupa$")
    public void clicoNaLupa() throws IOException {
        home.clicarNaLupa();
        evidencia.print(driver,dataHora,casoDeTeste,"passo 3 - clicando na lupa");
    }

    @Then("^retorna lista para \"([^\"]*)\" como resultado$")
    public void retornaListaParaComoResultado(String arg0) throws IOException {
        assertEquals(resultado.confirmaResultadoNotebook(), arg0);
        evidencia.print(driver,dataHora,casoDeTeste,"passo 4 - comparando resultado esperado");

    }
}
