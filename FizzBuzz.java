public class FizzBuzz {
  public String getResult(int i) {
    String result;
      if ( i < 1) {
        result = "Error";
      } 
      else if (i % 15 == 0) {
        result = "FizzBuzz";
      } 
      else if (i % 3 == 0) {
        result = "Fizz";
      } 
      else if (i % 5 == 0) {
        result = "Buzz";
      } 
      else {
        result = String.valueOf(i);
      }
    return result;
  }
}
