package pl.coderslab.offers;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Offer;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    public List<Offer> findAll();

    public List<Offer> findAllByDesignerId(Long id);

    public List<Offer> findAllByBuyerId(Long id);

    public List<Offer> findAllByPainterId(Long id);

    public List<Offer> findAllByTechnologistId(Long id);

    public List<Offer> findAllByWagonId(Long id);

}
