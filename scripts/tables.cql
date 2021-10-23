CREATE KEYSPACE employeeKeySpace WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 2};

CREATE TABLE employeeKeySpace.employee
(
    id               int PRIMARY KEY,
    firstName        text,
    lastName         text,
    dateOfEmployment date,
    emailAddress     text,
    deviceMacAddress text,
    password text
);

INSERT INTO employeeKeySpace.employee (id, firstName, lastName, dateOfEmployment,
                                       emailAddress, deviceMacAddress, password)
VALUES (1, 'Jan', 'Kowalski', '2020-10-01', 'kowalski@company.pl', '23:A2:3E:FD:E1', 'svfw43sff43');

INSERT INTO employeeKeySpace.employee (id, firstName, lastName, dateOfEmployment,
                                       emailAddress, deviceMacAddress, password)
VALUES (2, 'Piotr', 'Nowakowski', '2001-03-21', 'Nowakowski@company.pl', '23:A2:3E:FD:E1', 'csdv786sdts86d');
