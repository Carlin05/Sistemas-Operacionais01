package view;
import java.util.Scanner;
import controller.ExerciciosController;
import javax.swing.JOptionPane;
public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ExerciciosController[] ex = new ExerciciosController[3];
		int opc = 0;
		for(int i = 0; i < ex.length; i++) {
			ex[i] = new ExerciciosController();
		}
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Exercicio 1 \n"
                    + "2 - Exercicio 2 \n"
                    + "3 - Exercicio 3 \n"
                    + "9 - Sair do programa"));
			switch(opc) {
				case 1:
					limparTela();
					ex[0].exe01();
				break;
				case 2:
					limparTela();
					System.out.print("Digite a frase: ");
					String text = teclado.nextLine();
					ex[1].exe02(text);
				break;
				case 3:
					limparTela();
					int tamanho = ex[2].TamanhoVetor();
					int vt[] = new int [tamanho];
					vt = ex[2].carregarVetor(vt);
					ex[2].operacaoVetor(vt);
				break;
			}
		}	
		
	}
	public static void limparTela() {
		for (int i = 0; i < 50; i++) {
            System.out.println();
        }
	}
}
