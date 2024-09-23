package com.doong;

import com.doong.test.member.Member;
import com.doong.test.team.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Transactional
public class JpaTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("Member 조회 시, Team 객체 확인")
    void test1(){
      /*  //given
        Member member1 = new Member("승진", null);
        Member member2 = new Member("길동", null);
        Team team = new Team("새우깡");
        member1.addTeam(team);
        member2.addTeam(team);

        //when
        em.persist(member1);
        em.persist(member2);
        em.persist(team);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member1.getId());
        String teamTitle = findMember.getTeam().getTitle();

        //then
        assertThat(team.getMembers()).hasSize(2);
        assertThat(member1.getTeam()).isEqualTo(team);
        assertThat(member2.getTeam()).isEqualTo(team);
*/
    }

}
