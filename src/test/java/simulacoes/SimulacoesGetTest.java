package simulacoes;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class SimulacoesGetTest extends BaseTest {

    @Test
    public void getSimulacoes(){
        List<String> mesesList = new ArrayList<>();
        mesesList.add("112");
        mesesList.add("124");
        mesesList.add("136");
        mesesList.add("148");

        List<String> valoresList = new ArrayList<>();
        valoresList.add("2.802");
        valoresList.add("3.174");
        valoresList.add("3.564");
        valoresList.add("3.971");

        when().
                get("/simulador").
        then().
                statusCode(200).
                body("id", notNullValue()).
                body("meses", is(mesesList)).
                body("valor", is(valoresList));
    }

}
