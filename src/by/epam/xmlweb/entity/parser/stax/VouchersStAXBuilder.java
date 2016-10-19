package by.epam.xmlweb.entity.parser.stax;

import by.epam.xmlweb.entity.builder.AbstractVouchersBuilder;
import by.epam.xmlweb.entity.body.EntertaimentVoucher;
import by.epam.xmlweb.entity.body.Voucher;
import by.epam.xmlweb.entity.body.WellnessVoucher;
import by.epam.xmlweb.entity.parser.VoucherEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static by.epam.xmlweb.entity.parser.VoucherEnum.*;

/**
 * Created by Диана и Глеб on 05.06.2016.
 */
public class VouchersStAXBuilder extends AbstractVouchersBuilder {
    private static final Logger LOGGER = LogManager.getLogger();
    private HashSet<Voucher> vouchers = new HashSet<>();
    private XMLInputFactory inputFactory;
    public VouchersStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    private void buildVoucher(Voucher voucher, XMLStreamReader reader) throws XMLStreamException {
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    VoucherEnum voucherEnum = getByValue(name);
                    switch (voucherEnum) {
                        case TYPE:
                            voucher.setType(getXMLText(reader));
                            break;
                        case COUNTRY:
                            voucher.setCountry(getXMLText(reader));
                            break;
                        case NUMBER_DAYS_NIGHTS:
                            name = getXMLText(reader);
                            voucher.setNumberDaysNights(Integer.parseInt(name));
                            break;
                        case TRANSPORT:
                            voucher.setTransport(getXMLText(reader));
                            break;
                        case COST:
                            name = getXMLText(reader);
                            voucher.setCost(Integer.parseInt(name));
                            break;
                        case STARS:
                            voucher.getHotelCharacs().setStars(Integer.parseInt(getXMLText(reader)));
                            break;
                        case MEAL:
                            voucher.getHotelCharacs().setMeal(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case KIND_OF_MEAL:
                            voucher.getHotelCharacs().setKindOfMeal(getXMLText(reader));
                            break;
                        case ROOMS:
                            voucher.getHotelCharacs().setRooms(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CONDITION:
                            voucher.getHotelCharacs().setCondition(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case TV:
                            voucher.getHotelCharacs().setTv(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case WIFI:
                            voucher.getHotelCharacs().setWifi(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (COST.getValue().equals(name)) {
                        return;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Voucher");
    }
    private WellnessVoucher buildWellnessVoucher(XMLStreamReader reader) throws XMLStreamException {
        WellnessVoucher voucher = new WellnessVoucher();
        voucher.setId(Integer.parseInt(reader.getAttributeValue(0)));
        if (reader.getAttributeCount() == 2) {
            voucher.setName(reader.getAttributeValue(1));
        }
        buildVoucher(voucher, reader);
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    VoucherEnum voucherEnum = getByValue(name);
                    switch (voucherEnum) {
                        case DRUGS:
                            voucher.setDrugs(getXMLText(reader));
                            break;
                        case PROCEDURES:
                            voucher.setProcedures(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(WELLNESS.getValue().equals(name)) {
                        return voucher;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Voucher");
    }
    private EntertaimentVoucher buildEntertaimentVoucher(XMLStreamReader reader) throws XMLStreamException {
        EntertaimentVoucher voucher = new EntertaimentVoucher();
        voucher.setId(Integer.parseInt(reader.getAttributeValue(0)));
        if (reader.getAttributeCount() == 2) {
            voucher.setName(reader.getAttributeValue(1));
        }
        buildVoucher(voucher, reader);
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    VoucherEnum voucherEnum = getByValue(name);
                    switch (voucherEnum) {
                        case BAR:
                            voucher.setBar(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(ENTERTAIMENT.getValue().equals(name)) {
                        return voucher;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Voucher");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText().trim();
        }
        return text;
    }
    @Override
    public void buildSetVouchers(String fileName) {
        XMLStreamReader reader = null;
        String name;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (WELLNESS.getValue().equals(name)) {
                        WellnessVoucher voucher = buildWellnessVoucher(reader);
                        vouchers.add(voucher);
                    } else if(ENTERTAIMENT.getValue().equals(name)) {
                        EntertaimentVoucher voucher = buildEntertaimentVoucher(reader);
                        vouchers.add(voucher);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            LOGGER.error("File " + fileName + " not found! " + ex);
        } catch (IOException e) {
            LOGGER.error("Impossible close file "+fileName+" : "+e);
        }
    }
}
