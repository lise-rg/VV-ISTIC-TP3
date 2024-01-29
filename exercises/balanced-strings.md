# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy *Base Choice Coverage*. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

For this exercise, we chose to understand the subject like, a string can only contain symbols `{}, [], ()` or the empty string `""`. So `"(a"` is not accepted.

You have the methode isBalanced ![HERE](https://github.com/lise-rg/VV-ISTIC-TP3/blob/main/code/tp3-balanced-strings/src/main/java/fr/istic/vv/StringUtils.java)

1 .
We partitioned the possible inputs for our program into the following blocks :

| Characteristics  | Blocks  | Blocks |
| :----------------------- |:------------------------:| --:|
| empty  |   Balanced         |
| null  | NullPointerException
| string is "()" or "[]" or "{}" | YES ? -> Balanced | NO ? -> Unbalanced
| string has a balanced string into another  | YES ? -> Balanced | NO ? -> Unbalanced
|equal number of opening and closing symbols of each kind |   YES ? -> Undecided | NO ? -> Unbalanced
| string is a sequence of balanced strings| YES ? -> Balanced | NO ? -> Unbalanced

So we made our test to have all our partitioning covered. 

2 .
Our coverage was at 100% after the creation of our tests.

3 . 
We have three conditions with only "&&" and as we know our coverage is 100% the conditions have necessarily been covered.
We also have one condition with "||" and we have already added all necessary tests to cover all cases.

4 .
You can see the result of our pit test with the command: `mvn test-compile org.pitest:pitest-maven:mutationCoverage`
 ![HERE](https://github.com/lise-rg/VV-ISTIC-TP3/blob/main/exercises/pit%20report%20balanced%20string.png)
