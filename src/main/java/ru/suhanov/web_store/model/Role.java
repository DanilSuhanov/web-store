package ru.suhanov.web_store.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String authority;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    @Override
    public String getAuthority() {
        return authority;
    }
}
