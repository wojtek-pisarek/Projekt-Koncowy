package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private Integer rfq;

    @Future
    @Column(nullable = false)
    private Date leadTime;

    @OneToOne
    @JoinColumn(name = "wagon_id",
            unique = false)
    private Wagon wagon;

    @OneToOne
    @JoinColumn(name = "designer_id",
            unique = true)
    private Designer designer;

    @OneToOne
    @JoinColumn(name = "technologist_id",
            unique = true)
    private Technologist technologist;

    @OneToOne
    @JoinColumn(name = "painter_id",
            unique = true)
    private Painter painter;

    @OneToOne
    @JoinColumn(name = "buyer_id",
            unique = true)
    private Buyer buyer;

}