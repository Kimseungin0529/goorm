package com.doong.test.order;

import com.doong.test.member.Member;
import com.doong.test.member.MemberRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class OrderTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EntityManager em;

        @Test
        @DisplayName("JPA가 제공하는 메서드를 통해 조회한다면 즉시 로딩이여도, N+1 문제는 발생하지 않는다.")
        void test(){
            //given
            Member member1 = new Member("승진1");
            Member member2 = new Member("승진2");

            Order order1 = new Order("상품1");
            Order order2 = new Order("상품2");
            Order order3 = new Order("상품3");
            order1.registerMember(member1);
            order2.registerMember(member1);
            order3.registerMember(member2);

            memberRepository.saveAll(List.of(member1, member2));
            em.flush();
            em.clear();

            //List<Member> findMembers = memberRepository.findAllMemberByJpqlFetchJoin();
            Page<Member> pageMembers = memberRepository.findAllMemberByJpqlFetchJoin(PageRequest.of(0, 3));
            for(Member member : pageMembers){
                System.out.println(member.getName() + "의 주문 개수 = " + member.getOrders().size());
            }

        }
    @Test
    @DisplayName("J2.")
    void test2(){
        //given
        Member member1 = new Member("승진1");
        Member member2 = new Member("승진2");

        Order order1 = new Order("상품1");
        Order order2 = new Order("상품2");
        Order order3 = new Order("상품3");
        order1.registerMember(member1);
        order2.registerMember(member1);
        order3.registerMember(member2);

        memberRepository.saveAll(List.of(member1, member2));
        em.flush();
        em.clear();

        List<Order> findOrders = orderRepository.findAllOrderByJpqlFetchJoin();
        for(Order order : findOrders){
            System.out.println(order.getName() + "의 member 이름 = " + order.getMember().getName());
        }

    }

}