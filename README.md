# Adlister Application

This repository holds our Adlister project.

## Setup

1. Clone this repository.

2. Create a Database for this application.

3. Run the provided migration file.

4. Create a configuration class that contains the database connection details
    
    You'll notice that there is a class in the '.gitignore' file, this class holds the sensitive database connections
    In order for this application to connect to the database, you will need to create your own 'Config' class.
    
    Here is a template for the class:
    
    ```java
    public class Config {
        private String url;
        private String username;
        private String password;
    
        public Config() {
            url = "ENTER URL HERE";
                   username = "YOUR_USERNAME";
                    password = "YOUR_PASSWORD";
        }
    
        public String getUrl() {
            return url;
        }
    
        public String getUsername() {
            return username;
        }
    
        public String getPassword() {
            return password;
        }
    }
 ```