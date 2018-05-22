import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

  @Test
  public void test_getResult_returnWrongOnZero() {
    String result = new FizzBuzz().getResult(0);
    assertEquals("Error", result);
  }

  @Test
  public void test_getResult_returnOne() {
    String result = new FizzBuzz().getResult(1);
    assertEquals("1", result);
  }

  @Test
  public void test_getResult_returnFizz() {
    String result = new FizzBuzz().getResult(3);
    assertEquals("Fizz", result);
  }

  @Test
  public void test_getResult_returnBuzz() {
    String result = new FizzBuzz().getResult(5);
    assertEquals("Buzz", result);
  }

  @Test
  public void test_getResult_returnFizzBuzz() {
    String result = new FizzBuzz().getResult(15);
    assertEquals("FizzBuzz", result);
  }
}
