package com.shop.metering.entity.repository;

import com.shop.metering.entity.ApiCallHistroy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ApiCallHistroyRepository extends JpaRepository<ApiCallHistroy, Long>, JpaSpecificationExecutor<ApiCallHistroy> {
}
