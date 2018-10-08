package com.paracel.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paracel.dao.RoleDao;
import com.paracel.dao.UserDao;
import com.paracel.dao.UserRepository;
import com.paracel.dao.UserRoleRepository;
import com.paracel.entity.Role;
import com.paracel.entity.UserRole;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserDao userDao;
 
    @Autowired
    private RoleDao roleDao;
    
    @Autowired
    private UserRoleRepository userRoleDao;
    
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.paracel.entity.User user = userDao.getByUserName(userName);
 
        if (user == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + user);
 
        // [ROLE_USER, ROLE_ADMIN,..]
//        List<Role> roleNames = roleDao.getRoleNames(user.getUserId());
// 
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (roleNames != null) {
//            for (Role role : roleNames) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
//                grantList.add(authority);
//            }
//        }
        
        List<UserRole> roleNames = userRoleDao.findAllRoleIdInUserRole(user.getUserId());
        
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (UserRole role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole().getRoleName());
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(user.getUserName(), user.getEncrytedPassword(), grantList);
 
        return userDetails;
    }
 
    
}