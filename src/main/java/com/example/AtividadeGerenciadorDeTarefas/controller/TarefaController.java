package com.example.AtividadeGerenciadorDeTarefas.controller;

import com.example.AtividadeGerenciadorDeTarefas.model.Tarefa;
import com.example.AtividadeGerenciadorDeTarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public ResponseEntity<Tarefa> createTask(@RequestBody Tarefa task) {
        Tarefa created = service.createTask(task);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> getAllTasks() {
        List<Tarefa> list = service.getAllTasks();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Tarefa> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        Tarefa updated = service.updateTaskStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
