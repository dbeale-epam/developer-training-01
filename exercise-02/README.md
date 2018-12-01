# Exercise 02 - Data Modeling
## Expected Duration - 60 Minutes

For this exercise we are going to create the data model for our ficticous company.
OfficeCo is a company that rents our meeting rooms, each meeting room can be rented out for a couple of hours or for an entire day.
We will extend **Product** to hold some extra attributes, we will also extend **ProductVariant** for the different rental durations. The Office location will be create as a new entity, with a one-to-many relationship to the product, i.e. one office can have many meeting rooms.

![](https://raw.githubusercontent.com/dbeale-epam/developer-training-01/tree/master/exercise-02/OfficeCoERD.png?raw=true)


We will create a new extension, initally using **extegen** and then using an **installer recipe**.
1. Create a local directory for your Commerce installation
2. Copy the Commerce installtion zip file to this location
3. Unzip this file
4. Navigate to  
5. `
6. <your directory>
7. `