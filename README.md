## Sanitizer ##

Annotate member variables for sanitation

```java
public class User {
	@ConcurrentSpace
	private String name;
}
```

Instantiate

```java
Sanitizer sanitizer = new Sanitizer(object);
```

Sanitize

```java
sanitizer.sanitize();
```

## Concurrent Space ##

Replaces all concurrent spaces with single space

```java
@ConcurrentSpace
```

Example:

```java
User user = new User("John   Doe");
new Sanitizer(user).sanitize();
System.out.println(user.getName());
```

Output

```
John Doe
```

Data types supported
- String

## Lowercase ##

Lowercase all characters

```java
@Lowercase
```

Data types supported
- String

## Remove ##

Removes all instances of given string

```java
@Remove(toRemove = "-")
```

Required
- toRemove - [String]

Data types supported
- String

## Trim ##

Remove leading and trailing spaces

```java
@Trim
```

Data types supported
- String

## Uppercase ##

Uppercase all characters

```java
@Uppercase
```

Data types supported
- String

