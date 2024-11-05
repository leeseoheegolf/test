package com.lostay.backend.oauth2.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.lostay.backend.user.dto.UserDTO;


public class CustomOAuth2User implements OAuth2User {

    private final UserDTO userDTO;
    private final boolean isNewUser;

    public CustomOAuth2User(UserDTO userDTO, boolean isNewUser) {

        this.userDTO = userDTO;
		this.isNewUser = isNewUser;
    }

    @Override
    public Map<String, Object> getAttributes() {

        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return userDTO.getUserRole();
            }
        });

        return collection;
    }

    @Override
    public String getName() {

        return userDTO.getUserName();
    }
    
    public Long getUserNo() {
    	
    	return userDTO.getUserNo();
    }
    
    public boolean getIsNewUser() {
    	
    	return isNewUser;
    }
}
