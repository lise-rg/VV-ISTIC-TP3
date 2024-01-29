# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

`JUnitTestContainsTooManyAsserts`, the rule that we choosed corresponds to the Assertion Roulette seen in class.

We used the following pmd check command : `pmd check -f html -R category/java/bestpractices.xml/JUnitTestContainsTooManyAsserts -d "commons-math" -r "tp3pmd.html"`

We selected an example of TooManyAsserts in the file : `commons-math\commons-math-legacy\src\test\java\org\apache\commons\math4\legacy\ode\nonstiff\GillIntegratorTest.java` line 101 :

``` java
      @Test
  public void testSmallStep()
        throws DimensionMismatchException, NumberIsTooSmallException,
            MaxCountExceededException, NoBracketingException {

        TestProblem1 pb = new TestProblem1();
        double step = (pb.getFinalTime() - pb.getInitialTime()) * 0.001;
    
        FirstOrderIntegrator integ = new GillIntegrator(step);
        TestProblemHandler handler = new TestProblemHandler(pb, integ);
        integ.addStepHandler(handler);
        integ.integrate(pb, pb.getInitialTime(), pb.getInitialState(),
                        pb.getFinalTime(), new double[pb.getDimension()]);
    
        Assert.assertTrue(handler.getLastError() < 2.0e-13);
        Assert.assertTrue(handler.getMaximalValueError() < 4.0e-12);
        Assert.assertEquals(0, handler.getMaximalTimeError(), 1.0e-12);
        Assert.assertEquals("Gill", integ.getName());
  }
    }
```
We can see that that there is more that 1 assert in the same test. We can correct it with making 1 test per function tested.
