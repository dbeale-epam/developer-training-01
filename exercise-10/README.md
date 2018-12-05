# Exercise 10 - B2C Accelerator Installation
## Expected Duration - 60 Minutes

Create your own instance of a B2C Accelerator and initialise with sample data

## Recipe based instllation

1. Navigate to the directory `<your directory>/installer`
2. Install the B2C SAP Commerce recipe `./install.sh -r b2c_acc`
3. This has now populated your `localextensions.xml`
4. Navigate to the directory `<your directory>/hybris/bin/platform`
5. Run `ant modulegen`
6. Choose `accelerator` as template
7. Provide a name, e.g. `eetraining`
8. Provide a package name , e.g. `org.eetraining`
9. This will have created a series of series of new extensions within your `custom` directory
10. Edit your `localextensions.xml` file, replace names of template extensions with the names of your 7 newly created extensions, e.g. `yacceleratorstorefront` to `eetrainingstorefront`
11. Navigate to `<your directory>/hybris/bin/platform`
12. Run `ant clean all`
13. Start the hybris server
14. Go to HAC and execute an initialise

