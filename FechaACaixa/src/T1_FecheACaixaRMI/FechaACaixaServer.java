package T1_FecheACaixaRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class FechaACaixaServer {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("Windows".equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
		}
		try {
			Naming.rebind("Fecha", new FecheACaixaImpl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean opt = true;
		while (opt) {
			int result = JOptionPane.showConfirmDialog(null, "Servidor rodando. Deseja encerrar?",
					"Server", JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				System.exit(0);
			} else {
				opt = true;
			}
		}
	}
}
