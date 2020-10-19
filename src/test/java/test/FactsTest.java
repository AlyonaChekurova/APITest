package test;

import common.ConfProperties;
import common.FactsMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Тестовый класс для проверки работы API ресурса
 */

public class FactsTest {

    /**
     * Метод вызывает методы для печати полного перечня фактов и получения имени пользователя, написавшего больше всего фактов,
     * и проверяет его соответствие ожидаемому значению
     */

    @Test
    public void getFactsTest() {
        FactsMethods.printAllFacts();

        Assert.assertEquals(FactsMethods.mostWrittenBy(), ConfProperties.getProperty("expectedAuthor"));
    }
}
