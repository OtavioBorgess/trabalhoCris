package controller;

import java.time.LocalDate;
import model.GerenciaTarefas;
import model.TarefaComPrazo;
import model.TarefaSimples;

public class TarefaController {

    /**
     * Tenta cadastrar os dados
     *
     * @param descricao: descrição da tarefa
     * @param prioridade: 1 a 5
     * @param dataCriacao: data de criação da tarefa
     * @return : true se pode cadastrar e false caso contrario
     */
    public boolean addTarefaSimples(String descricao, int prioridade, LocalDate dataCriacao) {
        //Tratamento das exceções (verifica se campo descrição está nulo ou vazio)
        //caso esteja, será enviado uma mensagem de erro
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao nao pode ser vazia.");

        } else if (dataCriacao == null) {
            throw new IllegalArgumentException("Data de cricacao nao pode ser nula.");

        } else{
            return GerenciaTarefas.cadastrar(
                    new TarefaSimples(descricao, prioridade, dataCriacao));
        }
    }

    public boolean addTarefaPrazo(String descricao, int prioridade, LocalDate dataCriacao, LocalDate prazo) {
        //O mesmo de cima, porém com a exceção da data prazo não podendo ser anterior a data criacao    
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao nao pode ser vazia.");

        } else if (dataCriacao == null || prazo == null) {
            throw new IllegalArgumentException("data criacao ou data prazo nao podem ser nula.");
            
        //Função para que a data prazo não possa ser anterior do que a data inicio
        } else if(prazo.isBefore(dataCriacao)){
            throw new IllegalArgumentException("Data prazo nao pode ser anterior a data criacao");

        } else {
            return GerenciaTarefas.cadastrar(
                    new TarefaComPrazo(descricao, prioridade, dataCriacao, prazo));
        }
    }
}
