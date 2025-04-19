package org.example.expert.domain.user.dto.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {

    @NotBlank
    private String oldPassword;
    @NotBlank
    private String newPassword;

    // 비밀번호 검증 코드 추가-
    @AssertTrue(message = "새 비밀번호는 8자 이상이어야 하고, 숫자와 대문자를 포함해야 합니다.")
    public boolean isValidNewPassword() {
        return newPassword != null && // 새비밀번호가 null인지 확인
                newPassword.length() >= 8 && // 비밀번호 길이 최소 8자 이상
                newPassword.matches(".*\\d.*") && // 비밀번호 안에 숫자 하나 이상 포함 >> .*은 아무 문자든 0개 이상을 의미(전체 문자열 중 어느 위치에든 숫자 하나 이상 있으면 ok)
                newPassword.matches(".*[A-Z].*"); // 비밀번호 안에 대문자 알파벳 하나 이상 포함
    }
}
