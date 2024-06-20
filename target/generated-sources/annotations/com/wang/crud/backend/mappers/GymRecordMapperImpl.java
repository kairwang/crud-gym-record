package com.wang.crud.backend.mappers;

import com.wang.crud.backend.dtos.GymRecordDto;
import com.wang.crud.backend.entities.GymRecord;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T21:28:07-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class GymRecordMapperImpl implements GymRecordMapper {

    @Override
    public GymRecord toGymRecord(GymRecordDto dto) {
        if ( dto == null ) {
            return null;
        }

        GymRecord gymRecord = new GymRecord();

        gymRecord.setId( dto.getId() );
        gymRecord.setExercise( dto.getExercise() );
        gymRecord.setWeight( dto.getWeight() );

        return gymRecord;
    }

    @Override
    public GymRecordDto toGymRecordDto(GymRecord gymRecord) {
        if ( gymRecord == null ) {
            return null;
        }

        GymRecordDto gymRecordDto = new GymRecordDto();

        gymRecordDto.setId( gymRecord.getId() );
        gymRecordDto.setExercise( gymRecord.getExercise() );
        gymRecordDto.setWeight( gymRecord.getWeight() );

        return gymRecordDto;
    }

    @Override
    public List<GymRecordDto> toGymRecordDtos(List<GymRecord> gymRecord) {
        if ( gymRecord == null ) {
            return null;
        }

        List<GymRecordDto> list = new ArrayList<GymRecordDto>( gymRecord.size() );
        for ( GymRecord gymRecord1 : gymRecord ) {
            list.add( toGymRecordDto( gymRecord1 ) );
        }

        return list;
    }

    @Override
    public void updateGymRecord(GymRecord gymRecord, GymRecordDto gymRecordDto) {
        if ( gymRecordDto == null ) {
            return;
        }

        gymRecord.setExercise( gymRecordDto.getExercise() );
        gymRecord.setWeight( gymRecordDto.getWeight() );
    }
}
