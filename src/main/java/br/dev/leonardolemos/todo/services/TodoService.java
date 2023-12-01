package br.dev.leonardolemos.todo.services;

import br.dev.leonardolemos.todo.entities.TodoEntity;
import br.dev.leonardolemos.todo.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoEntity> findAll() {
        return repository.findAll();
    }

    public Optional<TodoEntity> findById(int id) {
        return repository.findById(id);
    }

    public TodoEntity create(TodoEntity todo) {
        return repository.save(todo);
    }

    public void updateTodo(Integer id, TodoEntity updatedTodo) {
        Optional<TodoEntity> todoOptional = repository.findById(id);
        if (todoOptional.isPresent()) {
            TodoEntity existingTodo = todoOptional.get();
            existingTodo.updateTodo(updatedTodo);
            repository.save(existingTodo);
        }
        //TODO: Treat possible error if no result is found
    }

    public void deleteTodoById(Integer id) {
        repository.deleteById(id);
    }
}
