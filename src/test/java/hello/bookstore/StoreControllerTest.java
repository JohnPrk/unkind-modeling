package hello.bookstore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hello.bookstore.Discount.ONE_THOUSAND_FIXED;
import static hello.bookstore.Discount.TEN_PERCENT;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StoreControllerTest {
    @LocalServerPort
    private int RANDOM_PORT;

    @BeforeEach
    void setUp() {
        RestAssured.port = RANDOM_PORT;
    }

    @Test
    void 책_전체_조회() {
        ExtractableResponse<Response> response =
                RestAssured
                        .given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .when()
                        .get("store/book")
                        .then().log().all()
                        .extract();

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void 책_부분_조회_파라미터_isbn() {
        String isbn = "1";
        ExtractableResponse<Response> response =
                RestAssured
                        .given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("isbn", isbn)
                        .when()
                        .get("store/book")
                        .then().log().all()
                        .extract();

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void 책_주문() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        List<Discount> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        list.add(ONE_THOUSAND_FIXED);
        list.add(TEN_PERCENT);

        map.put("isbn", "10110127");
        map.put("userId", "abc123");
        map.put("count", "2");
        map.put("couponId", String.valueOf(list));
        String json = mapper.writeValueAsString(map);

        ExtractableResponse<Response> response =
                RestAssured
                        .given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .when()
//                        .params(map)
                        .param(json)
                        .post("store/book")
                        .then().log().all()
                        .extract();


        //        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}