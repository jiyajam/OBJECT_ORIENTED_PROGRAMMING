

-- 1. Drop the previous version of the database, if it exists
DROP DATABASE IF EXISTS currency_converter;

-- 2. Create the database
CREATE DATABASE currency_converter;

-- Use the database
USE currency_converter;

-- 3. Create a table for storing the Currency objects
CREATE TABLE currency (
                          id INT NOT NULL AUTO_INCREMENT,
                          abbreviation VARCHAR(3) NOT NULL UNIQUE,
                          name VARCHAR(100) NOT NULL,
                          exchange_rate DECIMAL(12, 6) NOT NULL,
                          PRIMARY KEY (id),
                          INDEX idx_abbreviation (abbreviation)
);

-- 4. Populate the table with data (at least 8 currencies with up-to-date exchange rates)
-- Exchange rates are relative to USD (1 USD = X units of currency, except USD which is 1.0)
INSERT INTO currency (abbreviation, name, exchange_rate) VALUES
                                                             ('USD', 'United States Dollar', 1.000000),
                                                             ('EUR', 'Euro', 0.856000),
                                                             ('GBP', 'British Pound Sterling', 0.746000),
                                                             ('JPY', 'Japanese Yen', 140.850000),
                                                             ('CAD', 'Canadian Dollar', 1.351000),
                                                             ('AUD', 'Australian Dollar', 1.492000),
                                                             ('CHF', 'Swiss Franc', 0.847000),
                                                             ('CNY', 'Chinese Yuan Renminbi', 7.095000),
                                                             ('SEK', 'Swedish Krona', 10.458000),
                                                             ('NOK', 'Norwegian Krone', 10.725000),
                                                             ('KWD', 'Kuwaiti Dinar', 0.307000),
                                                             ('INR', 'Indian Rupee', 83.125000);

-- 5. Drop the user account appuser, if it exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- 6. Create the user account appuser
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'currency123';

-- 7. Grant privileges to the user account appuser
-- The application needs to:
-- - SELECT: Read currency data for conversions
-- - INSERT: Add new currencies (future feature)
-- - UPDATE: Update exchange rates (future feature)
-- - DELETE: Remove obsolete currencies (future feature)
-- Following principle of least privilege for a currency converter application
GRANT SELECT, INSERT, UPDATE, DELETE ON currency_converter.currency TO 'appuser'@'localhost';

-- Apply the privilege changes
FLUSH PRIVILEGES;

-- Display success message
SELECT 'Currency Converter Database created successfully!' AS Status;
