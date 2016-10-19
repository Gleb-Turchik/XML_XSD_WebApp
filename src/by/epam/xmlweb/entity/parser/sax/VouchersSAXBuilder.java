package by.epam.xmlweb.entity.parser.sax;

import by.epam.xmlweb.entity.builder.AbstractVouchersBuilder;
import by.epam.xmlweb.entity.body.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Диана и Глеб on 02.06.2016.
 */
public class VouchersSAXBuilder extends AbstractVouchersBuilder{
    private static final Logger LOGGER = LogManager.getLogger();
    private Set<Voucher> vouchers;
    private VoucherHandler handler;
    private XMLReader reader;
    public VouchersSAXBuilder() {
        handler = new VoucherHandler();
        try {
            reader =  XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOGGER.error("error in sax parser: " + e);
        }
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    @Override
    public void buildSetVouchers(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.error("error in sax parser: " + e);
        } catch (IOException e) {
            LOGGER.error("error in I/O stream: " + e);
        }
        vouchers = handler.getVouchers();
    }
}
