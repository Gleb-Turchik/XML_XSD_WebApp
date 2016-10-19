package by.epam.xmlweb.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public interface Command {
    String execute(HttpServletRequest request);
}
