package test;

import entidade.Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @BeforeAll
    public static void setupTest(){
        RestAssured.baseURI = "https://serverest.dev";
    }

    @Test
    public void realizarLoginSucesso(){

        Login login = new Login("fulano@qa.com","teste");
        RestAssured.
                given()
                    .contentType(ContentType.JSON)
                .when()
                    .body(login)
                    .log()
                    .all()
                    .post("login")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log();
    }
    @Test
    public void realizarLoginSemSucessoSenhaIncorreta(){

        Login login = new Login("fulano@qa.com","1231321");
        RestAssured.
                given()
                    .contentType(ContentType.JSON)
                .when()
                    .body(login)
                    .log()
                    .all()
                    .post("login")
                .then()
                    .statusCode(HttpStatus.SC_UNAUTHORIZED)
                    .log().all();
    }
}
