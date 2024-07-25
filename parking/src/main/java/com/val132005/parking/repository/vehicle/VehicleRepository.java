package com.val132005.parking.repository.vehicle;

import com.val132005.parking.model.vehicle.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findByPlate(String plate);

    void deleteByPlate(String plate);

    boolean existsByPlate(String plate);


}
