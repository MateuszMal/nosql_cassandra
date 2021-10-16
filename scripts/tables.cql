CREATE KEYSPACE employeeKeySpace WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 2};

CREATE TABLE employeeKeySpace.employee (
    id int PRIMARY KEY,
    firstName text,
    lastName text,
    birthDate date);
    
    INSERT INTO employeeKeySpace.employee (id, firstName, lastName )
            VALUES (1, 'KRUIKSWIJK', 'hisdgci');
            
                INSERT INTO employeeKeySpace.employee (id, firstName, lastName)
            VALUES (2, 'KRUIKSWIJK2', 'sdfsdfsf');
