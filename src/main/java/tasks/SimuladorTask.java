package tasks;

import appobjects.SimuladorAppObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.*;

public class SimuladorTask {

    private final SimuladorAppObject objects;
    private final WebDriver driver;

    public SimuladorTask(WebDriver driver) {
        this.objects = new SimuladorAppObject(driver);
        this.driver = driver;
    }

    public void aplicarValor(String valor) {
        objects.getValorAplicarTextField().sendKeys(valor);
    }

    public void pouparValor(String valor) {
        objects.getValorInvestirTextField().sendKeys(valor);
    }

    public void selecionaPerfilPessoaJuridica() {
        objects.getPerfilPessoaJuridicaRadio().click();
    }

    public void informarTempoDoInvestimento(String tempo) {
        objects.getTempoTextField().sendKeys(tempo);
    }

    public void selecionarPeriodoEmAnos() {
        objects.selectPeriodoAno();
    }

    public void efetuarSimulacao() {
        objects.getSimularButton().click();
    }

    public String getResultadoDaSimulacao() {
        return objects.getValorSimuladoLabel().getText();
    }

    public void waitResultado(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/a")));
    }

    public String getMensagemValorMinimo(){
        return objects.getValorMinimoMessage().getText();
    }
}
