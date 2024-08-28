package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
    public static void main(String[] args) {
        RedesController redesController = new RedesController();
        String[] opcoes = {"Configuração IP", "Ping", "Sair"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);

        switch (escolha) {
            case 0: 
                redesController.ip();
                break;
            case 1: 
                redesController.ping();
                break;
            case 2: 
                JOptionPane.showMessageDialog(null, "Aplicação Finalizada");
                System.exit(0);
                break;
            default:
                break;
        }   
    }
}
