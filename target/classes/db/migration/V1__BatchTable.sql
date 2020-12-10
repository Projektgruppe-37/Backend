CREATE TABLE data (
    id UUID NOT NULL PRIMARY KEY,
    batch_id FLOAT NOT NULL,
    product_type FLOAT NOT NULL,
    mach_speed FLOAT NOT NULL,
    amount INT NOT NULL,
    produced INT NOT NULL,
    accepted_products INT,
    defect_products INT,
    humidity FLOAT,
    temperature FLOAT,
    vibration FLOAT,
    created TIMESTAMP NOT NULL
);

