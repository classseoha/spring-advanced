package org.example.expert.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

//    @InjectMocks
//    private PasswordEncoder passwordEncoder;

    // PasswordEncoder는 외부 의존성이 없고, 별도로 Mocking할 필요가 없기 때문에 Mockito 없이 테스트 가능
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    void matches() {
        // given
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // when
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword); //위치 변경

        // then
        assertTrue(matches);
    }
}
