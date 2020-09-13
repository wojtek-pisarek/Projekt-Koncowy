package pl.coderslab.painters;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Designer;
import pl.coderslab.model.Painter;

import java.util.List;

public interface PainterRepository extends JpaRepository<Painter, Long> {

    public List<Painter> findAll();
}
