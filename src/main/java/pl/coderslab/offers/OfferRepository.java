package pl.coderslab.offers;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Offer;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    public List<Offer> findAll();
    public List<Offer> findAllByDesignerId(Long id);

    
}
