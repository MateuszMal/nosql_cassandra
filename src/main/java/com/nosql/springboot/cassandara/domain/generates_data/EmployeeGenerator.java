package com.nosql.springboot.cassandara.domain.generates_data;

import com.mifmif.common.regex.Generex;
import com.nosql.springboot.cassandara.domain.employee.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeGenerator {
    private static final String FIRST_NAMES_FILE = "random_data/firstNames";
    private static final String LAST_NAMES_FILE = "random_data/lastNames";
    private final FileLinesLoader fileLinesLoader;
    private List<String> namesToGenerate;
    private final Random random = new Random();

    public EmployeeGenerator(FileLinesLoader fileLinesLoader) {
        this.fileLinesLoader = fileLinesLoader;
    }

    public List<Employee> generate(int numberOfEmployees) {
        return Stream
                .generate(this::generate)
                .limit(numberOfEmployees)
                .collect(Collectors.toList());
    }

    private Employee generate() {
        Employee employee = new Employee();
        employee.setFirstName(getRandomNames(FIRST_NAMES_FILE));
        employee.setLastName(getRandomNames(LAST_NAMES_FILE));
        employee.setDateOfEmployment(getRandomDate());
        employee.setEmailAddress(getRandomEmailAddress(employee.getLastName()));
        employee.setDeviceMacAddress(getRandomMacAddress());
        employee.setPassword(getRandomPassword());
        return employee;
    }

    private String getRandomPassword() {
        int randomInt = random.nextInt(10) + 1;
        Generex generex = new Generex("[a-zA-Z0-9]{" + randomInt + "}");
        return generex.random();
    }

    private LocalDate getRandomDate() {
        LocalDate start = LocalDate.of(1999, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        return start.plusDays(random.nextInt((int) days + 1));
    }

    private String getRandomEmailAddress(String lastName) {
        return lastName + random.nextInt(300) + "@company.com";
    }

    private String getRandom(List<String> elements) {
        return elements.get(random.nextInt(elements.size()));
    }

    private String getRandomNames(String filePath) {
        return getRandom(getNames(filePath));
    }

    private List<String> getNames(String fileName) {
        if (namesToGenerate == null) {
            namesToGenerate = fileLinesLoader.loadLines(fileName);
        }
        return namesToGenerate;
    }

    private String getRandomMacAddress() {
        Generex generex = new Generex("([A-Z0-9]{2}:){5}[A-Z0-9]{2}");
        return generex.random();
    }
}
