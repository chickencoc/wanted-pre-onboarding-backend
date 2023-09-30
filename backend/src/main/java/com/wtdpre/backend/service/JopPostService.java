package com.wtdpre.backend.service;

import com.wtdpre.backend.model.Company;
import com.wtdpre.backend.model.JopPost;
import com.wtdpre.backend.model.dto.JopPostAddReq;
import com.wtdpre.backend.model.dto.JopPostDetailRes;
import com.wtdpre.backend.model.dto.JopPostListRes;
import com.wtdpre.backend.model.dto.JopPostUpdateReq;
import com.wtdpre.backend.repository.CompanyRepository;
import com.wtdpre.backend.repository.JopPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JopPostService {

    private final JopPostRepository jopPostRepository;
    private final CompanyRepository companyRepository;

    // 채용공고 등록 Create
    @Transactional
    public boolean createJopPost(JopPostAddReq addReq) {
        Optional<Company> optComp = companyRepository.findById(addReq.getCompanyNo());

        if(optComp.isEmpty())
            throw new IllegalArgumentException("not found Company : " + addReq.getCompanyNo());
        else {
            jopPostRepository.save(
                    JopPost.toEntity(addReq, optComp.get())
            );
        }
        return true;
    }

    // 채용공고 수정 Update
    @Transactional
    public boolean updateJopPost(JopPostUpdateReq updateReq) {
        Optional<JopPost> optJop = jopPostRepository.findById(updateReq.getJopPostNo());

        if(optJop.isEmpty())
            throw new IllegalArgumentException("not found JopPost : " + updateReq.getJopPostNo());
        else {
            JopPost jopPost = optJop.get();
            jopPost.update(updateReq);
            jopPostRepository.save(jopPost);
        }
        return true;
    }

    // 채용공고 삭제 Delete
    public boolean deleteJopPost(Long jopPostNo) {
        jopPostRepository.deleteById(jopPostNo);
        return true;
    }

    // 채용공고 전체 목록 ReadAll
    public List<JopPostListRes> getAllJopPosts() {
        return jopPostRepository.findAll()
                                .stream().map(JopPostListRes::new)
                                .toList();
    }

    // 채용공고 상세 내용 Detail
    public JopPostDetailRes getJopPost(Long jopPostNo) {
        Optional<JopPost> optJop = jopPostRepository.findById(jopPostNo);

        if(optJop.isEmpty())
            throw new IllegalArgumentException("not found JopPost : " + jopPostNo);
        else {
            List<Long> jopPostNoList = jopPostRepository.findByCompanyNo(optJop.get().getCompany().getNo())
                                                        .stream().map(JopPost::getNo).filter(el -> !el.equals(jopPostNo))
                                                        .toList();

            return new JopPostDetailRes(optJop.get(), jopPostNoList);
        }
    }

    // 채용공고 검색 Search
    public List<JopPostListRes> searchJopPost(String keyword) {
        return jopPostRepository.findByPositionContainingOrTechStackContainingOrCompanyNo_NameContaining(keyword, keyword, keyword)
                                .stream().map(JopPostListRes::new)
                                .toList();
    }

}
