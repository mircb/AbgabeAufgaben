import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by stbormir on 20.03.2017.
 */
public class Server {

    public static void main(String[] args) {
        try {


            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);

            QuadratImpl h = new QuadratImpl();
            UnicastRemoteObject.unexportObject(h,true);

            Quadrat h_stub = (Quadrat) UnicastRemoteObject.exportObject(h,4242);

            registry.bind("test", h_stub);

            System.out.println("Server ready");

        } catch (Exception e) {
            System.err.println("Error on server :" + e);
            e.printStackTrace();
        }


    }
}