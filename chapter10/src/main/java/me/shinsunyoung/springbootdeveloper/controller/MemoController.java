package me.shinsunyoung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Memo;
import me.shinsunyoung.springbootdeveloper.repository.MemoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemoController {

    private final MemoRepository memoRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Memo> memoList = memoRepository.findAllByOrderByIdDesc();
        model.addAttribute("memos", memoList);
        return "index";
    }

    @PostMapping("/memo")
    public String saveMemo(@RequestParam("content") String content) {
        if (content != null && !content.trim().isEmpty()) {
            memoRepository.save(new Memo(content));
        }
        return "redirect:/"; // 저장 후 메인 페이지로 리다이렉트 (POST-Redirect-GET 패턴)
    }
}