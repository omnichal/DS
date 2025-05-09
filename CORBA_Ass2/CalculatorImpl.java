import CalculatorApp.*;
import org.omg.CORBA.*;

public class CalculatorImpl extends CalculatorPOA {
  private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val;
  }

  public float add(float a, float b) {
    return a + b;
  }

  public float subtract(float a, float b) {
    return a - b;
  }

  public float multiply(float a, float b) {
    return a * b;
  }

  public float divide(float a, float b) {
    return b != 0 ? a / b : 0;
  }

  public String concat(String a, String b) {
    return a + b;
  }
}
