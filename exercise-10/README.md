# Exercise 10 - B2C Accelerator Installation
## Expected Duration - 60 Minutes

Create your own version of the B2C Accelerator and initialise with sample data

## Recipe based installation - and using modulegen

1. Navigate to the directory `<your directory>/installer`
2. Install the B2C SAP Commerce recipe `./install.sh -r b2c_acc`
3. This has now populated your `localextensions.xml`
4. Navigate to the directory `<your directory>/hybris/bin/platform`
5. Run `ant modulegen`
6. Choose `accelerator` as template
7. Provide a name, e.g. `eetraining`
8. Provide a package name , e.g. `org.eetraining`
9. This will have created a series of series of new extensions within your `custom` directory
10. Edit your `localextensions.xml` file, replace names of template extensions with the names of your 7 newly created extensions, e.g. `yacceleratorstorefront` to `eetrainingstorefront` (Remove any other yaccelerator* extensions)
11. Re-install the B2C Accelerator Addons
```
ant reinstall_addons -Dtarget.storefront=eetrainingstorefront
```
12. Edit `<your directory>/hybris/config/local.properties` and add the following:

```
website.electronics.http=http://electronics.local:9001/eetrainingstorefront
website.electronics.https=https://electronics.local:9002/eetrainingstorefront
website.apparel-uk.http=http://apparel-uk.local:9001/eetrainingstorefront
website.apparel-uk.https=https://apparel-uk.local:9002/eetrainingstorefront
website.apparel-de.http=http://apparel-de.local:9001/eetrainingstorefront
website.apparel-de.https=https://apparel-de.local:9002/eetrainingstorefront
```

13.  Navigate to `<your directory>/hybris/bin/platform`
14.  Run `ant clean all`
15.  Start the hybris server
16.  Go to HAC and execute an initialise
17.  Optionally edit your local `hosts` file - and add

```
127.0.0.1   localhost electronics.local apparel-uk.local apparel-de.local
``` 
18. Test the sites by visiting :

```
http://electronics.local:9001/trainingstorefront/
http://apparel-uk.local:9001/trainingstorefront/
http://apparel-de.local:9001/trainingstorefront/
```
