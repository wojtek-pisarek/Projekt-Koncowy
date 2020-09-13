package pl.coderslab.designers;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Designer;
import pl.coderslab.model.Offer;

import java.util.List;

public interface DesignerRepository extends JpaRepository<Designer, Long> {
    public List<Designer> findAll();
}
