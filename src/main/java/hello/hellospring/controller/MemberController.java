package main.java.hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //Dependency Injection. MemberService에 @Service나 @Component가 붙으면 빈으로 등록되서 DI가 가능해진다.
    public MemberController(MemberService memberService) { //SpringConfig를 통해 만들어진 스프링빈 memberService를 주입받는다
        this.memberService = memberService;
    }


    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    //등록기능(회원가입)
    @PostMapping("/members/new") // html form에서 입력받은 값을 새 member객체에 넣어주고 memberService에 회원가입을 수행하고 localhost:8080으로 리다이렉션
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }


    @GetMapping("/members") //조회기능
    public String list(Model model) {
        List<Member> members = memberService.findMembers(); // 가입된 멤버 리스트를 쫙 저장
        model.addAttribute("members", members); // model 생성 (이부분은 상세한 설명이 없음) 데이터 넘겨주는 부분
        return "members/memberList"; //templates/members/memberList 파일을 viewResolver를 통해 렌더링
    }

}
