# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1 . 
This is because the result of `3 * .4` is not realy equals to `1.2` because the programm makes an approximation due to floating-point representation.
To solve this, we can have a variable epsilon equals to 1e-n with n an Integer to have an epsilon of approximation. The test can be upgrade like this :
``` java
  double epsilon = 1e-10;
  assertTrue(Math.abs(3 * 0.4 - 1.2) < epsilon);
```

2 . 
assertEquals is used to check if two values are equal in terms of their content but it will not check their references.
assertSame is used to check if two references refer to the exact same object instance. So it compares the references, ensuring that both variables point to the same object in memory.


Now the tests :

CASE 1 when they do not produce the same result :

``` java
String str1 = new String("test");
String str2 = new String("test");

assertEquals(str1, str2); 
assertSame(str1, str2);   
```
-> The assertEquals will pass, because content is the same.
-> The assertSame will Fail, because this is 2 differents objects in memory.

CASE 2 when they produce the same result :

``` java
String str1 = new String("test");
String str2 = str1;

assertEquals(str1, str2);
assertSame(str1, str2);
```

-> The assertEquals & assertSame will pass, because content is the same and this is the same object reference.

3 .

`fail` is also usefull when a method have precondition, if preconditions are not met, the fail provides an usefull feedback. 
Here an example :

``` java

public class Calculator {
    public int calculateSquareRoot(int number) {
        if (number < 0) {
            fail("Invalid precondition : Cannot calculate square root of a negative number");
        }
        return (int) Math.sqrt(number);
    }
}

@Test
public void TestSquareRoot(){
    Calculator calculator = new Calculator();
    
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculateSquareRoot(-1));
    
    assertEquals("Invalid precondition : Cannot calculate square root of a negative number", exception.getMessage());
}
```

4 .
`assertThrows` captures the thrown exception (see in question 3).
With this, we can test that the code return the specific expected exeption (an IllegalArgumentException in the question 3), instead of testing that it return any exception.
That provides a more powerful and flexible way to handle expected exceptions in JUnit 5.
