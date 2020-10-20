package models;

import lombok.Data;

/**
 * Класс описывает атрибуты пользователя: уникальный номер и имя
 */

@Data
public class UserModel {
    private String _id;
    private UserNameModel name;
}
