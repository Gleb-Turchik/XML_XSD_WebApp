package by.epam.xmlweb.listener;

import by.epam.xmlweb.manager.ConfigurationManager;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Диана и Глеб on 04.07.2016.
 */
@WebListener
public class LangListenerImpl implements HttpSessionListener {
    private static final String LOCALE = "locale";
    private static final String DEFAULT_LOC = "ru_RU";
    private static final String PAGE = "page";
    private static final String RETURN = "path.page.index";
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(LOCALE, DEFAULT_LOC);
        String page = ConfigurationManager.getProperty(RETURN);
        httpSessionEvent.getSession().setAttribute(PAGE, page);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
