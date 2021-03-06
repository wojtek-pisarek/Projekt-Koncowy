package pl.coderslab.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
@EqualsAndHashCode(of="id")
@Getter
@Setter
@Entity
@Table(name = "designers")
public class Designer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Email
    private  String email;

    private Integer phoneNumber;


}
