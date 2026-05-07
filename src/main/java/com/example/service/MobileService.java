package com.example.service;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;

import java.util.List;

public interface MobileService {
    public MobileDto addMobile(MobileDto mobileDto);
    public List<MobileDto> getAllMobiles();
    public MobileDto getMobileById(Long id);
    public MobileDto updateMobile(Long id,MobileDto mobileDto);
public  String deleteMobile(Long id);
}
