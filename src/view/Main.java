package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController KillControl = new KillController();
		
		String op = JOptionPane.showInputDialog(null, "Digite a opção:\n"
				+ "1 - Lista Processos\n"
				+ "2 - Matar por PID\n"
				+ "3 - Matar por nome");
		
		if (op.equals("1")) {
			KillControl.listaProcessos();
		}
		
		if (op.equals("2")) {
			String pid = JOptionPane.showInputDialog(null, "Digite o PID");
			KillControl.mataPid(pid);
		}
		
		if (op.equals("3")) {
			String nome = JOptionPane.showInputDialog(null, "Digite o Nome");
			KillControl.matalNome(nome);
		}

	}

}
