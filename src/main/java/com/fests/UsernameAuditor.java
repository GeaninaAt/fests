package com.fests;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by gatomulesei on 2/27/2017.
 */
@Component
public class UsernameAuditor implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {
            return "non-authentication";
        }

        return authentication.getName();
    }
}