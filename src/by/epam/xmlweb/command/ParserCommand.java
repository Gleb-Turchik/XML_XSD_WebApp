package by.epam.xmlweb.command;

import by.epam.xmlweb.entity.body.Voucher;
import by.epam.xmlweb.entity.builder.AbstractVouchersBuilder;
import by.epam.xmlweb.entity.builder.VoucherBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Диана и Глеб on 28.06.2016.
 */
public class ParserCommand implements Command {
    private static final String PATH_PAGE_PARSRESULT = "/jsp/parsResult.jsp";
    private String s;
    public ParserCommand (String s) {
        super();
        this.s = s;
    }
        @Override
        public String execute(HttpServletRequest request) {
            VoucherBuilderFactory vFactory = new VoucherBuilderFactory();
            AbstractVouchersBuilder builder = vFactory.createVoucherBuilder(s);
            builder.buildSetVouchers(request.getServletContext().getRealPath("/")+"resources/voucher.xml");
            Set<Voucher> set = builder.getVouchers();
            List<Voucher> list = new ArrayList<>(set);
            list.sort(Comparator.comparing(Voucher::getCost).thenComparing(Voucher::getTransport));
            request.setAttribute("vouchers", list);
            request.setAttribute("parserName", s);
            return PATH_PAGE_PARSRESULT;
    }
}
