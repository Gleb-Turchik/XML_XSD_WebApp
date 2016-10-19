package by.epam.xmlweb.entity.body;

/**
 * Created by Диана и Глеб on 06.06.2016.
 */
public class EntertaimentVoucher extends Voucher{
    private String bar;

    public EntertaimentVoucher() {
        super();
    }
    public String getBar() {
        return bar;
    }
    public void setBar(String bar) {
        this.bar = bar;
    }
    @Override
    public String toString() {
        return super.toString()+"\nbar: " + bar;
    }
}
