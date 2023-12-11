package sisal.services.flightMs.domain.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.type.NumericBooleanConverter;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean deleted = false;

    private LocalDateTime deletedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BaseEntity {" +
                "id = " + id +
                "}";
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
        this.deletedDate = LocalDateTime.now();
    }

    public Boolean getDeleted() {
        return deleted;
    }
}