package controller;

import java.util.Random;
import java.util.Scanner;

public class ExerciciosController {
	public ExerciciosController() {
		super();
	}
	
	public void exe01() {
		int num[] = new int[10000];
		double tempInicial = System.nanoTime();
		for(int i = 0; i < num.length; i++) {
			num[i] = 0;
		}
		double tempFinal = System.nanoTime();
		double tempTotal = tempFinal - tempInicial;
		tempTotal = tempTotal / Math.pow(10, 9);
		System.out.println("Tempo Vetor ==> "+tempTotal+"s");
	}
	public void exe02(String frase) {
		int i = 0;
		String[] vetorPalavra = frase.split(";");
		for(String palavra : vetorPalavra) {
			System.out.print(palavra +" ");
			i++;
		}
		System.out.println();
		System.out.print("Quantidade de partes do texto: "+ i);
	}
	public int TamanhoVetor(){
		Scanner teclado = new Scanner(System.in);
		int num = 0, i = 0;
		while(i == 0){
			System.out.println("Digite o tamanho do vetor (máximo 100): ");
			num = teclado.nextInt();
			if(num <= 100 && num > 0) {
				i = 1;
			}else {
				System.out.println("Digite um valor válido!");
			}
		}
		return num;
	}
	public int[] carregarVetor(int [] vt) {
		Random teclado = new Random();
		for(int i = 0; i < vt.length; i++){
			System.out.print("Insira o valor do "+i+ "ºvetor");
			vt[i] = teclado.nextInt(10001);
		}
		return vt;
	}
	public void operacaoVetor(int[] vt) {
		for(int i : vt){
			if (i % 2 != 0) {
                System.out.println(i + " é ímpar.");
            } else if (i % 10 == 0) {
                System.out.println(i + " é par e múltiplo de 10.");
            }
		}
	}
}
