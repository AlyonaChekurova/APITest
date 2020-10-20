package test;

import common.FactsMethods;
import helpers.ConfProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.FactRequest;

/**
 * Тестовый класс для проверки работы API ресурса
 */

public class FactsTest {
    /**
     * Метод вызывает метод получения имени пользователя, написавшего больше всего фактов, и проверяет его соответствие ожидаемому значению
     */
    @Test
    public void getFactsTest() {
        Assert.assertEquals(FactsMethods.getMostWrittenBy(FactRequest.getFacts()), ConfProperties.getProperty("expectedAuthor"), "Ошибка! Полученное значение не совпадает с ожидаемым:");
    }
}