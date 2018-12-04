# Exercise 05 - Service Layer
## Expected Duration - 60 Minutes

We will create DAOs, Service and Facade to access our data
There are two requirements - Find all Offices - which return a list of Offices and FindOfficeByCode - which will return once specific Office

## DAO

1. Create a new folder `dao` within `src\officeco`
2. Create a new DAO interface OfficeDAO source file
3. Create a new DAO implementation source file DefaultOfficeDAO
4. Compare against [OfficeDAO.java](OfficeDAO.java) and  [DefaultOfficeDAO.java](DefaultOfficeDAO.java)
   
## Service
1.  Create a new Service interface OfficeService.java, it wil be implementing find methods via DAO
2.  Create a new Service implementation DefaultOfficeService.java 
3.  Compare against [OfficeService.java](OfficeService.java) and  [DefaultOfficeService.java](DefaultOfficeService.java)
   
## Spring Configuration