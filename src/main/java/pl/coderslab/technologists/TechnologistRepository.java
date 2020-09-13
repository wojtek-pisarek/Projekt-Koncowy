package pl.coderslab.technologists;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Designer;
import pl.coderslab.model.Technologist;

import java.util.List;

public interface TechnologistRepository extends JpaRepository<Technologist, Long> {
    public List<Technologist> findAll();

}
