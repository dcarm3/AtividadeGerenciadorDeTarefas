package com.example.AtividadeGerenciadorDeTarefas.service;

import com.example.AtividadeGerenciadorDeTarefas.model.Tarefa;
import java.util.List;

public interface TarefaService {
    Tarefa createTask(Tarefa task);
    List<Tarefa> getAllTasks();
    Tarefa updateTaskStatus(Long id, String status);
    void deleteTask(Long id);
}
