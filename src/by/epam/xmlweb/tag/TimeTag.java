package by.epam.xmlweb.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Диана и Глеб on 11.07.2016.
 */
public class TimeTag extends TagSupport{
    private static final Logger LOG = LogManager.getLogger();
    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.write("Hi, it`m my first tag");
        } catch (IOException e) {
            LOG.error("Tag error" + e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
