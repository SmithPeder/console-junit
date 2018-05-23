public class FizzBuzz {
  public String getResult(int i) {
    switch(i % 15) {
      case 0:                           return "FizzBuzz";
      case 3: case 6: case 9: case 12:  return "Fizz";
      case 5: case 10:                  return "Buzz"; 
      default:                          return String.valueOf(i);
    }
  }
}
