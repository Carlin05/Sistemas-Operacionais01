package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	public static void main(String[]Args) {
		KillController killController = new KillController();
        String[] opcoes = {"Lista Processos", "MataPid", "MataNome", "Sair"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);

        switch (escolha) {
            case 0: 
                killController.listaProcessos();
                break;
            case 1: 
            	String pid = JOptionPane.showInputDialog(null, "Digita o PID do processo");
                killController.mataPid(pid);;
                break;
            case 2:
            	String nome = JOptionPane.showInputDialog(null, "Digita o nome do processo");
            	killController.mataNome(nome);
            	break;
            case 3: 
                JOptionPane.showMessageDialog(null, "Aplicação Finalizada");
                System.exit(0);
                break;
            default:
                break;
        }   
	}
}
