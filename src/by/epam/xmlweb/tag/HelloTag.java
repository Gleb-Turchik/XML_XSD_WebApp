package by.epam.xmlweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Диана и Глеб on 11.07.2016.
 */
public class HelloTag extends TagSupport {
    private String role = "administrator";
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            String to = null;
            if ("administrator".equalsIgnoreCase(role)) {
                to = "Hi, " + role;
            } else {
                to = "Welcome, " + role;
            }
            pageContext.getOut().write("<hr/>" + to + "<hr/>");
        } catch (IOException e){
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
