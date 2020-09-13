package pl.coderslab.wagons;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Designer;
import pl.coderslab.model.Wagon;

import java.util.List;

public interface WagonRepository extends JpaRepository<Wagon, Long> {
    public List<Wagon> findAll();

}
