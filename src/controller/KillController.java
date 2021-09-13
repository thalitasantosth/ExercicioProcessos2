package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos() {
		String os = os();
		String cmd = "";
		if (os.contains("Windows")) {
			cmd = "TASKLIST /FO TABLE";
		}
		if (os.contains("Linux")) {
			cmd = "ps -ef";
		}
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader buffer = new BufferedReader (isr);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mataPid (String pid) {
		String os = os();
		String cmd = "";
		if (os.contains("Windows")) {
			cmd = "TASKKILL /PID "+pid;
		}
		if (os.contains("Linux")) {
			cmd = "kill -9 "+pid;
		}
		rodaProcesso(cmd);
	}
	
	public void matalNome (String nome) {
		String os = os();
		String cmd = "";
		if (os.contains("Windows")) {
			cmd = "TASKKILL /IM "+nome;
		}
		if (os.contains("Linux")) {
			cmd = "pkill -f "+nome;
		}
		rodaProcesso(cmd);
	}
	
	private void rodaProcesso(String proc) {
		try {
			Runtime.getRuntime().exec(proc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
