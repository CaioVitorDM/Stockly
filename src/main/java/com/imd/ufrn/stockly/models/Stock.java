package com.imd.ufrn.stockly.models;

import com.imd.ufrn.stockly.models.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table(name = "stocks")
@Where(clause = "active = true")
public class Stock extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_store")
    @Getter
    @Setter
    private Store store;

    @Column(name = "location")
    @Getter
    @Setter
    private String location;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Stock stock = (Stock) o;
        return Objects.equals(store, stock.store)
                && Objects.equals(location, stock.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), store, location);
    }
}
