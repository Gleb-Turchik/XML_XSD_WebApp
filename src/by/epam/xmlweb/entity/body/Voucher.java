package by.epam.xmlweb.entity.body;


/**
 * Created by Диана и Глеб on 31.05.2016.
 */
public class Voucher {
    public static final String DEFAULT_NAME = "No name";
    private String name;
    private int id;
    private String type;
    private String country;
    private int numberDaysNights;
    private String transport;
    private int cost;
    private HotelCharacs hotelCharacs = new HotelCharacs();

    public Voucher() {
        this.name = DEFAULT_NAME;
    }

    public static String getDefaultName() {
        return DEFAULT_NAME;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberDaysNights() {
        return numberDaysNights;
    }

    public void setNumberDaysNights(int numberDaysNights) {
        this.numberDaysNights = numberDaysNights;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public HotelCharacs getHotelCharacs() {
        return hotelCharacs;
    }

    public void setHotelCharacs(HotelCharacs hotelCharacs) {
        this.hotelCharacs = hotelCharacs;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return  "\n\nName: " + name  +
                ", \nID: " + id  +
                ", \nType: " + type  +
                ", \nCountry: " + country +
                ", \nNumber Days & Nights: " + numberDaysNights +
                ", \nTransport: " + transport +
                ", \nHotel Characteristics:" + hotelCharacs +
                ", \nCost: " + cost;
    }
}
