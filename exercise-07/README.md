# Exercise 07 - Write Facade
## Expected Duration - 60 Minutes

Create a Facade that will implement public methods for getting all Offices and a single Office by code

1. Create a new DTO class with Spring XML for the required fields, as below

```xml
<bean class="org.officeco.data.office">
	<property name="code" type="String"/>
</bean>
```

2. Create a new folder within `src` called facades
3. Create a interface for your facade
4. Provide two public methods as for getting one office and getting all offices
5. Create a new implementation class for your facade
6. Impement the two methods
7. You can choose to directly set the values in the DTO or use a converter
8. Below is an example facade, this is using converters

```java
Public class DefaultProductFacade implements ProductFacade
{
   private ProductService productService;
   private PriceService priceService;
   private Converter<ProductModel, ProductData> productConverter;
   private Converter<PriceInformation, PriceData> priceInformationConverter;

   public ProductData getProduct(final String productCode)
   {
      final ProductModel product = productService.getProductForCode(code);
      final List<PriceInformation> prices = priceService.getPriceInformationsForProduct(product);
      final ProductData prodData = productConverter.convert(product);
      if (!prices.isEmpty())
      {
         final PriceInformation price = prices.iterator().next();
         final PriceData priceData = priceInformationConverter.convert(price);
         prodData.setPrice(priceData);
      }
      return prodData;
   }

   public void setProductService(final ProductService productService)
   {
      this.productService = productService;
   }

   public void setPriceService(final PriceService priceService)
   {
      this.priceService = priceService;
   }

   public void setProductConverter(final Converter<ProductModel, ProductData> converter)
   {
      this.productConverter = converter;
   }

   public void setPriceInformationConverter(
      final Converter<PriceInformation, PriceData> priceInformationConverter)
   {
      this.priceInformationConverter = priceInformationConverter;
   }
}
```