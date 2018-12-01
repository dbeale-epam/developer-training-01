# Exercise 01 - Installation, Confuguration & Extensions
## Expected Duration - 60 Minutes

For this exercise we are going to install Hybris Commerce on your local laptop. We will be carrying out an inital build.  
We will create a new extension, initally using **extegen** and then using an **installer recipe**.

## Installation
1. Create a local directory for your Commerce installation
2. Copy the Commerce installtion zip file to this location
3. Unzip this file
4. Navigate to  `<your directory>\hybris\bin\platform`
5. Set environment variables by runnining either `. ./setantenv.sh` or `setantenv.bat`
6. Review the files, specifically `localextensions.xml`  

## Start

1. Let's now use a Recipe to create an empty installation
2. Navigate to `<your directory>`hyris\installer`
3. Browse through some of the recipes in the `recipes` directory
4. Initially, we will just install the base platform recipe, run `./install.sh -r platform_only` or `install.bat -r platform_only`
5. Review the files, specifically `localextensions.xml`  

## Initalisation

1. Now we will start the server, navigate to  `<your directory>\hybris\bin\platform`
2. Run `./hybrisserver.sh start` or `hybrisserver.bat start`
3. This will take several minutes to start
4. On your browser, go to the Hybris Admin Console, `http://localhost:9001'
5. Login in as `admin\nimda`  
6. Choose the `initialize` option, for a base platform installation this should take about 5 minutes
7. Once complete, view the intalled extensions in the console

## New Extension

We now want to create a new extenstion

1. Run `ant extegent`, choose `yempty` as template, name `OfficeCo`, package `org.officeco`
2. Browse the folders, you will notice a new `custom` folder created, with `OfficeCo`
3. We now have to add our new extension to `config/localextensions.xml`
4. Add the following block to the file

```xml
 <!-- Your new extension -->
 <extension dir="../custom/officeco"/>  
```

6. Now run `ant clean all` to  build with the new extension, which will also attempt restart a running hybris server
7.  If hybris isn't running -  `./hybrisserver.sh start` or `hybrisserver.bat start`
8.  Now, within HAC, request an Update, so that the server is aware of the new extension
9.  Verify that the extension now exists in HAC's list of extensions

## Eclipse Setup

1. Download and install the latest version of Eclipse from [here](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers)
2. Click on this [link](https://marketplace.eclipse.org/content/sap-hybris-commerce-development-tools-eclipse) and drag the "Install" button onto your Eclipse IDE
3. Choose File->Import-> [y] hybris -> Import Platform
4. Point to the location of your **bin/platform** folder, ensure 'Tomcat start/stop multi-thread' option is disabled
   
