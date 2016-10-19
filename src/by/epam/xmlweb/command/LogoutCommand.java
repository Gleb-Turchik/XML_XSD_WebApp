package by.epam.xmlweb.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public class LogoutCommand implements Command {
    private static final String PATH_PAGE_INDEX = "/index.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return PATH_PAGE_INDEX;
    }
}
