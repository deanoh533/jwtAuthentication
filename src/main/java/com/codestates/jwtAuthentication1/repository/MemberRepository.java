package com.codestates.jwtAuthentication1.repository;

import com.codestates.jwtAuthentication1.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findByUsername(String member);
}

