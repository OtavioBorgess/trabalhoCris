package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.GerenciaTarefas;
import model.Tarefa;
import model.TarefaComPrazo;

public class TabelaController {

    public void preencherTabela(JTable tabela, List<Tarefa> tarefas) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(tarefas.size());  // Limpa a tabela antes de preencher.

        // Preenche a tabela com as tarefas
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            if (tarefa != null) {
                //Condição para ver se tarefa é com prazo ou simples, assim adicionando na tabela
                modelo.setValueAt(tarefa instanceof TarefaComPrazo ? "Com Prazo" : "Simples", i, 0);
                modelo.setValueAt(tarefa.getDescricao(), i, 1);
                modelo.setValueAt(tarefa.getPrioridade(), i, 2);
                modelo.setValueAt(tarefa.getDataCriacao().toString(), i, 3);

                // Se for uma tarefa com prazo, preenche a data de prazo
                if (tarefa instanceof TarefaComPrazo tarefaComPrazo) {
                    modelo.setValueAt(tarefaComPrazo.getPrazo().toString(), i, 4);
                }
            }
        }
    }

    public void excluirLinha(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        int linhaSelecionada = tabela.getSelectedRow();

        //Função para ver se tem alguma linha selecionada para excluir
        if (linhaSelecionada != -1) {
            java.util.List<Tarefa> listaTarefas = GerenciaTarefas.getTarefas();
            Tarefa tarefaSelecionada = listaTarefas.get(linhaSelecionada);
            listaTarefas.remove(tarefaSelecionada);

            modelo.removeRow(linhaSelecionada);

            JOptionPane.showMessageDialog(tabela, "Tarefa excluída com sucesso.");

            // Verifica se a tabela está vazia
        } else if ((tabela.getRowCount() == 0)) {
            JOptionPane.showMessageDialog(tabela, "Sem tarefas para excluir.");

        } else {
            // Caso contrário, se a tabela tiver dados mas nenhuma linha selecionada
            JOptionPane.showMessageDialog(tabela, "Selecione uma linha.");
        }
    }
}
