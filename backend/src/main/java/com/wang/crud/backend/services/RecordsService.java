package com.wang.crud.backend.services;

import com.wang.crud.backend.dtos.GymRecordDto;
import com.wang.crud.backend.entities.GymRecord;
import com.wang.crud.backend.exceptions.AppException;
import com.wang.crud.backend.mappers.GymRecordMapper;
import com.wang.crud.backend.repositories.GymRecordsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordsService {

    private final GymRecordsRepo gymRecordsRepo;
    private final GymRecordMapper gymRecordMapper;

    public List<GymRecordDto> allRecords() {
        return gymRecordMapper.toGymRecordDtos(gymRecordsRepo.findAll());
        // mapper reads list of gym records and maps into the list of dtos
    }

    public GymRecordDto createGymRecord(GymRecordDto gymRecordDto) {
        // map the dto into an entity with mapper
        GymRecord gymRecord = gymRecordMapper.toGymRecord(gymRecordDto);
        // with repo, save the gym record, returns the created record (inside it will have id)
        GymRecord createdGymRecord = gymRecordsRepo.save(gymRecord);
        // return gymRecord dto after mapping it into a dto again
        return gymRecordMapper.toGymRecordDto(createdGymRecord);
    }

    public GymRecordDto deleteGymRecord(Long id) {
        GymRecord gymRecord = gymRecordsRepo.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found", HttpStatus.NOT_FOUND));
        // create own exceptions

        GymRecordDto gymRecordDto = gymRecordMapper.toGymRecordDto(gymRecord);

        gymRecordsRepo.deleteById(id);

        return gymRecordDto;
    }

    // Update
    public GymRecordDto updateGymRecord(Long id, GymRecordDto gymRecordDto) {
        // check if gym record exists in database
        GymRecord gymRecord = gymRecordsRepo.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found!", HttpStatus.NOT_FOUND));

        gymRecordMapper.updateGymRecord(gymRecord, gymRecordDto);
        // then create this new "updateGymRecord" method in the mapper

        GymRecord savedGymRecord = gymRecordsRepo.save(gymRecord);

        return gymRecordMapper.toGymRecordDto(savedGymRecord);
    }

    public GymRecordDto patchGymRecord(Long id, GymRecordDto recordDto) {
        GymRecord record = gymRecordsRepo.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found", HttpStatus.NOT_FOUND));

        if (recordDto.getExercise() != null) {
            record.setExercise(recordDto.getExercise());
        }

        if (recordDto.getWeight() != null) {
            record.setWeight(recordDto.getWeight());
        }

        GymRecord savedRecord = gymRecordsRepo.save(record);

        return gymRecordMapper.toGymRecordDto(savedRecord);
    }
}
