package common;

import models.FactModel;
import requests.FactRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс содержит методы для:
 * - вывода в консоль полного перечня фактов
 * - получения имени пользователя, написавшего больше всего фактов
 */

public class FactsMethods {

    /**
     * Перечень фактов и их атрибутов, полученных из  JSON-файла
     */

    private static List<FactModel> facts = FactRequest.getFacts();

    /**
     * Метод для вывода в консоль полного перечня фактов
     */

    public static void printAllFacts() {
        for (int i = 0; i < facts.size(); i++)
            System.out.println(facts.get(i).getText());
    }

    /**
     * Метод для получения имени пользователя, написавшего больше всего фактов
     * Извлекает список пользователей, написавших факты
     * Удаляет повторы из списка и производит подсчет количества фактов, написанных
     * каждым пользователем
     * На основе подсчитанных значений определяется имя, возвращаемое методом
     */

    public static String mostWrittenBy() {
        List<String> authorsNames = new ArrayList<String>();
        for (int i = 0; i < facts.size(); i++)
            authorsNames.add(facts.get(i).getUser().getName().getFullName());

        Set<String> buff = new HashSet<String>(authorsNames);

        List<String> authorsNamesNoRep = new ArrayList<String>();
        authorsNamesNoRep.addAll(buff);

        int[] factsNum;
        factsNum = new int[facts.size()];

        for (int i = 0; i < authorsNamesNoRep.size(); i++)
            for (int j = 0; j < facts.size(); j++)
                if (authorsNamesNoRep.get(i).equals(facts.get(j).getUser().getName().getFullName()))
                    factsNum[i]++;

        int maxFacts = factsNum[0];
        int maxInd = 0;
        for (int i = 1; i < authorsNamesNoRep.size(); i++)
            if (factsNum[i] > maxFacts) {
                maxFacts = factsNum[i];
                maxInd = i;
            }

        return authorsNamesNoRep.get(maxInd);
    }
}