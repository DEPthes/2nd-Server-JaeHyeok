package main.java.hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository; //회원 서비스를 만들기 위한 리포지토리

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증

        //원래 코드
        //memberRepository.findByName(member.getName())
        //      .ifPresent(m -> {
        //      throw new IllegalStateException("이미 존재하는 회원입니다.");
        //      });
        //result를 바로 ifPresent 한 것
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { // null이 아닌값이면 작동한다
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });


        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
