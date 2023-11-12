package com.intellectual.memo.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/memo")
public class MemoContoller {

    @PostMapping
    public String postMemo(@RequestParam String title, @RequestParam String content) {
        log.info("title={}, content={}", title, content);
        return "memo";
    }
}
