# Exercise 03 - Importing Data
## Expected Duration - 60 Minutes

First we will manually import data into one of the new item types, Office.
Then we will create files to initialise all of the data entities and ensure loaded as part of essential data

## Impex

1. Create a new impex file and populate with sample data for the Office item type  

```
INSERT_UPDATE Office;code[unique=true];name;address1;address2,town, postcode
;RG1;Reading Centre;13 London Street;Northern Park, Reading, RG54 43T
;LD1;London West;1 Blagrave Road;Lewisham, London, W1 4ZG
```

2. Using the impex loader within HAC, attempt to import and correct any errors
3. Using HAC, run a flex query to view the loaded data

## Essential & Peoject Data


