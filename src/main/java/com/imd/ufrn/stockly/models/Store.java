package com.imd.ufrn.stockly.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table(name = "stores")
@Where(clause = "active = true")
public class Store extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank(message = "O campo nome é obrigatório")
    @Getter
    @Setter
    private String name;

    @Column(name = "location", nullable = false)
    @NotBlank(message = "O campo localização é obrigatório")
    @Getter
    @Setter
    private String location;

    @Column(name = "cnpj", nullable = false)
    @NotBlank(message = "O campo cnpj é obrigatório")
    @Getter
    @Setter
    private String cnpj;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name)
                && Objects.equals(location, store.location) && Objects.equals(cnpj, store.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, location, cnpj);
    }
}
