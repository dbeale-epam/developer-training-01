# Exercise 02 - Data Modeling
## Expected Duration - 60 Minutes

For this exercise we are going to create the data model for our ficticous company.
OfficeCo rents out meeting rooms, each meeting room can be rented out for a couple of hours or for an entire day. There are multiple physical offices, which can have multiple meeting rooms. Each office location is also a member of one Office group.

We will extend **Product** to hold some extra attributes, we will also extend **ProductVariant** for the different rental durations. The Office location will be create as a new entity, with a one-to-many relationship to the product, i.e. one office can have many meeting rooms.

![Data Model](OfficeCoERD.png?raw=true)


## Item Types

1. Edit the items.xml file in your new extension, at  `<your directory>\hybris\bin\custom\offico\resources\officeco-items.xml`
2. Add an `itemtypes` section  `<itemtypes><itemtypes/>`
3. Within this section add :
    * Extend Product
    * Create OfficeBooking, which extends VariantProduct
    * Create new item type Office
    * Create new item type OfficeGroup

## Enums

1. Add an `enums` section  `<itemtypes><itemtypes/>` at the top of the file, first entry after `<items`
2. Within this section add :
    * Create new enum for BookingDuration, values `ONE_HOUR,TWO_HOURS,HALF_DAY,FULL_DAY`
    * Create new enum for RoomType, values `GENERIC,CONFERENCE,CLASSROOM`

## Relations

1. Add an `relations` section  `<relations><relations/>` , first entry after `<enums>`
2. Within this section add :
    * Create new relationship for Meeting Rooms 2 Office, (1 to Many) `
    * Create new relationship for Office to Office Group ( 1 to Many)

## Validation

1. Compare against [officeco-items.xml](officeco-items.xml)
2. Use the Eclipse Hybris Plugin to validate the items.xml

## Build and update

1. Run `ant all` 
2. Perform an `Update`
