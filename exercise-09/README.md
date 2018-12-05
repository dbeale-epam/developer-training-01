# Exercise 09 - Groovy Scripts
## Expected Duration - 15 Minutes

1. Experiment with Groovy Sctips within Admin Consile
2. Example 1 - Display any file on a server

```
new File('/etc/passwd').eachLine {
println it
}
```
3. Enter a command

```
println "ls -la".execute().text
```

4. Retrieve an item by PK

```
import de.hybris.platform.core.PK;
Long examplePK = ...;
object = modelService.get(new PK(examplePK));
print object.getPk();
print ", ";
println object.getName();
```
5. Print all properies of an object

```
result = spring.getBean("flexibleSearchService").search("select {pk} from {Language}")
// properties
result.properties.each { println "$it.key -> $it.value" }
```
