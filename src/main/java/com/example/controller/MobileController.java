package com.example.controller;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;
import com.example.service.MobileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class MobileController {
    private  final MobileService mobileService;

    @PostMapping
    public ResponseEntity<MobileDto> addMobile(@Valid @RequestBody  MobileDto mobileDto){
        return ResponseEntity.ok(mobileService.addMobile(mobileDto));
    }
    @GetMapping
    public ResponseEntity<List<MobileDto>> getMobile(){

        return ResponseEntity.ok(mobileService.getAllMobiles());
    }
    @GetMapping("{id}")
    public ResponseEntity<MobileDto> getAMobile(@PathVariable Long id){
       return ResponseEntity.ok(mobileService.getMobileById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<MobileDto> updateMobile(@PathVariable Long id,@Valid @RequestBody  MobileDto mobileDto){
        return ResponseEntity.ok(mobileService.updateMobile(id, mobileDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMobile(@PathVariable Long id){
        return ResponseEntity.ok(mobileService.deleteMobile(id));
    }
}



