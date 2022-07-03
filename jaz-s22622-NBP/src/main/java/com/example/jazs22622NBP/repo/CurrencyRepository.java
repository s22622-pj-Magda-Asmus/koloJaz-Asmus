package com.example.jazs22622NBP.repo;

import com.example.jazs22622NBP.model.CurrencyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Instant;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyDetails, Long> {


    @Modifying
    @Query(value = "INSERT into CurrencyDetails (id, `avg`, currency, createdAt) values (:avg, :currency, :createdAt)", nativeQuery = true)
    CurrencyDetails save(@Param("avg") BigDecimal avg, @Param("currency") String currency, @Param("createdAt") Instant createdAt);
}