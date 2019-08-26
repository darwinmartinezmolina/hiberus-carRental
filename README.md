
# CarRental Hiberus

CarRental Hiberus is a website that makes easier administration of vehicles, drivers and trips, created with the latest technologies. 

# New Features!

  - Create, read, update and delete drivers.
  - Create, read, update and delete vehicles.
  - Create and read trips.
  - Also, includes business logic that avoid:
    - Configure vehicles not availables
    - Configure drivers not availables
    - Configure vehicles and drivers with diffents types of licenses
    
### Drivers list
![N|Solid](https://drive.google.com/uc?export=view&id=1R-6RrapPKKxnFa5fwWxsPNIje0R1iKH8)

### Update driver
![N|Solid](https://drive.google.com/uc?export=view&id=1JXo3ydO_8MX1D5PNz5Ng68D3QKOxMveM)
![N|Solid](https://drive.google.com/uc?export=view&id=16XpMvjM0kMfYmuU56f36awXopcGr85I_)

### Create driver (mobile version)
![N|Solid](https://drive.google.com/uc?export=view&id=1uX1rktk981l5nsrEgvUpG4bTr3P5GRrq)
![N|Solid](https://drive.google.com/uc?export=view&id=1pK8zieLz-yWvqqnr_lr0UI-mRCHMLXlK)

### Drivers list (mobile version)
![N|Solid](https://drive.google.com/uc?export=view&id=137SO-GCFZHDa0oCbuA6XFkZxhgF4j4Ri)

### Tech

CarRental Hiberus use the following technologies:

* [Angular] - HTML enhanced for web apps!
* [Bootstrap] - Open source toolkit for developing with HTML, CSS, and JS
* [Spring Framework] - Offers a simple and accessible programming model to the most common distributed system patterns, helping developers build resilient, reliable, and coordinated applications
* [Rest Services] - It is an architectural style that specifies constraints, such as the uniform interface, that if applied to a web service induce desirable properties, such as performance, scalability, and modifiability, that enable services to work best on the Web.
* [Hibernate] - Hibernate ORM enables developers to more easily write applications whose data outlives the application process. As an Object/Relational Mapping (ORM) framework, Hibernate is concerned with data persistence as it applies to relational databases (via JDBC)
* [MySql] -  It is an open-source relational database management system (RDBMS).


# Installation Database Component

### Prerequisites
Download MySQL Server from MySql Page (https://dev.mysql.com/downloads/mysql/)

#### Step 1: Install MySqlServer 
Select one of the following MySQL Installer package options: (https://dev.mysql.com/doc/refman/8.0/en/mysql-installer.html)

- Web: Contains MySQL Installer and configuration files only. The web package downloads only the MySQL products you select to install, but it requires an internet connection for each download. The size of this file is approximately 2 MB; the name of the file has the form mysql-installer-community-web-VERSION.N.msi where VERSION is the MySQL server version number such as 8.0 and N is the package number, which begins at 0.

- Full or Current Bundle: Bundles all of the MySQL products for Windows (including the MySQL server). The file size is over 300 MB, and the name has the form mysql-installer-community-VERSION.N.msi where VERSION is the MySQL Server version number such as 8.0 and N is the package number, which begins at 0.

#### Step 2: Configuration
- For development purposes, follow the wizzard. When ask for user, type next values:
Username: root
Password: root
- Execute scripts for database and tables creation (BD/scripts.sql)

# Installation Rest Services

#### Step 1: Download sources
Download sources code from this repository (carRental)

#### Step 2: Update maven
Update maven repositories from POM.xml

#### Step 3: Configuration
- Go to src/main/resources/application.properties
- Modified (if it is necesary) values:
    - spring.datasource.url=jdbc:mysql://localhost:3306/db_uter?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    - spring.datasource.username=root
    - spring.datasource.password=root 
    - server.port = 9080 

#### Step 4: Run the application
Run the application as Java Application

#### Rest Services Definitions
- [POST] /api/drivers/ - Create driver
- [GET] /api/drivers/ - Get all drivers
- [GET] /api/drivers/{idDriver} - Get an specific driver by id
- [PUT] /api/drivers/ - Update a driver
- [DELETE] /api/drivers/{idDriver} - Delete an specific driver by id

- [POST] /api/vehicles/ - Create vehicle
- [GET] /api/vehicles/ - Get all vehicles
- [GET] /api/vehicles/{idVehicle} - Get an specific vehicle by id
- [PUT] /api/vehicles/ - Update a vehicle
- [DELETE] /api/vehicles/{idVehicle} Delete an specific vehicle by id

- [POST] /api/trips/ - Create trip
- [GET] /api/trips/ - Get all trips

- [GET] /api/utils/drivers/{date}/{license} - Get all drivers available in a specific date and license type
- [GET] /api/utils/vehicles/{date} - Get all vehicles available in a specific date

# Installation Web Component

### Prerequisites
Before you begin, make sure your development environment includes Node.js® and an npm package manager

#### Node.js
Angular requires Node.js version 10.9.0 or later.
To check your version, run node -v in a terminal/console window.
To get Node.js, go to nodejs.org.

#### npm package manager
Angular, the Angular CLI, and Angular apps depend on features and functionality provided by libraries that are available as npm packages. To download and install npm packages, you must have an npm package manager.

This setup guide uses the npm client command line interface, which is installed with Node.js by default.

To check that you have the npm client installed, run npm -v in a terminal/console window.

#### Step 1: Install the Angular CLI
You use the Angular CLI to create projects, generate application and library code, and perform a variety of ongoing development tasks such as testing, bundling, and deployment.

Install the Angular CLI globally.

To install the CLI using npm, open a terminal/console window and enter the following command:

```sh
$ npm install -g @angular/cli
$ npm install
```

#### Step 2: Configuration
Go to enviroments folder, and change values of uri and port, if it is necesary.
For development purposes, these are the default values:
- uri: 'localhost'
- port: 9080

#### Step 3: Run the application..
The Angular CLI includes a server, so that you can easily build and serve your app locally.

Go to the workspace folder (carRentalWeb).

Launch the server by using the CLI command ng serve, with the --open option.

```sh
$ cd carRentalWeb
$ ng serve --open
```

