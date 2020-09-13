package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,
            unique = true)
    @NotNull
    private Integer rfq;


    //    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
    @Transient
    String date;

    @Column(nullable = false)
    LocalDate leadTime=LocalDate.now();

     @PrePersist
     public void dateConvert (){
         leadTime=LocalDate.parse(date);
     }



    @OneToOne
    @JoinColumn(name = "wagon_id",
            unique = false)
    private Wagon wagon;

    @OneToOne
    @JoinColumn(name = "designer_id",
            unique = false)
    private Designer designer;

    @OneToOne
    @JoinColumn(name = "technologist_id",
            unique = false)
    private Technologist technologist;

    @OneToOne
    @JoinColumn(name = "painter_id",
            unique = false)
    private Painter painter;

    @OneToOne
    @JoinColumn(name = "buyer_id",
            unique = false)
    private Buyer buyer;

}