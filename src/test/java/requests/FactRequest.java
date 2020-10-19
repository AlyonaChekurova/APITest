package requests;

import com.google.gson.Gson;
import common.ConfProperties;
import io.restassured.RestAssured;
import models.FactModel;
import models.FactsModel;

import java.util.List;

/**
 * Класс для выполнения запроса и анализа ответа средствами Rest-Assured
 */

public class FactRequest {

    /**
     * Метод осуществляет запрос по указанному URL, получает JSON-файл, расположенный по данному адресу
     * и возвращает полный перечень фактов и их атрибутов
     */

    public static List<FactModel> getFacts() {
        RestAssured.baseURI = ConfProperties.getProperty("baseURI");
        String response = RestAssured.given().get(ConfProperties.getProperty("endPoint")).then().extract().asString();

        FactsModel allFacts = new Gson().fromJson(response, FactsModel.class);

        return allFacts.getAllFacts();
    }
}
