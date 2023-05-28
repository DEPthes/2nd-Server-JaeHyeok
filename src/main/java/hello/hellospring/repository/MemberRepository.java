package main.java.hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { //멤버를 저장할 수 있는 구현체를 위한 인터페이스 생성
    Member save(Member member); // member 객체를 저장하는 save 메서드
    Optional<Member> findById(Long id); // Optional로 감싼 형태로 id로 회원 정보를 찾는 메서드
    Optional<Member> findByName(String name); // Optional로 감싼 형태로 name으로 회원 정보를 찾는 메서드
    List<Member> findAll(); // 모든 회원 정보를 찾아 List형태로 member 객체들을 반환하는 메서드
}
