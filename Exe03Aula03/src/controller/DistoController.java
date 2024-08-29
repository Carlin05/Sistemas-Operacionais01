package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistoController {
	public DistoController() {
		super();
	}
	private String so(){
		return System.getProperty("os.name");
	}
	public void exibeDistro() {
		String sistemaOperacional = so();
		String comando = "";
		if(sistemaOperacional.contains("Windows")) {
			System.out.println("Sistema nao compativel");
			System.exit(0);
		}else if(sistemaOperacional.contains("Linux")) {
			comando = "cat /etc/os-realese";
		}
		String[] comandoArr = comando.split("");
		try {
			Process processo = Runtime.getRuntime().exec(comandoArr);
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha;
			while((linha = buffer.readLine()) != null) {
				if(linha.contains("NAME=") || linha.contains("VERSION=")) {
					System.out.println(linha.trim());
				}
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}