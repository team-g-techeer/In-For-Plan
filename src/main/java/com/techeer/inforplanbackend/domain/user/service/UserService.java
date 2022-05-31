package com.techeer.inforplanbackend.domain.user.service;

import com.techeer.inforplanbackend.domain.user.domain.entity.Role;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import com.techeer.inforplanbackend.domain.user.dto.Mapper.UserMapper;
import com.techeer.inforplanbackend.domain.user.dto.Request.UserCreateRequestDto;
import com.techeer.inforplanbackend.domain.user.dto.Response.UserResponseDto;
import com.techeer.inforplanbackend.domain.user.repository.UserRepository;
import com.techeer.inforplanbackend.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.techeer.inforplanbackend.global.error.exception.ErrorCode.PASSWORD_ENCRYPTION_ERROR;

@Service
@RequiredArgsConstructor
@EnableWebSecurity
//@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public final UserMapper userMapper;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public PasswordEncoder encode;

    @Transactional
    public Users create(UserCreateRequestDto userRequestDto) {

        try {
            String password = encode.encode(userRequestDto.getPassword());
            userRequestDto.setPassword(password);
        }
        catch (Exception e){
            throw new BusinessException(PASSWORD_ENCRYPTION_ERROR);
        }

        return userRepository.save(userMapper.toEntity(userRequestDto));

    }

    @Transactional
    public UserResponseDto findById(Long id){
        Users user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        return userMapper.fromEntity(user);
    }


    @Transactional
    public UserDetails loadUserByEmail(String email) {
        Users user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));

        return new User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }

    @Transactional
    public Optional<Users> findByPw(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public Users authenticateByEmailAndPassword(String email, String password) {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        if(!encode.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Password not matched");
        }

        return user;
    }

}
