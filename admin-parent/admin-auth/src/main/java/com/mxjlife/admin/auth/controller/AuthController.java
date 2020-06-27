package com.mxjlife.admin.auth.controller;

import com.mxjlife.admin.common.pojo.dto.HttpRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * description: 认证
 * author mxj
 * email mengxiangjie@hualala.com
 * date 2020/6/26 22:40
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public HttpRes login(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam(required = false) boolean rememberMe,
                         HttpServletRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        String jwt = jwtUtil.createJWT(authentication, rememberMe);
        return ApiResponse.ofSuccess(new JwtResponse(jwt));
    }

//    @PostMapping("/logout")
//    public ApiResponse logout(HttpServletRequest request) {
//        try {
//            // 设置JWT过期
//            jwtUtil.invalidateJWT(request);
//        } catch (SecurityException e) {
//            throw new SecurityException(Status.UNAUTHORIZED);
//        }
//        return ApiResponse.ofStatus(Status.LOGOUT);
//    }
}