package com.imd.ufrn.stockly.models;

import com.imd.ufrn.stockly.models.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "users")
@Where(clause = "active = true")
public class User extends BaseEntity{

    @Column(name = "name", nullable = false)
    @NotBlank(message = "O campo nome é obrigatório")
    @Getter
    @Setter
    private String name;

    @Column(name = "login", nullable = false)
    @NotBlank(message = "O campo login é obrigatório")
    @Getter
    @Setter
    private String login;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "O campo senha é obrigatório")
    @Size(min = 4, message = "A senha precisa ter, no mínimo, 4 caracteres")
    @Getter
    @Setter
    private String password;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "O campo email é obrigatório")
    @Getter
    @Setter
    private String email;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo perfil não pode ser nulo")
    @Getter
    @Setter
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        User user = (User) o;
        return Objects.equals(login, user.login)
                && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, role);
    }
}
