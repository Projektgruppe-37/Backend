# Intitial information

The brewery system BreweryMes can be run in two different ways. One connected directly with the physical simulation at SDU or remotely with the ARSim simulator.
Below informations regarding running the application is shown:

## Running with the physical machine
1. Connect your WIFI to the brewery machine:
   - WIFI name: **brCubeSoftwareTechnology**
   - Password: **acoposp3**
1. Navigate to the *BreweryMES/src/main/java/mes* folder where the **BreweryMES-1.0-SNAPSHOT.jar**, **Dockerfile** and **docker-compose.yml** is located.
2. Open a commandline, terminal, bash etc from this folder.
3. Run the following command:   
   - `docker-compose build && docker-compose up`
4. Open a web browser (we suggest Google Chrome or Firefox) and enter into address field:
   - localhost:8080
   
### IMPORTANT!! ALWAYS PRESS 'RESET' BEFORE RUNNING THE MES WHEN ENTERING THE WEBSITE!!!
   
   
## Running remotely with ARSim simulator
1. Start ARSim
2. Create a PostgresSQL database with following credentials
   - User: postgres
   - Password: root
   - Database name: beerMachine
3. Navigate into the application folders:
   - In *BreweryMES/src/main/java/mes/model* open **ConfigUa.java**
     - Comment out line 31 and 32 using "//".
     - Remove comment declarations on line 28 and 29.
   - In *BreweryMES/src/main/resources* open **application.yml**
     - Comment out line 8 using "#".
     - Remove comment declaration on line 7.
 4. Navigate to *BreweryMES/src/main/java/mes*
    - Open a commandline, terminal, bash etc from this folder.
    - Run the following command:
      - `java -jar BreweryMES-1.0-SNAPSHOT.jar`
 5. Open a web browser (we suggest Google Chrome or Firefox) and enter into address field:
    - localhost:8080
    
 ### IMPORTANT!! ALWAYS PRESS 'RESET' BEFORE RUNNING THE MES WHEN ENTERING THE WEBSITE!!!
