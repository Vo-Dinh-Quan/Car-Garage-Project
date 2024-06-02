package Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class CustomerUtils {
    private static final AtomicInteger customerIDCounter = new AtomicInteger(1); // Starting from 1

    public static String generateUniqueCustomerID() {
        return "KH" + customerIDCounter.getAndIncrement();
    }
}
