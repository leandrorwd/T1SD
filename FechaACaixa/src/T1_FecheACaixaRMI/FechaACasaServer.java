package T1_FecheACaixaRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class FechaACasaServer {
	public static void main(String[] args) {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry ready.");
		} catch (RemoteException e) {
			System.out.println("RMI registry already running.");
		}
		try {
			Naming.rebind("Fecha", new FecheACaixaImpl());
			System.out.println("FechaACaixaServer is ready.");
		} catch (Exception e) {
			System.out.println("FechaACaixaServer failed:");
			e.printStackTrace();
		}
	}
}
