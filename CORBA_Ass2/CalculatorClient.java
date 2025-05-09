import CalculatorApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class CalculatorClient {
  public static void main(String[] args) {
    try {
      ORB orb = ORB.init(args, null);

      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      Calculator calcRef = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));

      float a = 10, b = 2;
      String str1 = "Hello, ", str2 = "CORBA!";

      System.out.println("Addition: " + calcRef.add(a, b));
      System.out.println("Subtraction: " + calcRef.subtract(a, b));
      System.out.println("Multiplication: " + calcRef.multiply(a, b));
      System.out.println("Division: " + calcRef.divide(a, b));
      System.out.println("Concatenation: " + calcRef.concat(str1, str2)); // New line

    } catch (Exception e) {
      System.out.println("ERROR: " + e);
      e.printStackTrace(System.out);
    }
  }
}
