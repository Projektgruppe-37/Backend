# How to run the BreweryMES

The brewery system BreweryMES can be run in three different ways. One way is to connect directly to the physical simulator at SDU campus, another is to connect remotely with the ARsim simulator. The final way is to run the application directly through an IDE. The application uses Docker to launch, but it is also possible to run through an IDE. The ARSim simulator only works properly on Windows OS, so the launching of the application through Docker, is only implemented to work with Windows OS for the ARSim simulator. When connected to the physical machine, the application can be run in whatever OS the user decides. The same applies for running through an IDE.

### ***IMPORTANT!! ALWAYS PRESS 'RESET' BEFORE RUNNING SIMULATIONS WHEN ENTERING THE MES'S WEBSITE!!!***  

If any problems running the application:
 - Stop and remove all Docker containers and images
 - Make sure all run processes are killed in the IDE

## Running the application with ARsim simulator through docker (Windows)

***MAKE SURE THAT DOCKER IS RUNNING ON YOUR PC BEFORE RUNNING THE APPLICATION***

1. Start ARsim
2. Open a command line, terminal, bash etc. from the project folder *BreweryMES* and type in following command:
   - `cd src/main/java/mes && docker-compose build && docker-compose up`
3. Open a web browser (we suggest Google Chrome) and enter into address field:
   - localhost:8080   
 
    
## Running the application with the physical machine through Docker (Windows, Linux, Mac)
The physical brewery simulator requires to be connected to a specific WIFI for the machine. This WIFI is not connected to the internet (or at least have a very low speed). Because of this, a few extra steps have to be done in order to run the application with Docker.
**Be aware that localhost:8080 takes a long time to load in when connected to the physical machine. Be patient, the page will load and it will not be slow when first loaded.**

***MAKE SURE THAT DOCKER IS RUNNING ON YOUR PC BEFORE RUNNING THE APPLICATION***

1. Open a command line, terminal, bash etc. from the project folder *BreweryMES* and type in following command:
   - `cd src/main/java/mes && docker-compose -f docker-compose1.yml build && docker-compose -f docker-compose1.yml up`
2. When the following error message is shown, close the command line, terminal, bash etc.:
   - `UaException: status=Bad_Timeout, message=io.netty.channel.ConnectTimeoutException: connection timed out: /192.168.0.122:4840`
3. Navigate to *BreweryMES/src/main/java/mes* and open **Dockerfile1** in a text editor.
4. Remove the hashtag (#) from line 3, then save and close the document.
5. Connect your WIFI to the brewery machine:
   - WIFI name: **brCubeSoftwareTechnology**
   - Password: **acoposp3**
6. Open a command line, terminal, bash etc. from the current folder (*BreweryMES/src/main/java/mes*) and run following command:
   - `docker-compose -f docker-compose1.yml build && docker-compose -f docker-compose1.yml up`
7. Open a web browser (we suggest Google Chrome) and enter into address field:
   - localhost:8080


## Running the application WITHOUT Docker through an IDE (Windows, Linux, Mac)
In able to run the simulation without Docker, some initial installations are required. Running through an IDE gives the opportunity to see the database entries, which is lagging from the Docker launched parts, where the database is there, and it will get inserted and read from, but there is no way to actaully see the database.

1. Install PostgreSQL and create a database with the following credentiels:
   - User = postgres
   - Password = root
   - Database = beerMachine
2. Import the BrewerMES application to an IDE and connect the created database
   * If launching the application with ARSim:
      - Launch ARsim
      - Run **BreweryMES-1.0-SIMULATION-IDE.jar** from the IDE.
   * If launching the application connected with physical simulator:
      - Connect to the WIFI:
        - WIFI name: **brCubeSoftwareTechnology**
        - Password: **acoposp3**
    - Run **BreweryMES-1.0-PHYSICAL-IDE.jar** from the IDE.
7. Open a web browser (we suggest Google Chrome) and enter into address field:
   - localhost:8080
   
   ***If an error that port 8080 is blocked when running the *BreweryMES-1.0-SIMULATION-IDE.jar, go to "run" (windows button + r) type "services.msc" and clik "OK", locate "PEM HTTPD" left-click and press "Stop"***
