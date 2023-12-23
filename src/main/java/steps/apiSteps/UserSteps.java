package steps.apiSteps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserSteps {
    @Step ("Получение данных о пользователе по имени пользователя")
    public void testGetUserByUsernameNegative() {
        // Базовый URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";

        // Параметры запроса
        String username = "user1";

        // Отправляем GET запрос по указанному имени пользователя
        given()
                .pathParam("username", username)
                .when()
                .get("/{username}")
                .then()
                .statusCode(404) // Проверяем, что код состояния - 404 (Not Found)
                .body("type", equalTo("error")) // Проверяем, что тип ответа - ошибка
                .body("message", equalTo("User not found")); // Проверяем сообщение об ошибке
    }
    @Step ("Создание пользователя")
    public void testCreateUserPositive() {
        // Базовый URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";

        // Тело запроса
        String requestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"Max\",\n" +
                "  \"firstName\": \"Maxim\",\n" +
                "  \"lastName\": \"Maxim\",\n" +
                "  \"email\": \"ebail@kota.com\",\n" +
                "  \"password\": \"u_sobaky_tozhe\",\n" +
                "  \"phone\": \"78005553535\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        // Отправляем POST запрос
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200) // Проверяем, что код состояния - 200 (OK)
                .body("code", equalTo(200)) // и так далее...
                .body("type", equalTo("unknown"))
                .body("message", equalTo("9223372036854775807"));
    }
    @Step ("Обновление данных пользователя")
    public void testUpdateUserPositive() {
        // Базовый URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";

        // Параметры запроса
        String username = "user1";

        // Тело запроса
        String requestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"Max\",\n" +
                "  \"firstName\": \"Maxim\",\n" +
                "  \"lastName\": \"Maxim\",\n" +
                "  \"email\": \"ebail@kota.com\",\n" +
                "  \"password\": \"u_sobaky_tozhe\",\n" +
                "  \"phone\": \"78005553535\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        // Отправляем PUT запрос
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/{username}", username)
                .then()
                .statusCode(200) // Проверяем, что код состояния - 200 (OK)
                .body("code", equalTo(200)) // и так далее...
                .body("type", equalTo("unknown"))
                .body("message", equalTo("9223372036854775807"));
    }
    @Step ("Удаление пользователя")
    public void testDeleteUserPositive() {
        // Базовый URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";

        // Параметры запроса
        String username = "user1";

        // Отправляем DELETE запрос
        given()
                .pathParam("username", username)
                .when()
                .delete("/{username}")
                .then()
                .statusCode(404);
    }
    @Step ("Поиск заказа на покупку по идентификатору")
    public void testGetOrderByIdNegative() {
        // Базовый URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store/order";

        // Параметры запроса
        long orderId = 1;

        // Отправляем GET запрос по указанному идентификатору заказа
        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/{orderId}")
                .then()
                .statusCode(404);
    }

}