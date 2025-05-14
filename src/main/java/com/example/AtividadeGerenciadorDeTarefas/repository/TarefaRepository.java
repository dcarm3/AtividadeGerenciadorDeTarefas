package com.example.AtividadeGerenciadorDeTarefas.repository;

import com.example.AtividadeGerenciadorDeTarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
