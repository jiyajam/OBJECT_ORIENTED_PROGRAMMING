-- Currency Converter Test Queries
-- Run these queries to verify the database setup

-- Query 1: Retrieve all the currencies from the database
SELECT
    id,
    abbreviation,
    name,
    exchange_rate
FROM currency_converter.currency
ORDER BY abbreviation;

-- Query 2: Retrieve the currency with the abbreviation EUR
SELECT
    id,
    abbreviation,
    name,
    exchange_rate
FROM currency_converter.currency
WHERE abbreviation = 'EUR';

-- Query 3: Retrieve the number of currencies in the database
SELECT
    COUNT(*) AS total_currencies
FROM currency_converter.currency;

-- Query 4: Retrieve the currency with the highest exchange rate
SELECT
    id,
    abbreviation,
    name,
    exchange_rate
FROM currency_converter.currency
WHERE exchange_rate = (
    SELECT MAX(exchange_rate)
    FROM currency_converter.currency
);

-- Additional helpful queries for verification:

-- Show all currencies with their exchange rates sorted by rate (highest first)
SELECT
    abbreviation,
    name,
    exchange_rate
FROM currency_converter.currency
ORDER BY exchange_rate DESC;

-- Show conversion example: 100 USD to other currencies
SELECT
    abbreviation,
    name,
    ROUND(100 * exchange_rate, 2) AS amount_in_currency
FROM currency_converter.currency
WHERE abbreviation != 'USD'
ORDER BY abbreviation;
