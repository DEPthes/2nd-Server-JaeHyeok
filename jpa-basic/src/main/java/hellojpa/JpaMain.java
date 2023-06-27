package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {

            //저장
            Team team = new Team();

            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member2");

            team.add(member); //새로 만든 팀 객체에 멤버를 추가하려고 한다.

            em.persist(member);

            em.flush();
            em.clear();

            List<Member> members = team.getMembers();
            System.out.println("members = " + members);  //Team 클래스의 배열 저장 코드가 없으면 null


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
