package com.oocl.packagebooking.exception;

public class PackageNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Package Not Found";
    }
}
