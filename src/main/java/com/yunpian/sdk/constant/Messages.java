package com.yunpian.sdk.constant;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
   // private static final String BUNDLE_NAME = "com.yunpian.sdk.constant.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("com.yunpian.sdk.constant.messages");

    private Messages() {
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
