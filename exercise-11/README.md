# Exercise 11 - B2C Accelerator Customisation
## Expected Duration - 90 Minutes

The business has a new requirement, every product now has store have an attribute Country of Origin set and displayed on the product detail page.

## Data Model

1. Edit the `trainingcore-items.xml` file
2. Add a new enum `CountryOfOrigin` provide several values, e.g. UK,France,China
3. Set a default value

```
<defaultvalue>em().getEnumerationValue("CountryOfOrigin","UK")</defaultvalue>
```
4. Extend the `ApparelProduct` type and add an attribute of type CountryOfOrigin
5. Run an Update on the syste
   

## Search (optional)

1. Go to the Administration Backoffice, `System/Search and Navigation`
2. Within `Facet Search Configuration` select  `appareluk-index`
3. Edit the `apparel-ukProductType' and your new field as a new indexed property, setting it as a facet

## Service Layer

1. We need to retrieve this new property
2. Extend ProductFacade
3. Extend DTO
4. Extend ProductService


## Front-End  (not using an Addon)
1. Modify `ProductPageController.java`
2. Modify the appropriate jsp view - or tag `productDetailsTab.tag`





