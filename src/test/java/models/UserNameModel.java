package models;

import lombok.Data;

/**
 * Класс описывает структуру имени пользователя и содержит метод для получения полного имени пользователя
 */

@Data
public class UserNameModel {
    private String first;
    private String last;

    /**
     * Метод для получения полного имени пользователя
     */

    public String getFullName() {
        return String.format("%s %s", first, last);
    }
}
