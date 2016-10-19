package by.epam.xmlweb.controller;

import by.epam.xmlweb.command.Command;
import by.epam.xmlweb.command.ActionFactory;
import by.epam.xmlweb.manager.ConfigurationManager;
import by.epam.xmlweb.manager.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final String LOCALE = "locale";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession();
        Command command = ActionFactory.defineCommand(request.getParameter("command"));
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage", MessageManager.getMessage("message.nullpage", (String) session.getAttribute(LOCALE)));
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
