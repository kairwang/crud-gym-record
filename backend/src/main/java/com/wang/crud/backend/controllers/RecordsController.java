package com.wang.crud.backend.controllers;

import com.wang.crud.backend.dtos.GymRecordDto;
import com.wang.crud.backend.services.RecordsService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecordsController {

    private final RecordsService recordsService;

    @GetMapping("/gym/records")
    public ResponseEntity<List<GymRecordDto>> allRecords() {
        return ResponseEntity.ok(recordsService.allRecords());
    }

    @PostMapping("/gym/records")
    public ResponseEntity<GymRecordDto> createGymRecord(@RequestBody GymRecordDto gymRecordDto) {
        GymRecordDto createdGymRecord = recordsService.createGymRecord(gymRecordDto);
        return ResponseEntity.created(URI.create("/gym/records/" + createdGymRecord.getId()))
                .body(createdGymRecord);
    }

    // Update
    @PutMapping("/gym/records/{id}")
    public ResponseEntity<GymRecordDto> updateGymRecord(@PathVariable Long id,
            @RequestBody GymRecordDto gymRecordDto) {
        // returns updated gym record that we wrap into the response entity
        return ResponseEntity.ok(recordsService.updateGymRecord(id, gymRecordDto));
    }

    @PatchMapping("/gym/records/{id}")
    public ResponseEntity<GymRecordDto> patchGymRecord(@PathVariable Long id,
            @RequestBody GymRecordDto recordDto) {
        return ResponseEntity.ok(recordsService.patchGymRecord(id, recordDto));
    }

    @DeleteMapping("/gym/records/{id}")
    public ResponseEntity<GymRecordDto> deleteGymRecord(@PathVariable Long id) {
        return ResponseEntity.ok(recordsService.deleteGymRecord(id));
    }

}
