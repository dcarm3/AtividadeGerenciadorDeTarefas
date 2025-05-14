package com.example.AtividadeGerenciadorDeTarefas.service.impl;

import com.example.AtividadeGerenciadorDeTarefas.model.Tarefa;
import com.example.AtividadeGerenciadorDeTarefas.repository.TarefaRepository;
import com.example.AtividadeGerenciadorDeTarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Override
    public Tarefa createTask(Tarefa task) {
        task.setStatus("TODO");
        return repository.save(task);
    }

    @Override
    public List<Tarefa> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Tarefa updateTaskStatus(Long id, String status) {
        Optional<Tarefa> opt = repository.findById(id);
        if (!opt.isPresent()) {
            throw new RuntimeException("Tarefa " + id + " não encontrada");
        }
        Tarefa task = opt.get();
        task.setStatus(status);
        return repository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}