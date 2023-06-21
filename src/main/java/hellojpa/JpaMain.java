package main.java.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        try {
//            Member member = new Member();
//
//            member.setId(1L);
//            member.setName("HelloA");
//
//            em.persist(member);
            Member findMember = em.find(Member.class, 1L);

//            em.remove(); 삭제


//            findMember.setName("HelloJPA"); 수정. 저장하지 않아도 자동으로 저장됨 자바객체에서 값만 바꾸었는데 JPA가 관리하기 때문에 Update쿼리를 자동으로 날려서 저장이됨

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}
