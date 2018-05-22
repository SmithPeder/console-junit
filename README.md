# Running JUnit test using the console

After removing Eclipse from my system, then realizing that writing `JUnit` tests will be on the exam
this year i figured that if would be faster just running the tests like i run normal `.java` files.
After counsel from the elders telling me that running `JUnit` tests without and IDE was stupid, i
figured that i had to run the tests without an IDE. After dealing with some `export PATH` problems i
finally got it working fine.

## Setup

First step i heading over to the [junit](https://github.com/junit-team/junit4/wiki/Download-and-Install)
git repository, and downloading `junit.jar` and `hamcrest-core.jar`. For this example both these
`.jar` files is positioned in the root directory of the project. That's it, the setup is complete.

## Writing tests

The skill of writing JUnit tests is not for me to teach, but for this example I'll show a basic 
FizzBuzz program with a few tests. 

> The full implementation of both files are in the directory of this repository.

`Java class` that returns the result of the FizzBuzz word game using the method `getResult()`.
```java
// FizzBuzz.java

public class FizzBuzz {
  public String getResult(int i) {
    String result;
    // ...
    // logic
    // ...
    return result
  }
}
```

`JUnit test class` that implement different test methods for testing the `getResult()` method.
```java
// FizzBuzzTest.java

import org.junit.Test;
import static org.junit.Assert.assertEquls;

public class FizzBuzzTest {

  @Test
  public void test_getResult_returnOne() {
    String result = new FizzBuzz().getResult(1);
    assertEquals("Error", result):
  }

  @Test
  public void test_getResult_returnBuzz() {
    String result = new FizzBuzz().getResult(15);
    assertEquals("Error", result):
  }

  // ...
  // more tests
}
```
## Running tests

After writing all the testcases we want to check we're ready to compile. We cant just compile like
normal using `javac FizzBuzzTest.java`. We need to compile while referencing the `.jar` files. So to
compile the tests we'll make sure to include the classpath.
```zsh
javac -cp .:junit-4.12.jar FizzbuzzTest.java
```
This will tell the java compiler to run using the `-cp .:junit-4.12.jar`. If everything works you
should get no input, but find the two `.class` files in your current directory. Then you should be
able to run the tests. Also here we need to set the classpath to both `JUnit` and additionally we 
need to set the classpath to `hamcrest-core`. Then lastly we need to tell java to use the 
`JUnit runner`. 
```zsh
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore FizzbuzzTest
```

JUnit should then output if the tests where `OK` or `FAILURE`. Each `period( . )` represnent one
test.
```zsh
JUnit version 4.12
.....
Time: 0.003

OK (5 tests)
```
