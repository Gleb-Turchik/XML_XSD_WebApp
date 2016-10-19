package by.epam.xmlweb.entity.exception;

/**
 * Created by Диана и Глеб on 15.06.2016.
 */
public class VoucherException extends Exception {

    public VoucherException() {
    }

    public VoucherException(String message) {
        super(message);
    }

    public VoucherException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoucherException(Throwable cause) {
        super(cause);
    }
}
