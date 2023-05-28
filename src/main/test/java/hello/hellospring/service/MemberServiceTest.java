package main.test.java.hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() { //DI.. 외부에서 MemberService에 생성자로 의존관계 주입하는 상황 => 같은 인스턴스를 쓸 수 있게 된다.(싱글턴)
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach //콜백 메소드라고 보면 된다.
    public void afterEach() {
        memberRepository.clearStore(); //테스트가 실행되고 끝날때 마다 저장소를 지우게 된다.
    }

    @Test //테스트 코드는 실제 product에 들어가지 않아서 한글로 하는 경우도 많다
    void 회원가입() {
        //테스트를 할 때 코드가 매우 길 때는 given, when, then 주석을 가지는 것으로도 도움이 많이 된다.
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//memberService.join(member2)를 실행하는데 IllegalStateExceiption 오류가 터져야 한다는 코드

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}