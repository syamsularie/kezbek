package com.kezbek.application.repository;

import com.kezbek.application.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
