package simulacoes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tasks.SimuladorTask;
import util.DriverUtils;

import static org.testng.Assert.assertEquals;

public class SimularInvestimentoTest {

    private WebDriver driver;
    private SimuladorTask simuladorTask;

    @BeforeTest
    public void init() {
        String url = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";
        driver = DriverUtils.getChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        simuladorTask = new SimuladorTask(driver);
    }

    @Test
    public void criarSimulacaoComSucesso() {
        simuladorTask.selecionaPerfilPessoaJuridica();
        simuladorTask.aplicarValor("20,00");
        simuladorTask.pouparValor("20,00");
        simuladorTask.informarTempoDoInvestimento("10");
        simuladorTask.selecionarPeriodoEmAnos();
        simuladorTask.efetuarSimulacao();
        simuladorTask.waitResultado();
        String simulacaoAtual = simuladorTask.getResultadoDaSimulacao();
        assertEquals("R$ 3.048", simulacaoAtual);
    }

    @Test
    public void criarSimulacaoComFalha() {
        simuladorTask.selecionaPerfilPessoaJuridica();
        simuladorTask.aplicarValor("20,00");
        simuladorTask.pouparValor("0,00");
        simuladorTask.informarTempoDoInvestimento("10");
        String mensagemAtualExibida = simuladorTask.getMensagemValorMinimo();
        assertEquals("Valor mínimo de 20.00", mensagemAtualExibida);
    }

    @AfterTest
    public void stop() {
        driver.quit();
    }
}
