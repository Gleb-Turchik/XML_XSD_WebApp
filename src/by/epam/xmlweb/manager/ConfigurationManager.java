package by.epam.xmlweb.manager;

import java.util.ResourceBundle;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");
    private ConfigurationManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
