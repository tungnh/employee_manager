package com.example.employee_manager_pr.security;

import com.example.employee_manager_pr.model.entity.Employee;
import com.example.employee_manager_pr.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = employeeRepository.findEmployeeByUserName(username);
        if(user==null){
            throw  new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);

    }
}
