package com.rz.librarycore.enums;

/**
 * Created by Rz Rasel 2018-02-19.
 */

public enum Algorithm {
    SHA1("1"), SHA256("2");

    private String mValue;

    Algorithm(String value) {
        this.mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    public static Algorithm getFromText(String text) {
        for (Algorithm algorithm : Algorithm.values()) {
            if (algorithm.mValue.equals(text)) {
                return algorithm;
            }
        }
        return SHA1;
    }
}
