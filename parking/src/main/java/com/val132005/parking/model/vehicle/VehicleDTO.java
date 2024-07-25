package com.val132005.parking.model.vehicle;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {


    @NotNull
    @javax.validation.constraints.Pattern(regexp = "^[A-Z]{3}-\\d{3}$", message = "La placa debe tener el formato AAA-123")
    @javax.validation.constraints.NotBlank(message = "La placa es requerida")
    private String plate;

    @NotNull
    @javax.validation.constraints.NotNull(message = "El estado es requerido")
    private String status;

    @NotNull
    @javax.validation.constraints.Size(min = 4, max = 20, message = "El color debe tener entre 4 y 20 caracteres")
    @javax.validation.constraints.Pattern(regexp = "^[^0-9]+$", message = "El color no debe contener números")
    @javax.validation.constraints.NotBlank(message = "El color es requerido")
    private String color;

    @NotNull
    @javax.validation.constraints.Size(min = 4, max = 30, message = "La marca debe tener entre 4 y 30 caracteres")
    @javax.validation.constraints.NotBlank(message = "La marca es requerida")
    private String make;

    @NotNull
    @javax.validation.constraints.Size(min = 3, max = 50, message = "El dueño debe tener entre 3 y 50 caracteres")
    @javax.validation.constraints.NotBlank(message = "El dueño es requerido")
    private String owner;

    @NotNull
    @javax.validation.constraints.Positive(message = "El modelo debe ser un número entero positivo")
    @javax.validation.constraints.Digits(integer = 4, fraction = 0, message = "El modelo debe tener 4 dígitos")
    @javax.validation.constraints.NotNull(message = "El modelo es requerido")
    private int model;

    @NotNull
    @javax.validation.constraints.Pattern(regexp = "^\\s*(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(\\d{4})\\s*$", message = "La fecha de salida debe tener el formato DD/MM/AAAA")
    private Date dayOfEntry;

    @NotNull
    @javax.validation.constraints.Pattern(regexp = "^\\s*(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(\\d{4})\\s*$", message = "La fecha de salida debe tener el formato DD/MM/AAAA")
    private Date dayOfDeparture;

    @NotNull
    @javax.validation.constraints.Pattern(regexp = "^(1[0-2]|0[1-9]):[0-5][0-9] (AM|PM)$", message = "La hora de entrada debe tener el formato HH:MM AM/PM")
    private Time timeOfEntry;

    @NotNull
    @Pattern(regexp = "^(1[0-2]|0[1-9]):[0-5][0-9] (AM|PM)$", message = "La hora de salida debe tener el formato HH:MM AM/PM")
    private Time timeOfDeparture;

}
