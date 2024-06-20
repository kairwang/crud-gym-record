package com.wang.crud.backend.mappers;

import com.wang.crud.backend.dtos.GymRecordDto;
import com.wang.crud.backend.entities.GymRecord;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GymRecordMapper {

    GymRecord toGymRecord(GymRecordDto dto); // maps dto to gym record entity

    GymRecordDto toGymRecordDto(GymRecord gymRecord); // same in reverse

    List<GymRecordDto> toGymRecordDtos(List<GymRecord> gymRecord);

    // update
    @Mapping(target = "id", ignore = true) //bc we dont want to override id
    void updateGymRecord(@MappingTarget GymRecord gymRecord, GymRecordDto gymRecordDto);
}
