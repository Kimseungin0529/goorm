package com.doong.test.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.memberId = :memberId")
    Optional<Member> findMemberByJpql(@Param("memberId") Long memberId);

    @Query("select m from Member m")
    List<Member> findAllMemberByJpql();
    @Query("select distinct m from Member m join fetch m.orders ")
    List<Member> findAllMemberByJpqlFetchJoin();

    @Query("select distinct m from Member m join fetch m.orders ")
    Page<Member> findAllMemberByJpqlFetchJoin(Pageable pageable);
}
