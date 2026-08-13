package com.eazybytes.eazystore.constants;

public class ApplicationConstants {
    private ApplicationConstants() {
        throw new AssertionError("Utility class cannot be instatiated");
    }

    public static final String JWT_SECRET_KEY = "JWT_SECRET";
    public static final String JWT_SECRET_DEFAULT_VALUE = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    public static final String JWT_HEADER = "Authorization"; //same name as react header i.e. (authorization)

    public static final String  ORDER_STATUS_CONFIRMED = "CONFIRMED";
    public static final String  ORDER_STATUS_CREATED = "CREATED";
    public static final String  ORDER_STATUS_CANCELLED = "CANCELLED";

    public static final String  CONTACT_STATUS_OPEN = "OPEN";
    public static final String  CONTACT_STATUS_CLOSE = "CLOSE";
}
