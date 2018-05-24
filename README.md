# Running JUnit test using the console

After removing Eclipse from my system, then realizing that writing `JUnit` tests will be on the exam
this year I figured that it would be faster just running the tests like I run normal `.java` files.
After counsel from the elders telling me that running `JUnit` tests without an IDE was stupid, I
figured that I had to run the tests without an IDE. After dealing with some `export PATH` problems, I
finally got it working fine.

## Setup

The first step is heading over to the [junit](https://github.com/junit-team/junit4/wiki/Download-and-Install)
git repository, and downloading `junit.jar` and `hamcrest-core.jar`.
There are two ways of using these `.jar` files. 
- The `quick setup-slow run` way. This way use the `no-global-path` folder as root.
- The `slow setup-fast run` way. This way use the `global-path` folder as root.

## Writing tests

The skill of writing JUnit tests is not for me to teach, but for this example, I will show a basic
FizzBuzz program with a few tests.

> The full implementation of both files are in the directory of this repository.

`Java class` that returns the result of the FizzBuzz word game using the method `getResult()`.

```java
// FizzBuzz.java

public class FizzBuzz {
  public String getResult(int i) {
    switch(i % 15) {
      // logic ...
    }
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
  public void test_getResult_returnBuzz() {
    String result = new FizzBuzz().getResult(15);
    assertEquals("FizzBuzz", result):
  }

  // more tests
}
```


## Easy Setup

When choosing the easy path all you need to do is adding the two `.jar` files to the root of your
project, like done in `no-global-path`. Then you can write your test, and head down to the "Running
easy tests" section.

## Running easy tests

After writing all the test cases, we want to check we are ready to compile. We cant compile like
normal using `javac FizzBuzzTest.java`. We need to compile while referencing the `.jar` files. So to
compile the tests, we will make sure to include the classpath.

```zsh
javac -cp .:junit-4.12.jar FizzbuzzTest.java
```

This will tell the java compiler to run using the path `.:junit-4.12.jar`. If everything works, you
should get no input, but find two fresh `.class` files in your current directory. Then you should be
able to run the tests. When running the test, we need to set the classpath to both `JUnit` and additionally, we need to set the classpath to `hamcrest-core`. Then lastly we need to tell java to use the `JUnitCore runner` on the FizzBuzzTest file.

```zsh
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore FizzbuzzTest
```

JUnit should then output the test results. `OK` for a good test or `FAILURE` for a wrong test.
Each `period( . )` represent one test.

```zsh
JUnit version 4.12
.....
Time: 0.003

OK (5 tests)
```

## Advanced Setup

When choosing the advanced you need to do some stuff before you are ready to go, to the end result
is a lot better, and tests can be run with ease. Here the setup may change due to differences in
operation system/shell/setup and so forth. The gist of it is that two things must be done.
- A global path needs to point to a location where the `.jar` files are located.
- A shell script needs to be written to make life easy.

So in your stock shell config file you need to export the path of `junit`
```zsh
export CLASSPATH=.:$CLASSPATH:~/JUnit/junit-4.12.jar:~/JUnit/hamcrest-core-1.3.jar
```
Then as seen in the path files, the `CLASSPATH` point to a folder in the root directory of the 
system called JUnit where both of the `.jar` files are located. 

## Running tests using script

Now you should be able to
compile and run your tests with.
```shell
javac FizzBuzz.java FizzBuzzTest.java
java org.junit.runner.JUnitCore FizzBuzzTest
```
But this only runs one file and you will go mad if you have a big project with lots of tests. So a 
script is due. Currently I have this script as a shortcut in my `zshrc.sh` config file.
```bash
javat() {
  echo Remove old files...
  rm *.class || echo No class files to remove in root
  rm tests/*.class || echo No class files to remove in tests
  printf "\n"
  echo Compiling source code...
  f=$(javac $(find . -name '*.java') -d $PWD)
  if [ $? != 0 ]]; then
    echo "Compiling of code failed..."
  else
    echo Compiling of code success...
    printf "\n"
    for f in *Test*.class
    do
    printf "\n-------------------"
    echo Test: ${f%.*}
    java org.junit.runner.JUnitCore ${f%.*}
    done
    echo Cleaning up...
    rm *.class
  fi
}
```
To make it short, the script removes all old `.class` files, then tries to compile everything in the
project. If the compile is a success it runs each test file and outputs the result. Then it cleans
up by removing all the `.class` files.

All you need to do then is run `javat` in the root of your project. 
<p align="center">
<img src = "https://i.imgur.com/4SaPpNv.png">
</p>


