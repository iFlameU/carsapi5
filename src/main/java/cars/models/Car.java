package cars.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class Car {
    @NotNull
    private int id;
    @NotBlank
    private String brand;
    @NotBlank
    private String type;
}
