package common;

import models.FactModel;
import models.UserModel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс содержит методы для работы со списком фактов, извлеченным из JSON
 * Содержит методы для:
 * - получения списка пользователей без повторений
 * - объединения в массивы всех фактов с одним автором
 * - сортировки массивов фактов по убыванию длины
 * - получения имени пользователя, написавшего наибольшее число фактов
 */

public class FactsMethods {
    /**
     * Метод для получения списка пользователей без повторений
     */
    public static List<UserModel> getUsers(List<FactModel> facts) {
        return facts
                .stream()
                .map(FactModel::getUser)
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Метод для формирования массива фактов, написанных пользователем user
     */
    private static List<FactModel> sortFactByUser(List<FactModel> facts, UserModel user) {
        return facts
                .stream()
                .filter(fact -> user.equals(fact.getUser()))
                .collect(Collectors.toList());
    }

    /**
     * Метод для группировки фактов, написанных одним пользователем, в массивы
     */
    public static List<List<FactModel>> sortByUser(List<FactModel> facts, List<UserModel> users) {
        return users
                .stream()
                .map(user -> sortFactByUser(facts, user))
                .collect(Collectors.toList());

    }

    /**
     * Метод для сортировки массива сгрупированных по авторам фактов по убыванию длин
     */
    public static List<List<FactModel>> sortFactsByCount(List<List<FactModel>> facts) {
        return facts
                .stream()
                .sorted(((o1, o2) -> o2.size() - o1.size()))
                .collect(Collectors.toList());
    }

    /**
     * Метод для получения имени пользователя, написавшего больше всего фактов
     */
    public static String getMostWrittenBy(List<FactModel> facts) {
        return sortFactsByCount(
                sortByUser(facts,
                        getUsers(facts)
                )
        ).get(0).get(0).getUser().getName().getFullName();
    }
}