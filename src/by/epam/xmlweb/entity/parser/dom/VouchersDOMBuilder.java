package by.epam.xmlweb.entity.parser.dom;

import by.epam.xmlweb.entity.builder.AbstractVouchersBuilder;
import by.epam.xmlweb.entity.body.EntertaimentVoucher;
import by.epam.xmlweb.entity.body.HotelCharacs;
import by.epam.xmlweb.entity.body.Voucher;
import by.epam.xmlweb.entity.body.WellnessVoucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static by.epam.xmlweb.entity.parser.VoucherEnum.*;

/**
 * Created by Диана и Глеб on 05.06.2016.
 */
public class VouchersDOMBuilder extends AbstractVouchersBuilder{
    private static final Logger LOGGER = LogManager.getLogger();
    private Set<Voucher> vouchers;
    private DocumentBuilder docBuilder;
    public VouchersDOMBuilder() {
        this.vouchers = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Error of configuration DOM parser: " + e);
        }
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    private WellnessVoucher buildWellnessVoucher(Element element) {
        WellnessVoucher wellnessVoucher = new WellnessVoucher();
        buildVoucher(wellnessVoucher, element);
        wellnessVoucher.setDrugs(getElementTextContent(element, DRUGS.getValue()));
        wellnessVoucher.setProcedures(getElementTextContent(element, PROCEDURES.getValue()));
        return wellnessVoucher;
    }
    private EntertaimentVoucher  buildEntertaimentVoucher(Element element) {
        EntertaimentVoucher entertaimentVoucher = new EntertaimentVoucher();
        buildVoucher(entertaimentVoucher, element);
        entertaimentVoucher.setBar(getElementTextContent(element, BAR.getValue()));
        return entertaimentVoucher;
    }
    private void buildVoucher(Voucher voucher, Element voucherElement) {
        String s = voucherElement.getAttribute(NAME.getValue());
        if(!s.isEmpty()){
            voucher.setName(s);
        }
        int id = Integer.parseInt(voucherElement.getAttribute(ID.getValue()));
        voucher.setId(id);
        voucher.setType(getElementTextContent(voucherElement, TYPE.getValue()));
        voucher.setCountry(getElementTextContent(voucherElement, COUNTRY.getValue()));
        voucher.setTransport(getElementTextContent(voucherElement, TRANSPORT.getValue()));
        Integer numberDaysNights = Integer.parseInt(getElementTextContent(voucherElement, NUMBER_DAYS_NIGHTS.getValue()));
        voucher.setNumberDaysNights(numberDaysNights);
        Integer cost = Integer.parseInt(getElementTextContent(voucherElement, COST.getValue()));
        voucher.setCost(cost);

        HotelCharacs hotelCharacs = voucher.getHotelCharacs();
        Element hotelElement = (Element) voucherElement.getElementsByTagName(HOTEL_CHARACS.getValue()).item(0);
        Integer stars = Integer.parseInt(getElementTextContent(hotelElement, STARS.getValue()));
        hotelCharacs.setStars(stars);
        Boolean meal = Boolean.parseBoolean(getElementTextContent(hotelElement, MEAL.getValue()));
        hotelCharacs.setMeal(meal);
        hotelCharacs.setKindOfMeal(getElementTextContent(hotelElement, KIND_OF_MEAL.getValue()));
        Integer rooms = Integer.parseInt(getElementTextContent(hotelElement, ROOMS.getValue()));
        hotelCharacs.setRooms(rooms);
        Boolean condition = Boolean.parseBoolean(getElementTextContent(hotelElement, CONDITION.getValue()));
        hotelCharacs.setCondition(condition);
        Boolean tv = Boolean.parseBoolean(getElementTextContent(hotelElement, TV.getValue()));
        hotelCharacs.setTv(tv);
        Boolean wifi = Boolean.parseBoolean(getElementTextContent(hotelElement, WIFI.getValue()));
        hotelCharacs.setWifi(wifi);
    }
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
    @Override
    public void buildSetVouchers(String fileName) {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList wellnessVouchersList = root.getElementsByTagName(WELLNESS.getValue());
            for (int i = 0; i < wellnessVouchersList.getLength(); i++) {
                Element voucherElement = (Element) wellnessVouchersList.item(i);
                Voucher voucher = buildWellnessVoucher(voucherElement);
                vouchers.add(voucher);
            }
            NodeList entertaimentVouchersList = root.getElementsByTagName(ENTERTAIMENT.getValue());
            for (int i = 0; i < entertaimentVouchersList.getLength(); i++) {
                Element voucherElement = (Element) entertaimentVouchersList.item(i);
                Voucher voucher = buildEntertaimentVoucher(voucherElement);
                vouchers.add(voucher);
            }
        } catch (IOException e) {
            LOGGER.error("File error or I/O error: " + e);
        } catch (SAXException e) {
            LOGGER.error("Parsing failure: " + e);
        }
    }
}
