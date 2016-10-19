package by.epam.xmlweb.entity.body;

/**
 * Created by Диана и Глеб on 06.06.2016.
 */
public class WellnessVoucher extends Voucher {
    private String drugs;
    private String procedures;

    public WellnessVoucher() {
        super();
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    @Override
    public String toString() {
        return super.toString()+"\ndrugs: " + drugs +
                ",\nprocedures: " + procedures;
    }
}
