## Sanitizer ##

Annotate member variables for sanitation

```java
public class User {
	@ConcurrentSpaceSanitation
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

## Concurrent Space Sanitation ##

Replaces all concurrent spaces with single space

```java
@ConcurrentSpaceSanitation
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

## Lowercase Sanitation ##

Lowercase all characters

```java
@LowercaseSanitation
```

Data types supported
- String

## Remove Sanitation ##

Removes all instances of given string

```java
@RemoveSanitation(toRemove = "-")
```

Required
- toRemove - [String]

Data types supported
- String

## Trim Sanitation ##

Remove leading and trailing spaces

```java
@TrimSanitation
```

Data types supported
- String

## Uppercase Sanitation ##

Uppercase all characters

```java
@UppercaseSanitation
```

Data types supported
- String

