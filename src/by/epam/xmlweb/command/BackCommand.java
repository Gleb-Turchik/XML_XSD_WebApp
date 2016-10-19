package by.epam.xmlweb.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 30.06.2016.
 */
public class BackCommand implements Command {
    private static final String PATH_PAGE_MAIN = "/jsp/main.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        return PATH_PAGE_MAIN;
    }
}
