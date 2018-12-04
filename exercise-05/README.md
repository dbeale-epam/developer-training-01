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
1. Our DAO has used annotation to tell Spring to define a bean   - `@Component(value = "OfficeDAO")` 
2. A modification to `resources\officeco-spring.xml` to scan for this annotation, after inital `beans` tag
```
<context:component-scan base-package="org.officeco"/>
```
3. Register the Office Service, and configure to use of DefaultOfficeDAO
```xml
<alias name = "defaultOfficeService" alias = "officeService" />
<bean id = "defaultOfficeService" class = "org.officeco.service.DefaultOfficeService" >
<property name = "officeDAO" ref = "officeDAO" />
</bean>
```