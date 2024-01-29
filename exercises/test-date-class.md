# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

1 . We partionned the possible inputs for our programm in the following blocks :

| Characteristics  | Blocks  |  | | |
| :----------------------- |:------------------------:| --:|--:|--:|
| Value of day 	|< 0	| 0    |  [1;MAX(month,year)] | > MAX(month,year)|
| Value of month  |< 0	| 0    | [1;12]|> 12
| Value of year | < 0 | 0    | leap year | valid common year

So we made our test to have all our partitioning covered. 

2 .
Our coverage was at 100% after creation of our tests.

3.
Regarding the conditions with only "&&", as we know our coverage is 100%, the conditions have necessarily been tested.
As for the "||" condition, it is a very simple one and we can see that all of the conditions are tested in our tests.

4 .

You can see the result of our pit test : 

![HERE](https://github.com/lise-rg/VV-ISTIC-TP3/blob/main/exercises/pir%20report%20date.png)
