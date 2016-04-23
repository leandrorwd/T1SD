package T1_FecheACaixaRMI;

import java.rmi.Naming;

public class FechaACaixaClient {

	public static void main(String[] args) {
		
		try {
			FecheACaixaInterface fac = (FecheACaixaInterface)Naming.lookup("//localhost/Fecha");
			int pid1 = fac.registraJogador("J1");
			System.out.println("PID1: " + pid1);
			System.out.println();
			System.out.println();
			System.out.println();
			int pid2 = fac.registraJogador("J2");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
			
			
			
		
	}
	
}
