package main.test.java.hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest { //테스트 두개 돌리기

    MemoryMemberRepository repository = new MemoryMemberRepository(); // MemoryMemberRepository 구현체(객체) 생성

    @AfterEach //콜백 메소드라고 보면 된다.
    public void afterEach() {
        repository.clearStore(); //테스트가 실행되고 끝날때 마다 저장소를 지우게 된다.
    }


    @Test //이 애노테이션이 연결 역할을 한다
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //옵셔널에서 값을 꺼낼 때 get()으로 꺼낼 수 있다. findById가 옵셔널리턴이므로 get()으로 값을 꺼냈다
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(result, member); // 정상 실행
//        Assertions.assertEquals(result, null); //exprected 값과 actual 값인 null이 다르다고 오류메시지 발생
        assertThat(member).isEqualTo(result); // static import로 좀 더 편리한 방식으로 리팩터링.기능은 위와 같다
    }


    @Test
    public void findByName() { //findByName 테스트
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1); //member1 객체를 repository의 store에 저장

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2); //member2 객체 저장 repository의 store에 저장

        Member result = repository.findByName("spring1").get(); //옵셔널로 리턴 받으므로 get사용해서 findByName 리턴값 result에 저장

        assertThat(result).isEqualTo(member1); //통과

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //member1, member2 객체를 respository 구현체의 store에 저장

        List<Member> result = repository.findAll(); //arraylist로 배열 리턴값 result에 저장

        assertThat(result.size()).isEqualTo(2); //저장된 ArryList값 2와 기댓값 2 같아서 통과
    }



}
