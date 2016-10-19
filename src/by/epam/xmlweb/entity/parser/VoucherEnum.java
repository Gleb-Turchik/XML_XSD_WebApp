package by.epam.xmlweb.entity.parser;

/**
 * Created by Диана и Глеб on 02.06.2016.
 */
public enum VoucherEnum {
    TOURIST_VOUCHERS("tourist-vouchers"),
    VOUCHER("voucher"),
    ID("id"),
    NAME("name"),
    WELLNESS("wellness-voucher"),
    ENTERTAIMENT("entertaiment-voucher"),
    TYPE("type"),
    COUNTRY("country"),
    NUMBER_DAYS_NIGHTS("number-days-nights"),
    TRANSPORT("transport"),
    COST("cost"),
    STARS("stars"),
    MEAL("meal"),
    KIND_OF_MEAL("kind-of-meal"),
    ROOMS("rooms"),
    CONDITION("condition"),
    TV("tv"),
    WIFI("wifi"),
    DRUGS("drugs"),
    PROCEDURES("procedures"),
    BAR("bar"),
    HOTEL_CHARACS("hotel-characs");

    private String value;
    private VoucherEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static VoucherEnum getByValue(String s) {
        VoucherEnum voucherEnum = null;
        for(VoucherEnum v : VoucherEnum.values()) {
            if(s.equals(v.getValue())) {
                voucherEnum = v;
            }
        }
        return voucherEnum;
    }
}
