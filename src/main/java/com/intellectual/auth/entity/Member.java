package com.intellectual.auth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.intellectual.auth.type.Gender;
import com.intellectual.auth.type.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
       private String loginId;

       @Column(nullable = false)
       private String password;

       @Column(nullable = false)
       private String name;

       @Column(nullable = false)
       private String phoneNumber;

       @Enumerated(EnumType.STRING)
       @Column(nullable = false)
       private Gender gender;

       @Enumerated(EnumType.STRING)
       @Column(nullable = false)
       private Role role;

       @Column(nullable = false)
       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
       private LocalDate joinDate;

       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
       private LocalDate leaveDate;
}
