package com.val132005.parking.controller.vehicle;

import com.val132005.parking.model.vehicle.VehicleDTO;
import com.val132005.parking.model.vehicle.VehicleEntity;
import com.val132005.parking.service.vehicle.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/listaVehiculos")
    public List<VehicleDTO> listarEstudiantes() {
        return vehicleService.listarVehiculo();
    }

    @PostMapping("/registrarVehiculos")
    public VehicleDTO registrarVehiculo(@RequestBody VehicleEntity vehicleEntity) {
        return vehicleService.registrarVehiculo(vehicleEntity);
    }

    @GetMapping("/consultarVehiculos/{id}")
    public ResponseEntity<VehicleDTO> consultarVehiculo(@PathVariable long id) {
        VehicleDTO vehicleDTO = vehicleService.consultarVehiculo(id);
        return ResponseEntity.ok(vehicleDTO);
    }

    @GetMapping("/consultarVehiculosPorPlaca/{plate}")
    public ResponseEntity<VehicleDTO> consultarVehiculoPorPlaca(@PathVariable String plate) {
        VehicleDTO vehicleDTO = vehicleService.consultarVehiculoPorPlaca(plate);
        return ResponseEntity.ok(vehicleDTO);
    }

    @PutMapping("/actualizarVehiculos/{id}")
    public ResponseEntity<VehicleDTO> actualizarVehiculo(@PathVariable Long id, @RequestBody VehicleDTO vehicleRequest) {
        VehicleDTO vehicleDTO = vehicleService.actualizarVehiculo(id, vehicleRequest);
        return ResponseEntity.ok(vehicleDTO);
    }

    @PutMapping("/actualizarVehiculosPorPlaca/{plate}")
    public ResponseEntity<VehicleDTO> actualizarVehiculo(@PathVariable String plate, @RequestBody VehicleDTO vehicleRequest) {
        VehicleDTO vehicleDTO = vehicleService.actualizarVehiculosPorPlaca(plate, vehicleRequest);
        return ResponseEntity.ok(vehicleDTO);
    }

    @PutMapping("/inactivarVehiculos/{id}")
    public ResponseEntity<VehicleDTO> inactivarVehiculo(@PathVariable Long id) {
        VehicleDTO vehiculoActualizado = vehicleService.inactivarVehiculo(id);
        return ResponseEntity.ok(vehiculoActualizado);
    }

    @PutMapping("/inactivarVehiculosPorPlaca/{plate}")
    public ResponseEntity<VehicleDTO> inactivarVehiculoPorPlaca(@PathVariable String plate) {
        VehicleDTO vehiculoActualizado = vehicleService.inactivarVehiculoPorPlaca(plate);
        return ResponseEntity.ok(vehiculoActualizado);
    }

    @PutMapping("/activarVehiculos/{id}")
    public ResponseEntity<VehicleDTO> activarVehiculo(@PathVariable Long id) {
        VehicleDTO vehiculoActualizado = vehicleService.activarVehiculo(id);
        return ResponseEntity.ok(vehiculoActualizado);
    }

    @PutMapping("/activarVehiculosPorPlaca/{plate}")
    public ResponseEntity<VehicleDTO> activarVehiculoPorPlaca(@PathVariable String plate) {
        VehicleDTO vehiculoActualizado = vehicleService.activarVehiculoPorPlaca(plate);
        return ResponseEntity.ok(vehiculoActualizado);
    }


}
