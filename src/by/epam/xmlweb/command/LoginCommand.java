package by.epam.xmlweb.command;

import by.epam.xmlweb.logic.LoginLogic;
import by.epam.xmlweb.manager.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public class LoginCommand implements Command {
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PATH_PAGE_LOGIN = "/jsp/login.jsp";
    private static final String PATH_PAGE_MAIN = "/jsp/main.jsp";
    private static final String LOCALE = "locale";
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String page = null;
        String login = request.getParameter(PARAM_LOGIN);
        String password = request.getParameter(PARAM_PASSWORD);
        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            if (LoginLogic.checkUser(login, password)) {
                request.setAttribute("user", login);
                page = PATH_PAGE_MAIN;
            } else {
                request.setAttribute("errorLoginPassMessage", MessageManager.getMessage("message.loginerror", (String) session.getAttribute(LOCALE)));
                page = PATH_PAGE_LOGIN;
            }
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getMessage("message.loginerror", (String) session.getAttribute(LOCALE)));
            page = PATH_PAGE_LOGIN;
            }
        return page;
    }
}
