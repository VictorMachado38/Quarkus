package jwt;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TokenUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class testeCerveja {
    private String token;

    @BeforeEach
    public void gerarToken() throws Exception {
        token = TokenUtils.generateTokenString("/JWTFuncionarioClaims.json", null);
    }

    @Test
    public void testmethodname() {
        given()
                .header("Authorization", "Bearer "+token)
                .when().get("/cervejas")
                .then()
                .statusCode(200)
                .body(is("Heineken"));
    }

/*
    private String token;
    @BeforeEach
    public void gerarToken() throws Exception {
        token = TokenUtils.generateTokenString("/JWTFuncionarioClaims.json",null);
    }


    @Test
    public void tesste() {
        given()
                .header("Authorization", "Bearer "+token)
                .when().get("/cervejas")
                .then()
                .statusCode(200)
                .body(is("Heineken"));
    }

 */

}
