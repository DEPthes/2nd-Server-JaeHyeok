package main.java.hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{ //MemberRepository의 메모리 구현체에 MemberRepository 인터페이스 implements

    private static Map<Long, Member> store = new HashMap<>();  //HashMap 자료형으로 저장소 store 생성
    private static long sequence = 0L; // 시퀀스 변수 생성

    @Override
    public Member save(Member member) { // save를 오버라이딩
        member.setId(++sequence); // 파라미터로 입력된 member 객체의 Id 설정
        store.put(member.getId(), member); // HashMap 구조의 store 저장소에 멤버의 id와 멤버객체 저장
        return member; //객체 리턴
    }

    @Override
    public Optional<Member> findById(Long id) {// HashMap 형태인 store에서 get으로 id검색 후 리턴 값을 옵셔널로 씌워서 리턴(해시맵이 Long, Member 이므로 Member 객체가 리턴된다)
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) { //name을 입력받아서 람다 문법으로 비교해서 입력된 name과 같은 이름의 name 찾아 리턴
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    } // store의 모든 value들을 배열형태로 리턴


    public void clearStore() {
        store.clear();
    }
}

