package com.wtdpre.backend.repository;

import com.wtdpre.backend.model.JopPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JopPostRepository extends JpaRepository<JopPost, Long> {

    List<JopPost> findByPositionContainingOrTechStackContainingOrCompanyNo_NameContaining(
            String positonKeyword, String StackKeyword, String coNameKeyword
    );

    List<JopPost> findByCompanyNo(Long companyNo);
}
