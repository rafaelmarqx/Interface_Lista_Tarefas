package br.newtonpaiva;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Interface_Lista extends JFrame {

    private ArrayList<String> tarefas = new ArrayList<String>();

    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("1. Adicionar tarefa");
    private JButton jButtonAposta2 = new JButton("2. Remover tarefa");
    private JButton jButtonAposta3 = new JButton("3. Listar tarefas");
    private JButton jButtonAposta4 = new JButton("4. Sair");

    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");

    public Interface_Lista() {
        this.setTitle("== Aplicativo de Lista de Tarefas ==");
        this.setSize(400, 250);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));
        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        painel.add(jButtonAposta4);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela

        jButtonAposta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tarefainput = JOptionPane.showInputDialog(null, "Digite a tarefa a ser adicionada:");
                JOptionPane.showMessageDialog(null, "Você digitou: " + tarefainput);
                adicionarTarefa(tarefainput);
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String indiceInput = JOptionPane.showInputDialog(null, "Digite o índice da tarefa a ser removida:");
                int indice = Integer.parseInt(indiceInput);
                JOptionPane.showMessageDialog(null, "Você digitou: " + indice);
                removerTarefa(indice);
            }
        });


        jButtonAposta3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarTarefas();
            }
        });

        jButtonAposta4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


    private void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
    }

    private void removerTarefa(int indice) {
        tarefas.remove(indice);
    }

    private void listarTarefas() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de tarefas está vazia.");
        } else {
            StringBuilder lista = new StringBuilder("Lista de Tarefas:\n");
            for (String tarefa : tarefas) {
                lista.append(tarefa).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    public static void main(String[] args) {
        new Interface_Lista();
    }
}