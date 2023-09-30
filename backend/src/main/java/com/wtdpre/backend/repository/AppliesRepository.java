package com.wtdpre.backend.repository;

import com.wtdpre.backend.model.Applies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliesRepository extends JpaRepository<Applies, Long> {
}
