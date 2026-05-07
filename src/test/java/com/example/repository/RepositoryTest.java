package com.example.repository;

import com.example.entity.Mobile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RepositoryTest {
    @Autowired
    private MobileRepository mobileRepository;
    @Test
    void testSaveAndFind(){
        Mobile mobile=new Mobile();
        mobile.setBrand("rupsa");
        mobile.setStock(10);
        mobile.setPrice(1000.0);
        mobile.setModel("spring");
        Mobile fetched=mobileRepository.findById(mobile.getId()).get();
        assertNotNull(fetched);
    }
}
