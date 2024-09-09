insert into currency_exchange.currency (code, full_name, sign) values ('USD', 'US Dollar', '$');
insert into currency_exchange.currency (code, full_name, sign) values ('EUR', 'Euro', '€');
insert into currency_exchange.currency (code, full_name, sign) values ('RUB', 'Russian Ruble', '₽');
insert into currency_exchange.currency (code, full_name, sign) values ('UAH', 'Hryvnia', '₴');
insert into currency_exchange.currency (code, full_name, sign) values ('KZT', 'Tenge', '₸');
insert into currency_exchange.currency (code, full_name, sign) values ('GBP', 'Pound Sterling', '£');
insert into currency_exchange.currency (code, full_name, sign) values ('JPY', 'Japanese Yen', '¥');
insert into currency_exchange.currency (code, full_name, sign) values ('CNY', 'Chinese Yuan', '¥');
insert into currency_exchange.currency (code, full_name, sign) values ('INR', 'Indian Rupee', '₹');
insert into currency_exchange.currency (code, full_name, sign) values ('AUD', 'Australian Dollar', 'A$');
insert into currency_exchange.currency (code, full_name, sign) values ('CAD', 'Canadian Dollar', 'C$');
insert into currency_exchange.currency (code, full_name, sign) values ('CHF', 'Swiss Franc', 'Fr');
insert into currency_exchange.currency (code, full_name, sign) values ('BRL', 'Brazilian Real', 'R$');
insert into currency_exchange.currency (code, full_name, sign) values ('MXN', 'Mexican Peso', '₱');
insert into currency_exchange.currency (code, full_name, sign) values ('ZAR', 'South African Rand', 'R');
insert into currency_exchange.currency (code, full_name, sign) values ('SGD', 'Singapore Dollar', 'S$');
insert into currency_exchange.currency (code, full_name, sign) values ('SEK', 'Swedish Krona', 'kr');
insert into currency_exchange.currency (code, full_name, sign) values ('NOK', 'Norwegian Krone', 'kr');
insert into currency_exchange.currency (code, full_name, sign) values ('DKK', 'Danish Krone', 'kr');
insert into currency_exchange.currency (code, full_name, sign) values ('TRY', 'Turkish Lira', '₺');
insert into currency_exchange.currency (code, full_name, sign) values ('KRW', 'South Korean Won', '₩');
insert into currency_exchange.currency (code, full_name, sign) values ('HKD', 'Hong Kong Dollar', 'HK$');
insert into currency_exchange.currency (code, full_name, sign) values ('NZD', 'New Zealand Dollar', 'NZ$');
insert into currency_exchange.currency (code, full_name, sign) values ('PLN', 'Polish Zloty', 'zł');
insert into currency_exchange.currency (code, full_name, sign) values ('THB', 'Thai Baht', '฿');
insert into currency_exchange.currency (code, full_name, sign) values ('MYR', 'Malaysian Ringgit', 'RM');
insert into currency_exchange.currency (code, full_name, sign) values ('VND', 'Vietnamese Dong', '₫');
insert into currency_exchange.currency (code, full_name, sign) values ('IDR', 'Indonesian Rupiah', 'Rp');
insert into currency_exchange.currency (code, full_name, sign) values ('PHP', 'Philippine Peso', '₱');
insert into currency_exchange.currency (code, full_name, sign) values ('SAR', 'Saudi Riyal', '﷼');
insert into currency_exchange.currency (code, full_name, sign) values ('AED', 'UAE Dirham', 'د.إ');
insert into currency_exchange.currency (code, full_name, sign) values ('CLP', 'Chilean Peso', 'CLP$');
insert into currency_exchange.currency (code, full_name, sign) values ('PKR', 'Pakistani Rupee', '₨');
insert into currency_exchange.currency (code, full_name, sign) values ('EGP', 'Egyptian Pound', 'E£');
insert into currency_exchange.currency (code, full_name, sign) values ('NGN', 'Nigerian Naira', '₦');
insert into currency_exchange.currency (code, full_name, sign) values ('BDT', 'Bangladeshi Taka', '৳');
insert into currency_exchange.currency (code, full_name, sign) values ('ILS', 'Israeli New Shekel', '₪');
insert into currency_exchange.currency (code, full_name, sign) values ('MAD', 'Moroccan Dirham', 'MAD');
insert into currency_exchange.currency (code, full_name, sign) values ('TWD', 'New Taiwan Dollar', 'NT$');
insert into currency_exchange.currency (code, full_name, sign) values ('HUF', 'Hungarian Forint', 'Ft');
insert into currency_exchange.currency (code, full_name, sign) values ('CZK', 'Czech Koruna', 'Kč');
insert into currency_exchange.currency (code, full_name, sign) values ('ARS', 'Argentine Peso', '$');
insert into currency_exchange.currency (code, full_name, sign) values ('COP', 'Colombian Peso', '$');
insert into currency_exchange.currency (code, full_name, sign) values ('PEN', 'Peruvian Sol', 'S/');

insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 2, 0.94);   -- EUR
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 3, 63.75);  -- RUB
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 4, 36.95);  -- UAH
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 5, 469.88); -- KZT
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 6, 0.82);   -- GBP
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 7, 148.94);  -- JPY
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 8, 7.31);   -- CNY
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 9, 83.53);  -- INR
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 10, 1.57);  -- AUD
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 11, 1.36);  -- CAD
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 12, 0.91);  -- CHF
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 13, 5.29);  -- BRL
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 14, 18.75); -- MXN
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 15, 19.24); -- ZAR
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 16, 1.35);  -- SGD
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 17, 10.65); -- SEK
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 18, 10.15); -- NOK
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 19, 11.22); -- DKK
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 20, 26.34); -- TRY
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 21, 1319.74); -- KRW
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 22, 7.85);  -- HKD
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 23, 1.65);  -- NZD
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 24, 4.13);  -- PLN
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 25, 35.27); -- THB
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 26, 4.65);  -- MYR
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 27, 23297.81); -- VND
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 28, 15.12); -- IDR
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 29, 55.18); -- PHP
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 30, 3.75);  -- SAR
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 31, 3.67);  -- AED
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 32, 800.50); -- CLP
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 33, 283.65); -- PKR
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 34, 31.57); -- EGP
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 35, 460.45); -- NGN
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 36, 111.75); -- BDT
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 37, 3.74);  -- ILS
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 38, 10.44); -- MAD
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 39, 30.45); -- TWD
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 40, 389.22); -- HUF
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 41, 21.65); -- CZK
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 42, 0.94);  -- ARS
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 43, 0.94);  -- COP
insert into currency_exchange.exchange_rate (base_currency_id, target_currency_id, rate) values (1, 44, 3.70);  -- PEN

