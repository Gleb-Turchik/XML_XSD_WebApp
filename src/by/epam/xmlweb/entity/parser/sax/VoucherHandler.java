package by.epam.xmlweb.entity.parser.sax;

import by.epam.xmlweb.entity.body.EntertaimentVoucher;
import by.epam.xmlweb.entity.body.Voucher;
import by.epam.xmlweb.entity.body.WellnessVoucher;
import by.epam.xmlweb.entity.parser.VoucherEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static by.epam.xmlweb.entity.parser.VoucherEnum.ENTERTAIMENT;
import static by.epam.xmlweb.entity.parser.VoucherEnum.WELLNESS;

/**
 * Created by Диана и Глеб on 02.06.2016.
 */
public class VoucherHandler extends DefaultHandler{
    private static final Logger LOGGER = LogManager.getLogger();
    private Set<Voucher> vouchers;
    private Voucher currentVoucher = null;
    private WellnessVoucher currentWellness = null;
    private EntertaimentVoucher currentEntertaiment = null;
    private VoucherEnum currentEnum = null;
    private EnumSet<VoucherEnum> withText;
    private String drugs;
    private String procedures;
    private String bar;
    public VoucherHandler() {
        vouchers = new HashSet<>();
        withText = EnumSet.range(VoucherEnum.TYPE, VoucherEnum.BAR );
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if(WELLNESS.getValue().equals(localName)) {
            currentVoucher = new WellnessVoucher();
            currentVoucher.setId(Integer.parseInt(attributes.getValue(0)));
            if(attributes.getLength() == 2) {
                currentVoucher.setName(attributes.getValue(1));
            }
        } else if(ENTERTAIMENT.getValue().equals(localName)) {
            currentVoucher = new EntertaimentVoucher();
            currentVoucher.setId(Integer.parseInt(attributes.getValue(0)));
            if(attributes.getLength() == 2) {
                currentVoucher.setName(attributes.getValue(1));
            }
        } else {
            for (VoucherEnum vn : withText) {
                if(vn.getValue().equals(localName)) {
                    currentEnum = vn;
                }
            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) {
        if(WELLNESS.getValue().equals(localName)) {
            currentWellness = (WellnessVoucher) currentVoucher;
            currentWellness.setDrugs(drugs);
            currentWellness.setProcedures(procedures);
            vouchers.add(currentWellness);
        } else if(ENTERTAIMENT.getValue().equals(localName)) {
            currentEntertaiment = (EntertaimentVoucher) currentVoucher;
            currentEntertaiment.setBar(bar);
            vouchers.add(currentEntertaiment);
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if(currentEnum != null) {
            switch (currentEnum) {
                case TYPE:
                    currentVoucher.setType(s);
                    break;
                case COUNTRY:
                    currentVoucher.setCountry(s);
                    break;
                case NUMBER_DAYS_NIGHTS:
                    currentVoucher.setNumberDaysNights(Integer.parseInt(s));
                    break;
                case TRANSPORT:
                    currentVoucher.setTransport(s);
                    break;
                case COST:
                    currentVoucher.setCost(Integer.parseInt(s));
                    break;
                case STARS:
                    currentVoucher.getHotelCharacs().setStars(Integer.parseInt(s));
                    break;
                case MEAL:
                    currentVoucher.getHotelCharacs().setMeal(Boolean.parseBoolean(s));
                    break;
                case KIND_OF_MEAL:
                    currentVoucher.getHotelCharacs().setKindOfMeal(s);
                    break;
                case ROOMS:
                    currentVoucher.getHotelCharacs().setRooms(Integer.parseInt(s));
                    break;
                case CONDITION:
                    currentVoucher.getHotelCharacs().setCondition(Boolean.parseBoolean(s));
                    break;
                case TV:
                    currentVoucher.getHotelCharacs().setTv(Boolean.parseBoolean(s));
                    break;
                case WIFI:
                    currentVoucher.getHotelCharacs().setWifi(Boolean.parseBoolean(s));
                    break;
                case DRUGS:
                    drugs = s;
                    break;
                case PROCEDURES:
                    procedures = s;
                    break;
                case BAR:
                    bar = s;
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
            currentEnum = null;
        }
    }
}
