package main.java.hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig { // 의존관계 주입을 위한 SpringConfig

    @Bean // 함께 생성된 스프링 빈인 memberRepository를 MemberService에 넣어준다
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean //memberRepository 스프링빈을 만든다
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
