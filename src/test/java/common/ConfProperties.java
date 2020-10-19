package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс для работы с файлом conf.properties
 */

public class ConfProperties {
    /**
     * Поток для чтения из файла
     */
    protected static FileInputStream fileInputStream;
    /**
     * Параметры, извлекаемые из файла
     */
    protected static Properties PROPERTIES;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * Метод для получения значения параметра из файла conf.properties по его идентификатору
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}


