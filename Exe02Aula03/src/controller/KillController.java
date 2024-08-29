package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super();
	}
	private String os() {
		return System.getProperty("os.name");
	}
	public void listaProcessos() {
		String sistemaOperacional = os();
		String comando = "";
		
		if(sistemaOperacional.contains("Windows")) {
			comando = "TASKLIST /FO TABLE";
		}else if(sistemaOperacional.contains("Linux")){
			comando = "ps -ef";
		}
		String[] comandoArr = comando.split(" ");
		try {
			Process processo = Runtime.getRuntime().exec(comandoArr);
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void mataPid(String pid) {
		String sistemaOperacional = os();
		String comando = "";
		
		if(sistemaOperacional.contains("Windows")) {
			comando = "TASKKILL /PID "+ pid;
		}else if(sistemaOperacional.contains("Linux")){
			comando = "kill -9 "+ pid;
		}
		String[] comandoArr = comando.split(" ");
		try {
			Runtime.getRuntime().exec(comandoArr);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
		
	public void mataNome(String nome) {
		String sistemaOperacional = os();
		String comando = "";
		
		if(sistemaOperacional.contains("Windows")) {
			comando = "TASKKILL /IM "+ nome;
		}else if(sistemaOperacional.contains("Linux")){
			comando = "pkill -f "+ nome;
		}
		String[] comandoArr = comando.split(" ");
		try {
			Runtime.getRuntime().exec(comandoArr);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
