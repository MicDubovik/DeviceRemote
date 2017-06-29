package restbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import restbook.model.Device;

import java.util.List;

/**
 * Created by Katy on 27.06.2017.
 */
public interface DeviceRepo  extends JpaRepository<Device,Long>{

    Device findByName(String device);

    @Modifying
    @Query(value = "UPDATE devices SET conditions =:condition  WHERE devices.name=:devicename ", nativeQuery = true)
    @Transactional
    void updateDevice(@Param("condition") Boolean condition,
                                                     @Param("devicename") String devicename);
}
