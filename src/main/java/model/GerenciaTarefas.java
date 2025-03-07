package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GerenciaTarefas {
    
    //Instanciamento direto (meu deu problema ao instanciar no constructor, dizia que era nulo)
    //e eu não estava sabendo lidar com o erro fessora
    private static List<Tarefa> tarefas = new ArrayList<Tarefa>();
    
    public GerenciaTarefas() {
    }
            
    public static boolean cadastrar(Tarefa tarefa) {
        if(tarefa != null)
            if(!(tarefas.contains(tarefa))) // para não adicionar repetido
                return tarefas.add(tarefa);
        return false;
    }
    
    public static List<Tarefa> getTarefas() {
        return tarefas;
    }
    
    public static boolean removerTarefa(Tarefa tarefa){
        if(tarefa != null)
            return tarefas.remove(tarefa);
        return false;
    }
}
