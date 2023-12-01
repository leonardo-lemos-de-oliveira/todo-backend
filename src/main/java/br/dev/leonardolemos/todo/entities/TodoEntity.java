package br.dev.leonardolemos.todo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "tb_todo")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Boolean completed;

    public void updateTodo(TodoEntity updatedTodo) {
        BeanUtils.copyProperties(updatedTodo, this, "id");
    }
}
