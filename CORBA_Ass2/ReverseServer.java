import ReverseModule.Reverse;
import ReverseModule.ReverseHelper;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class ReverseServer {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            ReverseImpl reverseImpl = new ReverseImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(reverseImpl);
            Reverse href = ReverseHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Reverse";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("Reverse Server is ready and waiting...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
