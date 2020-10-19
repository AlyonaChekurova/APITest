package models;

import lombok.Data;

/**
 * Класс содержит описание структуры отдельного факта, извлекаемого из JSON-файла
 */

@Data
public class FactModel {
    private String _id;
    private String text;
    private String type;
    private UserModel user;
    private int upvotes;
    private String userUpvoted;
}
