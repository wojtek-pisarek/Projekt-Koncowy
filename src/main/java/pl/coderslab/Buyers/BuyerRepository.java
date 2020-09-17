package pl.coderslab.Buyers;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Buyer;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer,Long> {
public List<Buyer> findAll();

}
