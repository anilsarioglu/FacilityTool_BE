package edu.ap.facilitytoolspringboot.security.oauth2.user;




import edu.ap.facilitytoolspringboot.exception.OAuth2AuthenticationProcessingException;
import edu.ap.facilitytoolspringboot.models.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.azure.toString())) {
            return new AzureOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
