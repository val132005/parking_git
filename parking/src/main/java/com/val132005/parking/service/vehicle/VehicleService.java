package com.val132005.parking.service.vehicle;

import com.val132005.parking.exception.ResourceNotFoudException;
import com.val132005.parking.mapper.vehicle.IVehicleMapper;
import com.val132005.parking.model.vehicle.Status;
import com.val132005.parking.model.vehicle.VehicleDTO;
import com.val132005.parking.model.vehicle.VehicleEntity;
import com.val132005.parking.repository.vehicle.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;
    private IVehicleMapper mapper;

    public VehicleService(VehicleRepository vehicleRepository, IVehicleMapper mapper) {
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
    }

    public List<VehicleDTO> listarVehiculo() {
        return mapper.loadDtos(vehicleRepository.findAll());
    }

    public VehicleDTO registrarVehiculo(VehicleEntity vehicleEntity) {
        return mapper.loadDto(vehicleRepository.save(vehicleEntity));
    }

    public VehicleDTO consultarVehiculo(long id) {
        return mapper.loadDto(vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoudException("El vehiculo con Id " + id + " no existe")));
    }

    public VehicleDTO consultarVehiculoPorPlaca(String plate) {
        return mapper.loadDto(vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new ResourceNotFoudException("El vehiculo con Placa " + plate + " no existe")));
    }

    public VehicleDTO actualizarVehiculo(long id, VehicleDTO vehicleDTO) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoudException("El estudiante con Id " + id + " no existe"));
        vehicleEntity.setStatus(Status.valueOf(vehicleDTO.getStatus()));
        vehicleEntity.setColor(vehicleDTO.getColor());
        vehicleEntity.setMake(vehicleDTO.getMake());
        vehicleEntity.setOwner(vehicleDTO.getOwner());
        vehicleEntity.setModel(vehicleDTO.getModel());
        vehicleEntity.setDayOfEntry(vehicleDTO.getDayOfEntry());
        vehicleEntity.setDayOfDeparture(vehicleDTO.getDayOfDeparture());
        vehicleEntity.setTimeOfEntry(vehicleDTO.getTimeOfEntry());
        vehicleEntity.setTimeOfDeparture(vehicleDTO.getTimeOfDeparture());


        return mapper.loadDto(vehicleRepository.save(vehicleEntity));
    }

    public VehicleDTO actualizarVehiculosPorPlaca(String plate, VehicleDTO vehicleDTO) {
        VehicleEntity vehicleEntity = vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new ResourceNotFoudException("El estudiante con placa " + plate + " no existe"));
        vehicleEntity.setStatus(Status.valueOf(vehicleDTO.getStatus()));
        vehicleEntity.setColor(vehicleDTO.getColor());
        vehicleEntity.setMake(vehicleDTO.getMake());
        vehicleEntity.setOwner(vehicleDTO.getOwner());
        vehicleEntity.setModel(vehicleDTO.getModel());
        vehicleEntity.setDayOfEntry(vehicleDTO.getDayOfEntry());
        vehicleEntity.setDayOfDeparture(vehicleDTO.getDayOfDeparture());
        vehicleEntity.setTimeOfEntry(vehicleDTO.getTimeOfEntry());
        vehicleEntity.setTimeOfDeparture(vehicleDTO.getTimeOfDeparture());


        return mapper.loadDto(vehicleRepository.save(vehicleEntity));
    }

    public VehicleDTO inactivarVehiculo(long id) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoudException("El vehiculo con Id " + id + " no existe"));
        vehicleEntity.setStatus(Status.INACTIVO);
        return mapper.loadDto(vehicleRepository.save(vehicleEntity));
    }

    public VehicleDTO inactivarVehiculoPorPlaca(String plate) {
        VehicleEntity vehicleEntity = vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new ResourceNotFoudException("El vehiculo con placa " + plate + " no existe"));
        vehicleEntity.setStatus(Status.INACTIVO);
        return mapper.loadDto(vehicleRepository.save(vehicleEntity));
    }

    public VehicleDTO activarVehiculo(long id) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoudException("El estudiante con Id " + id + " no existe"));
        vehicleEntity.setStatus(Status.ACTIVO);
        return mapper.loadDto(vehicleRepository.save(vehicleEntity));
    }

    public VehicleDTO activarVehiculoPorPlaca(String plate) {
        VehicleEntity vehicleEntity = vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new ResourceNotFoudException("El vehiculo con Placa " + plate + " no existe"));
        vehicleEntity.setStatus(Status.ACTIVO);
        return mapper.loadDto(vehicleRepository.save(vehicleEntity));
    }

}
