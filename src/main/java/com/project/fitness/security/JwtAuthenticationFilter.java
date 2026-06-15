package com.project.fitness.security;

import com.project.fitness.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException{

        String authHeader=request.getHeader("Authorization");
        // Agar token nahi hai to request ko aage bhej do
        if (authHeader==null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        // Bearer hata ke actual token nikalo
        String token=authHeader.substring(7);
        //extract username from Token
        String username=jwtUtils.extractUserName(token);
        //load user from DB
        UserDetails userDetails= customUserDetailsService.loadUserByUsername(username);

        //check is token valid or not
        if(jwtUtils.isTokenValid(token,userDetails)){
            //mark user as authenticated
            UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
        }
        // Request ko controller tak jane do
        filterChain.doFilter(request,response);
    }
}
