package study.data_jpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.data_jpa.entity.Member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberJpaRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        Member member = new Member("memberA");

        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId()).get();

        assertThat(findMember).isEqualTo(saveMember);
    }

}