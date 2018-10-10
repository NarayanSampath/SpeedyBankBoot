package com.eg.speedybank.controller;

import com.eg.speedybank.response.dto.MenuResponseDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class MenuController {

    @RequestMapping("/menu")
    public List<MenuResponseDTO> getHomeMenu(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(checkAuth(authentication.getAuthorities(),"ROLE_ANONYMOUS")){
            List<MenuResponseDTO> homeMenu= new ArrayList<>();
            System.out.println(authentication.getAuthorities());
            homeMenu.add(new MenuResponseDTO("Home","/"));
            homeMenu.add(new MenuResponseDTO("Sign Up", "/signup"));
            homeMenu.add(new MenuResponseDTO("Sign In","/login"));
            homeMenu.add(new MenuResponseDTO("About","/about"));
            return homeMenu;
        }else if(checkAuth(authentication.getAuthorities(),"ROLE_ADMIN")){
            List<MenuResponseDTO> adminMenu= new ArrayList<>();
            adminMenu.add(new MenuResponseDTO("Home","/dashboard"));
            adminMenu.add(new MenuResponseDTO("Authorities","/authority"));
            adminMenu.add(new MenuResponseDTO("Permissions","/permission"));
            adminMenu.add(new MenuResponseDTO("Users","/user"));
            adminMenu.add(new MenuResponseDTO("Logout","/logout"));
            adminMenu.add(new MenuResponseDTO("Profile","/profile"));
            return adminMenu;
        }else{
            List<MenuResponseDTO> userMenu = new ArrayList();
            userMenu.add(new MenuResponseDTO("Home","/dashboard"));
            userMenu.add(new MenuResponseDTO("Funds","/fund"));
            userMenu.add(new MenuResponseDTO("Loan","/loan"));
            userMenu.add(new MenuResponseDTO("Logout","/logout"));
            userMenu.add(new MenuResponseDTO("Profile","/profile"));
            userMenu.add(new MenuResponseDTO("Account","/account"));
            return userMenu;
        }
    }

    private boolean checkAuth(Collection<? extends GrantedAuthority> authorities, String authority){
        return authorities.stream()
                          .filter(auth -> ((GrantedAuthority) auth)
                          .getAuthority()
                          .equalsIgnoreCase(authority))
                          .findAny().isPresent();
    }
}
