CREATE TABLE IF NOT EXISTS subscriber (
                                          id BIGSERIAL PRIMARY KEY,
                                          email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS payment (
                                       id BIGSERIAL PRIMARY KEY,
                                       amount DECIMAL(19,2) NOT NULL,
    payment_date TIMESTAMP NOT NULL,
    subscriber_id BIGINT NOT NULL,
    CONSTRAINT fk_payment_subscriber
    FOREIGN KEY (subscriber_id)
    REFERENCES subscriber(id)
    ON DELETE CASCADE
    );

INSERT INTO subscriber (email, name)
VALUES
    ('john.doe@example.com', 'John Doe'),
    ('jane.doe.j@example.com', 'Jane Doe jun');

INSERT INTO payment (amount, payment_date, subscriber_id)
VALUES
    (100.50, '2025-04-01T12:00:00', 1),
    (50.75, '2025-04-02T14:30:00', 2);
