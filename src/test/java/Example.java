import steps.BaseTest;

import org.testng.annotations.Test;

public class Example extends BaseTest {
    @Test(description = "Получение данных о пользователе по имени пользователя")
    public void getUserList() {
        USER_STEPS.testGetUserByUsernameNegative();

    }
    @Test(description = "Создание пользователя")
    public void getUserById() {
        USER_STEPS.testCreateUserPositive();

    }
    @Test(description = "Обновление данных пользователя")
    public void getUserDoesNotExist() {
        USER_STEPS.testUpdateUserPositive();

    }
    @Test(description = "Удаление пользователя")
    public void getResourceListResponse() {
        USER_STEPS.testDeleteUserPositive();

    }
    @Test(description = "Поиск заказа на покупку по идентификатору")
    public void getResourceResponse() {
        USER_STEPS.testGetOrderByIdNegative();

    }

}