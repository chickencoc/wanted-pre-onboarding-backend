package com.wtdpre.backend.service;

import com.wtdpre.backend.model.Applies;
import com.wtdpre.backend.model.JopPost;
import com.wtdpre.backend.model.Member;
import com.wtdpre.backend.model.dto.AppliesReq;
import com.wtdpre.backend.repository.AppliesRepository;
import com.wtdpre.backend.repository.JopPostRepository;
import com.wtdpre.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JopPostRepository jopPostRepository;
    private final AppliesRepository appliesRepository;

    // 채용공고 지원
    public Boolean applyJop(AppliesReq appliesReq) {
        Optional<Member> optMem = memberRepository.findById(appliesReq.getMemberNo());
        Optional<JopPost> optJop = jopPostRepository.findById(appliesReq.getJopPostNo());

        if(optMem.isPresent() && optJop.isPresent()) {
            appliesRepository.save(
                    Applies.toEntity(optMem.get(), optJop.get())
            );

        }
        else if(optMem.isEmpty())
            throw new IllegalArgumentException("not found member : " + appliesReq.getMemberNo());
        else
            throw new IllegalArgumentException("not found jopPost : " + appliesReq.getJopPostNo());

        return true;
    }
}
