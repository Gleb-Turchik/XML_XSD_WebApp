package by.epam.xmlweb.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public class EmptyCommand implements Command {
    private static final String PATH_PAGE_LOGIN = "/jsp/login.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        return PATH_PAGE_LOGIN;
    }
}
