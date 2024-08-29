package view;

import javax.swing.JOptionPane;

import controller.DistoController;

public class Main {
	public static void main(String[]Args) {
		DistoController dc = new DistoController();
		String[] opcoes = {"Ver informações Linux", "Sair"};

        int cd = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
        while (cd != 1) {
            switch (cd) {
                case 0:
                    dc.exibeDistro();
                    break;
                default:
                    break;
            }
        }
	} 
}