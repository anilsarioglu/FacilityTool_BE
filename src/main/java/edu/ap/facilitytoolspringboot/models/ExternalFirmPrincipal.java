package edu.ap.facilitytoolspringboot.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExternalFirmPrincipal implements OAuth2User, UserDetails {
    private String id;
    private String name;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public ExternalFirmPrincipal(String id, String name, String email,  Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.authorities = authorities;
    }



    public static ExternalFirmPrincipal create(ExternalFirm externalFirms) {
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("Role_externalFirm"));
        return new ExternalFirmPrincipal(
                externalFirms.getId(),
                externalFirms.getCompanyName(),
                externalFirms.getMail(),
                authorities
                );
    }

    public static ExternalFirmPrincipal create(ExternalFirm externalFirms, Map<String, Object> attributes) {
        ExternalFirmPrincipal userPrincipal = ExternalFirmPrincipal.create(externalFirms);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    public String getId() {
        return id;
    }



    public String getEmail() {
        return email;
    }



    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }
}
