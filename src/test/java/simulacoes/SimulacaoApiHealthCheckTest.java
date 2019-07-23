package simulacoes;

import org.testng.annotations.Test;
import test.BaseTest;

import static io.restassured.RestAssured.when;

public class SimulacaoApiHealthCheckTest extends BaseTest {

    @Test
    public void healthCheckSimulador(){
        when().
                get("/simulador").
        then().
                statusCode(200);
    }
}
