USE adlister_db;

# CREATE DATABASE adlister_db;
# CREATE USER adlister_user@localhost IDENTIFIED BY '1234';
# GRANT ALL ON adlister_db.* to adlister_user@localhost;

CREATE TABLE IF NOT EXISTS users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(50),
  email  VARCHAR(100) NOT NULL,
  password TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ads (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id int UNSIGNED,
  title  VARCHAR(100) NOT NULL,
  description TEXT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);