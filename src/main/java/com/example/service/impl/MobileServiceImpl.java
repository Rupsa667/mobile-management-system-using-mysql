package com.example.service.impl;

import com.example.config.Converter;
import com.example.dto.MobileDto;
import com.example.entity.Mobile;
import com.example.exception.MobileNotFoundException;
import com.example.repository.MobileRepository;
import com.example.service.MobileService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MobileServiceImpl implements MobileService {
    private  final MobileRepository mobileRepository;
    //private final ModelMapper modelMapper;

    @Override
    public MobileDto addMobile(MobileDto mobileDto) {
//        Mobile m=modelMapper.map(mobileDto,Mobile.class);
//        Mobile saved=mobileRepository.save(m);
//        return modelMapper.map(saved,MobileDto.class);

       // return modelMapper.map(mobileRepository.save(modelMapper.map(mobileDto,Mobile.class)),MobileDto.class);
    return Converter.entityToDto(mobileRepository.save(Converter.dtoToEntity(mobileDto)));
    }

    @Override
    public List<MobileDto> getAllMobiles() {
        //List<Mobile> mobiles=mobileRepository.findAll();
        //return  mobileRepository.findAll().stream().map(m->modelMapper.map(m,MobileDto.class)).toList();
        return  mobileRepository.findAll().stream().map(Converter::entityToDto).toList();
    }

    @Override
    public MobileDto getMobileById(Long id) {
//        return mobileRepository.findById(id).map(m->modelMapper.map(m,MobileDto.class)).orElseThrow(
//                ()->new MobileNotFoundException("Mobile with id: "+id+" not found"));
        return mobileRepository.findById(id).map(Converter::entityToDto).orElseThrow(
                ()->new MobileNotFoundException("Mobile with id: "+id+" not found"));

    }

    @Override
    public MobileDto updateMobile(Long id,MobileDto mobileDto) {
        Mobile em=mobileRepository.findById(id).orElseThrow(
                ()->new MobileNotFoundException("Mobile with id: "+id+" not found"));
        em.setBrand(mobileDto.brand());
        em.setModel(mobileDto.model());
        em.setPrice(mobileDto.price());
        em.setStock(mobileDto.stock());
        //return modelMapper.map(mobileRepository.save(em), MobileDto.class);
        return Converter.entityToDto(mobileRepository.save(em));
    }

    @Override
    public String deleteMobile(Long id) {
        Mobile em=mobileRepository.findById(id).orElseThrow(
                ()->new MobileNotFoundException("Mobile with id: "+id+" not found"));
        mobileRepository.delete(em);
        return "Mobile with id "+id+" deleted";
    }
}
