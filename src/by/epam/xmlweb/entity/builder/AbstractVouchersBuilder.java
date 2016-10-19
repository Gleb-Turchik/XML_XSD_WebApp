package by.epam.xmlweb.entity.builder;

import by.epam.xmlweb.entity.body.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Диана и Глеб on 05.06.2016.
 */
public abstract class AbstractVouchersBuilder {
    private static final Logger LOGGER = LogManager.getLogger();
    protected Set<Voucher> vouchers;
    public AbstractVouchersBuilder() {
        vouchers = new HashSet<>();
    }
    public AbstractVouchersBuilder(Set<Voucher> vouchers) {
        this.vouchers = vouchers;
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    abstract public void buildSetVouchers(String fileName);

}
