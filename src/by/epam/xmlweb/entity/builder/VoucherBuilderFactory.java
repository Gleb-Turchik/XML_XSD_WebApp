package by.epam.xmlweb.entity.builder;

import by.epam.xmlweb.entity.parser.dom.VouchersDOMBuilder;
import by.epam.xmlweb.entity.parser.sax.VouchersSAXBuilder;
import by.epam.xmlweb.entity.parser.stax.VouchersStAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Диана и Глеб on 05.06.2016.
 */
public class VoucherBuilderFactory {
    private static final Logger LOGGER = LogManager.getLogger();
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public AbstractVouchersBuilder createVoucherBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new VouchersDOMBuilder();
            case STAX:
                return new VouchersStAXBuilder();
            case SAX:
                return new VouchersSAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
