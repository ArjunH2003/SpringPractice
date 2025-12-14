package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // TODO: Add validation annotations (e.g., @NotBlank for title)

    // Getters and Setters
}






// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String username;

//     // One user can have many todos
//     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Todo> todos = new ArrayList<>();
// }



// @Entity
// @Table(name = "todos")
// public class Todo {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String title;
//     private boolean completed;

//     // Many todos belong to one user
//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;
// }