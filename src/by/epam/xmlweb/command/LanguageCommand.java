package by.epam.xmlweb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public class LanguageCommand implements Command {
    private final static String LANGUAGE = "lang";
    private final static String LOCALE = "locale";
    private final static String EN = "en";
    private final static String RU = "ru";
    private final static String RUS_LOCALE = "ru_RU";
    private final static String ENG_LOCALE = "en_US";
    private final static String PAGE = "page";

    @Override
    public String execute(HttpServletRequest request) {
        String language = request.getParameter(LANGUAGE);
        String pageAttr = (String) request.getSession().getAttribute(PAGE);
        HttpSession session = request.getSession();
        switch (language) {
            case EN:
                session.setAttribute(LOCALE, ENG_LOCALE);
                break;
            case RU:
                session.setAttribute(LOCALE, RUS_LOCALE);
                break;
        }
        return pageAttr;
    }
}
