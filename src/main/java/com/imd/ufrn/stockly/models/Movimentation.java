package com.imd.ufrn.stockly.models;

import com.imd.ufrn.stockly.models.enums.MovimenationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "movimentations")
public class Movimentation extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "id_productSK", referencedColumnName = "id")
    @Getter
    @Setter
    private ProductStockKeeping productStockKeeping;

    @Column(name = "movimentation_type", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo tipo de movimentação não pode ser nulo")
    @Getter
    @Setter
    private MovimenationType movimenationType;

    @Column(name = "amount", nullable = false)
    @NotNull(message = "O campo quantidade é obrigatório")
    @Getter
    @Setter
    private int amount;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Movimentation movimentation = (Movimentation) o;
        return Objects.equals(productStockKeeping, movimentation.productStockKeeping)
                && Objects.equals(movimenationType, movimentation.movimenationType)
                && Objects.equals(amount, movimentation.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productStockKeeping, movimenationType, amount);
    }

}
