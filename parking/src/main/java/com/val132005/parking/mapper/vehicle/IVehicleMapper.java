package com.val132005.parking.mapper.vehicle;

import com.val132005.parking.mapper.IMapperGenerico;
import com.val132005.parking.model.vehicle.VehicleDTO;
import com.val132005.parking.model.vehicle.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IVehicleMapper extends IMapperGenerico<VehicleEntity, VehicleDTO> {

    @Override
    @Mapping(target = "id", ignore = true)
    VehicleEntity loadEntity(VehicleDTO dto);

    @Override
    VehicleDTO loadDto(VehicleEntity entity);

    @Override
    List<VehicleEntity> loadEntities(List<VehicleDTO> dtos);

    @Override
    List<VehicleDTO> loadDtos(List<VehicleEntity> entities);

}
