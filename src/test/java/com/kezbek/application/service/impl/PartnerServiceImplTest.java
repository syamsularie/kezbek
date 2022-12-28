package com.kezbek.application.service.impl;

import com.kezbek.application.entity.Partner;
import com.kezbek.application.repository.PartnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@DisplayName("Partner Service Impl")
@ExtendWith(MockitoExtension.class)
public class PartnerServiceImplTest {

    PartnerServiceImpl partnerServiceImpl;

    @Mock
    PartnerRepository partnerRepository;

    @BeforeEach
    void init(){
        partnerServiceImpl = new PartnerServiceImpl();
        partnerServiceImpl.partnerRepository = partnerRepository;
    }

    @Test
    @DisplayName("should return partner")
    void testSuccesAdd() {
        //arrange
        Partner partner = Partner.builder()
                .name("tokomerah")
                .description("Ini toko merah")
                .category("e-commerce")
                .build();
        Mockito.doNothing().when(partnerRepository.save(partner));
        Mockito.when(partnerRepository.save(partner).getId()).thenReturn(1L);
        //act
        Long result = partnerServiceImpl.add(partner);
        //assert
        Assertions.assertNotNull(result);
    }
}
