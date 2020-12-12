# How to run the BreweryMES

The brewery system BreweryMES can be run in two different ways. One way is to connect directly to the physical simulator at SDU campus, the other is to connect remotely with the ARSim simulator. The application requires Docker to run. The ARSim simulator only works properly on Windows OS, so the launching of the application through Docker, is only implemented to work with Windows OS for the ARSim simulator. When connected to the physical machine, the application can be run in whatever OS the user decides. ***MAKE SURE THAT DOCKER IS RUNNING ON YOUR PC BEFORE RUNNING THE APPLICATION***

## Running remotely with ARSim simulator (Windows)

1. Start ARSim
2. Open a command line, terminal, bash etc. from the project folder *BreweryMES* and type in following command:
   - `cd src/main/java/mes && docker-compose build && docker-compose up`
3. Open a web browser (we suggest Google Chrome) and enter into address field:
   - localhost:8080   
   
### IMPORTANT!! ALWAYS PRESS 'RESET' BEFORE RUNNING THE MES WHEN ENTERING THE WEBSITE!!!
  
    
## Running with the physical machine (Windows, Linux, Mac)
The physical brewery simulator requires to be connected to a specific WIFI for the machine. This WIFI is not connected to the internet (or at least have a very low speed). Because of this, a few extra steps have to be done in order to run the application with Docker.
**Be aware that localhost:8080 takes a long time to load in when connected to the physical machine. Be patient, the page will load and it will not be slow when first loaded.**

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
   
### IMPORTANT!! ALWAYS PRESS 'RESET' BEFORE RUNNING THE MES WHEN ENTERING THE WEBSITE!!!  
   

