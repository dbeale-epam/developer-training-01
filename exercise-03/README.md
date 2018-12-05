# Exercise 03 - Importing Data
## Expected Duration - 60 Minutes

Manually import data into one of the new item types, Office.

## Impex

1. Create a new impex file and populate with sample data for the Office item type  


```
INSERT_UPDATE Office;code[unique=true];name;address1;address2;town; postcode
;RG1;Reading Centre;13 London Street;Northern Park; Reading; RG54 43T
;LD1;London West;1 Blagrave Road;Lewisham; London; W1 4ZG
```

1. Using the impex loader within HAC, attempt to import and correct any errors
2. Using HAC, run a flex query to view the loaded data

