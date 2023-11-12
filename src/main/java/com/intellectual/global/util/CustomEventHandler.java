package com.intellectual.global.util;

import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;
import jakarta.xml.bind.ValidationEventLocator;

public class CustomEventHandler implements ValidationEventHandler {
    public boolean handleEvent(ValidationEvent event) {
        if (event.getSeverity() == ValidationEvent.FATAL_ERROR
            || event.getSeverity() == ValidationEvent.ERROR) {
            ValidationEventLocator locator = event.getLocator();
            String message = event.getMessage();

            System.out.println("Severity: " + event.getSeverity());
            System.out.println("Line Number: " + locator.getLineNumber());
            System.out.println("Column Number: " + locator.getColumnNumber());
            System.out.println("Event Message: " + message);
        }
        return false;
    }
}
