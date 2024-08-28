package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	private String os() {
		return System.getProperty("os.name");
	}
	public void ip() {
		String sistemaOperacional = os();
		String comando = "";
		
		if(sistemaOperacional.contains("Windows")) {
			comando = "ipconfig";
		}else if(sistemaOperacional.contains("Linux")){
			comando = "ifconfig";
		}
		String[] comandoArr = comando.split(" ");
		try {
			Process processo = Runtime.getRuntime().exec(comandoArr);
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			while(linha != null) {
				if(linha.contains("IPv4")) {
					System.out.println(linha.trim());
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void ping() {
		String sistemaOperacional = os();
		String comando = "";
		
		if(sistemaOperacional.contains("Windows")) {
			comando = "ping -4 -n 10 www.google.com.br";
		}else if(sistemaOperacional.contains("Linux")){
			comando = "ping -4 -c 10 www.google.com.br";
		}
		String[] comandoArr = comando.split(" ");
		try {
			Process processo = Runtime.getRuntime().exec(comandoArr);
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			while(linha != null) {
				if(linha.contains("Média") || linha.contains("avg")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}  
