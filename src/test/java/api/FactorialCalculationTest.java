package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static utils.FactorialCalculation.factorialCalculation;

public class FactorialCalculationTest {

    public static Object[][] inputData() {
        return new Object[][]{
                {0},
                {-1},
                {1},
                {13},
                {256},
                {2000}
        };
    }

    @ParameterizedTest
    @MethodSource("inputData")
    public void calculationTest(int num) {
        String expectedFactorial = String.valueOf(factorialCalculation(num));
        String actualFactorial = given()
                .baseUri("https://qainterview.pythonanywhere.com")
                .param("number", String.valueOf(num))
                .when()
                .post("/factorial")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .path("answer")
                .toString();
        Assertions.assertEquals(expectedFactorial, actualFactorial, String.format("Factorial calculated incorrect for %d", num));
    }
}
