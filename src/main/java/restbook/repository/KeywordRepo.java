package restbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restbook.model.Device;
import restbook.model.Keyword;

import java.util.List;

/**
 * Created by Katy on 27.06.2017.
 */
public interface KeywordRepo extends JpaRepository<Keyword, Long> {

    List<Keyword> findAllByDevice(Device device);

}
