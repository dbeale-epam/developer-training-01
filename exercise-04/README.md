# Exercise 04 - Loading Essential & Project Data
## Expected Duration - 30 Minutes

We now want to populate our data model at initialise and update time

## Essential Data

1. Create a new file to be loaded at initialisation time - `essentialdata-offices.impex`
2. Populate with Offices data
3. Place this file in `<your directory>/hybris/bin/custom/officeco/resources/impex`
4. Re-build system and initialise - verify that the data was loaded

## Project Data

1. Crete a new fileto be loaded at update time - `projectdata-products.impex`
2. Add a macro section
```
#Macros / Replacement Parameter definitions
$productCatalog=officecoProductCatalog
$supercategories=supercategories(code, $catalogVersion)
$baseProduct=baseProduct(code,$catalogVersion)
$approved=approvalstatus(code)[default='approved']
$catalogVersion=catalogversion(catalog(id[default=$productCatalog]),version[default='Online'])[unique=true,default=$productCatalog:Online]
```
3. Add a section to create the catalog and catalog version

```
# Product catalog
INSERT_UPDATE Catalog;id[unique=true]
;$productCatalog
 
# Product cataog version
INSERT_UPDATE CatalogVersion;catalog(id)[unique=true];version[unique=true];active;languages(isoCode);readPrincipals(uid)
;$productCatalog;Online;true;en;employeegroup
```

4. Add a section to create Meeting Rooms and Room Bookings
```
# Insert Products (Meeting Rooms)
INSERT_UPDATE Product;code[unique=true];name;office(code);roomType(code);hasProjector(code);maxPeople;$supercategories;variantType(code);$catalogVersion;$approved
;0000075;Saturn Room;RG1;GENERIC;TRUE;10;;OfficeBooking
 
# Insert variants (Officebooking)
INSERT_UPDATE OfficeBooking;code[unique=true];roomDuration(code);baseProduct(code);$catalogVersion;$approved
;00000751;HALF_DAY;0000075;
```

5. Rebuild and carry out an update - verify that the data has been loaded
6. Now modify the Project Data file to include data for OfficeGroup
