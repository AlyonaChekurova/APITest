package models;

import lombok.Data;

import java.util.List;

/**
 * Класс описывает полный перечень фактов, извлекаемых из JSON
 * Содержит список фактов
 */

@Data
public class FactsModel {
    private List<FactModel> all;
}
