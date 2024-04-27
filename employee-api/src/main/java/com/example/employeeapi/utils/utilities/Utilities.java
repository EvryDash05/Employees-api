package com.example.employeeapi.utils.utilities;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.data.domain.Pageable;

public class Utilities {

    public static int getCurrentPage(Pageable pageable) {
        int page = pageable.getPageNumber();
        if(pageable.getPageNumber() != 0) {
            page -= 1;
        }
        return page;
    }

    public static String generatorRandomId(String prefix) { return prefix + RandomStringUtils.randomNumeric(7); }

    private Utilities() {}

}
