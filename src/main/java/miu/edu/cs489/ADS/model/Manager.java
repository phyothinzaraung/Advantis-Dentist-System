package miu.edu.cs489.ADS.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("manager")
public class Manager extends User {
}
