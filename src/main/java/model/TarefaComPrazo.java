package model;

import java.time.LocalDate;


public class TarefaComPrazo extends Tarefa {
    
    LocalDate prazo;

    public TarefaComPrazo() {
    }

    public TarefaComPrazo(String descricao, int prioridade, LocalDate dataCriacao, LocalDate prazo) {
        super(descricao, prioridade, dataCriacao);
        this.prazo = prazo;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    @Override
    public String toString() {
        return super.toString() + ",prazo=" + prazo + '}';
    }
    
    @Override
    public boolean equals (Object obj) {
        if(super.equals(obj)) {
            if(this.prazo.equals (
            ((TarefaComPrazo)obj).prazo))
                return true;
        }
        return false;
    }

    
}
