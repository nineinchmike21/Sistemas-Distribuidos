package sd.rmi;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ReservasImpl extends UnicastRemoteObject implements Reservas, java.io.Serializable {

    public ReservasImpl() throws java.rmi.RemoteException{
        super();
    }

    public List<String> listanomes(String s){

    }
}
