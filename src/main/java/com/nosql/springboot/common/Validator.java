package com.nosql.springboot.common;

import com.nosql.springboot.cassandara.domain.employee.Employee;
import org.apache.commons.lang3.StringUtils;

public class Validator {

    public static void checkIdIsNull(Integer id) {
        if (id == null) {
            throw new NullIdException("Provided id is null");
        }
    }

    public static void checkIsStringBlank(Employee employee) {
        if(StringUtils.isBlank(employee.getFirstName())){
            throw new StringIsBlankException("Provided name is empty");
        }
        if(StringUtils.isBlank(employee.getLastName())){
            throw new StringIsBlankException("Provided name is empty");
        }
        if(StringUtils.isBlank(employee.getEmailAddress())){
            throw new StringIsBlankException("Provided email address is empty");
        }
    }

}
