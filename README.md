# Intitial information

The brewery system BreweryMes can be run in two different ways. One connected directly with the physical simulator at SDU or remotely with the ARSim simulator.
Below informations regarding running the application is shown:

## Running with the physical machine
1. Open a commandline, terminal, bash etc. from the project folder *BreweryMES* and type in following command:
   - `cd src/main/java/mes && docker-compose -f docker-compose1.yml build && docker-compose -f docker-compose1.yml up`
2. When the following error message is shown, close the commandline, terminal, bash etc.:
   - `UaException: status=Bad_Timeout, message=io.netty.channel.ConnectTimeoutException: connection timed out: /192.168.0.122:4840`
3. Navigate to *BreweryMES/src/main/java/mes* and open **Dockerfile1** in a texteditor.
4. Remove the hashtag (#) from line 3, then save and close the document.
5. Connect your WIFI to the brewery machine:
   - WIFI name: **brCubeSoftwareTechnology**
   - Password: **acoposp3**
6. Open a commandline, terminal, bash etc. from the current folder (*BreweryMES/src/main/java/mes*) and run following command:
   - `docker-compose -f docker-compose1.yml build && docker-compose -f docker-compose1.yml up`
7. Open a web browser (we suggest Google Chrome) and enter into address field:
   - localhost:8080
   
### IMPORTANT!! ALWAYS PRESS 'RESET' BEFORE RUNNING THE MES WHEN ENTERING THE WEBSITE!!!  
   
## Running remotely with ARSim simulator

1. Start ARSim
2. Open a commandline, terminal, bash etc. from the project folder *BreweryMES* and type in following command:
   - `cd src/main/java/mes && docker-compose build && docker-compose up`
3. Open a web browser (we suggest Google Chrome) and enter into address field:
   - localhost:8080
   
### IMPORTANT!! ALWAYS PRESS 'RESET' BEFORE RUNNING THE MES WHEN ENTERING THE WEBSITE!!!
