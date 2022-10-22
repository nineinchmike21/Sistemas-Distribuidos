package sd.rmi;

import java.util.List;

public interface Reservas extends java.rmi.Remote{

    public String Reserva(String nome) throws java.rmi.RemoteException;
    public List<String> listanomes(String s) throws java.rmi.RemoteException;
    public Integer num_reservas(int n) throws java.rmi.RemoteException;
}
