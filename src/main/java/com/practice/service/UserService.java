package com.practice.service;

import com.practice.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    private UserDao userDao;

    public boolean userCheck(String userName, String password) {
        return userDao.userCheck(userName, password);
    }

    public int getMatchCount(String userName, String password){
        return userDao.getMatchCount(userName, password);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService(String username, String password) {
//        if (userDao.userCheck(username, password)) {
//
//        }
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
