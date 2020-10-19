package models;

import lombok.Data;

/**
 * Класс описывает атрибуты пользователя
 */

@Data
public class UserModel {
    private String _id;
    private UserNameModel name;
}
