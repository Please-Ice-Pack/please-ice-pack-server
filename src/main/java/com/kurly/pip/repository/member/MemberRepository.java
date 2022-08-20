package com.kurly.pip.repository.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsByIdentification(String identification);

    Optional<Member> findByIdentification(String identification);
}
