package com.imd.ufrn.stockly.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table
@Where(clause = "active = true")
public class ProductStockKeeping extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "id_product")
    @Getter
    @Setter
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_stock")
    @Getter
    @Setter
    private Stock stock;

    @Column(name = "quantity", nullable = false)
    @NotNull(message = "O campo quantidade não pode ser nulo")
    @Getter
    @Setter
    private int quantity;

    @Column(name = "location", nullable = false)
    @NotBlank(message = "O campo localização é obrigatório")
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
        ProductStockKeeping productStockKeeping = (ProductStockKeeping) o;
        return Objects.equals(product, productStockKeeping.product)
                && Objects.equals(stock, productStockKeeping.stock)
                && Objects.equals(quantity, productStockKeeping.quantity)
                && Objects.equals(location, productStockKeeping.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product, stock, quantity, location);
    }

}
