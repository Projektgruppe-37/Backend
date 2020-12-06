CREATE TABLE data (
    id UUID NOT NULL PRIMARY KEY,
    humidity FLOAT,
    temperature FLOAT,
    produced INT NOT NULL,
    vibration FLOAT,
    product_type INT NOT NULL,
    mach_speed INT NOT NULL,
    amount INT NOT NULL,
    accepted_products INT,
    defect_products INT
   -- created TIMESTAMP NOT NULL
);