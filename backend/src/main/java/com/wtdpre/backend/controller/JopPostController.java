package com.wtdpre.backend.controller;

import com.wtdpre.backend.model.dto.JopPostAddReq;
import com.wtdpre.backend.model.dto.JopPostDetailRes;
import com.wtdpre.backend.model.dto.JopPostListRes;
import com.wtdpre.backend.model.dto.JopPostUpdateReq;
import com.wtdpre.backend.service.JopPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jopPost")
public class JopPostController {

    private final JopPostService jopPostService;

    // url : api/jopPost/create
    @PostMapping("/create")
    public ResponseEntity<Boolean> createJopPost(@RequestBody JopPostAddReq addReq) {
        return ResponseEntity.ok(jopPostService.createJopPost(addReq));
    }

    // url : api/jopPost/update
    @PutMapping("/update")
    public ResponseEntity<Boolean> updateJopPost(@RequestBody JopPostUpdateReq updateReq) {
        return ResponseEntity.ok(jopPostService.updateJopPost(updateReq));
    }

    // url : api/jopPost/delete/{jopPostNo}
    @DeleteMapping("/delete/{jopPostNo}")
    public ResponseEntity<Boolean> deleteJopPost(@PathVariable Long jopPostNo) {
        return ResponseEntity.ok(jopPostService.deleteJopPost(jopPostNo));
    }

    // url : api/jopPost/all
    @GetMapping("/all")
    public ResponseEntity<List<JopPostListRes>> getAllJopPosts() {
        return ResponseEntity.ok(jopPostService.getAllJopPosts());
    }

    // url : api/jopPost/view/{jopPostNo}
    @GetMapping("/view/{jopPostNo}")
    public ResponseEntity<JopPostDetailRes> getJopPost(@PathVariable Long jopPostNo) {
        return ResponseEntity.ok(jopPostService.getJopPost(jopPostNo));
    }

    // url : api/jopPost/search?keyword=something
    @GetMapping("/search")
    public ResponseEntity<List<JopPostListRes>> searchJopPost(@RequestParam String keyword) {
        return ResponseEntity.ok(jopPostService.searchJopPost(keyword));
    }

}
