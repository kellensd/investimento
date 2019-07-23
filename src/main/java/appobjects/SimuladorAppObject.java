package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimuladorAppObject {

    private final WebDriver driver;

    public SimuladorAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValorAplicarTextField() {
        return driver.findElement(By.id("valorAplicar"));
    }

    public WebElement getValorInvestirTextField() {
        return driver.findElement(By.name("valorInvestir"));
    }

    public WebElement getTempoTextField() {
        return driver.findElement(By.name("tempo"));
    }

    public WebElement getPerfilPessoaFisicaRadio() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[1]/input[1]"));
        return element;
    }

    public WebElement getPerfilPessoaJuridicaRadio() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[1]/input[2]"));
        return element;
    }

    public void openComboPeriodo() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[4]/div[2]/div[2]/a"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public WebElement selectPeriodoAno() {
        openComboPeriodo();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[4]/div[2]/div[2]/ul/li[2]/a"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return element;
    }

    public WebElement getSimularButton() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[5]/ul/li[2]/button"));
        return element;
    }

    public WebElement getValorSimuladoLabel(){
        WebElement element = driver.findElement(By.xpath("//*[@class=\"conteudoGeral conteudoGeralCompleto clearfix\"]/div[@class='centro']" +
                "/div[@class='conteudoPrincipal clearfix']/div[@class='formularioBloco formularioBlocoResultado']" +
                "/div[@class='conteudoBloco']/div[@class='blocoResultadoSimulacao']/span[@class='valor']"));
        return element;
    }

    public WebElement getValorMinimoMessage(){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"valorInvestir-error\"]"));
        return element;
    }
}
