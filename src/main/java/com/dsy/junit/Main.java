package com.dsy.junit;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        String line = ",,,,";
        String[] itemarr = StringUtils.split(line, ",");
        System.out.println(itemarr.length);
    }

    private static String xssDefend(String message){
        if (StringUtils.isBlank(message)){
            return null;
        }
        return message.replace("'", "&apos;").replace("\"", "&quot;").
            replace("<", "&lt;").replace(">", "&gt;");
    }
}
