package com.example.config;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;

public class Converter {
    public static MobileDto entityToDto(Mobile mobile){
        return new MobileDto(
                mobile.getId(),
                mobile.getBrand(),
                mobile.getModel(),
                mobile.getPrice(),
                mobile.getStock()
        );
    }
    public static Mobile dtoToEntity(MobileDto mobiledto){
        return new Mobile(
                mobiledto.id(),
                mobiledto.brand(),
                mobiledto.model(),
                mobiledto.price(),
                mobiledto.stock()
        );
    }
}
