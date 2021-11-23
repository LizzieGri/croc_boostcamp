package com.elections.croc.elections_mysql.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    protected Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public MySimpleUrlAuthenticationSuccessHandler() {
        super();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {

        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            logger.debug(
                    "Response has already been committed. Unable to redirect to "
                            + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(final Authentication authentication) {

        Map<String, String> roleTargetUrlMap = new HashMap<>();
        roleTargetUrlMap.put("ROLE_smotr", "/tiks");
        roleTargetUrlMap.put("ROLE_tv", "/votes-info");
        roleTargetUrlMap.put("ROLE_dobavCand", "/votes_for_candidates");
        roleTargetUrlMap.put("ROLE_uik1383", "/update-information-station/1383");
        roleTargetUrlMap.put("ROLE_uik1386", "/update-information-station/1386");
        roleTargetUrlMap.put("ROLE_uik1388", "/update-information-station/1388");
        roleTargetUrlMap.put("ROLE_uik1390", "/update-information-station/1390");
        roleTargetUrlMap.put("ROLE_uik1392", "/update-information-station/1392");
        roleTargetUrlMap.put("ROLE_uik1460", "/update-information-station/1460");
        roleTargetUrlMap.put("ROLE_uik1461", "/update-information-station/1461");
        roleTargetUrlMap.put("ROLE_uik1462", "/update-information-station/1462");
        roleTargetUrlMap.put("ROLE_uik1463", "/update-information-station/1463");
        roleTargetUrlMap.put("ROLE_uik1464", "/update-information-station/1464");
        roleTargetUrlMap.put("ROLE_uik2914", "/update-information-station/2914");
        roleTargetUrlMap.put("ROLE_uik2915", "/update-information-station/2915");
        roleTargetUrlMap.put("ROLE_uik2916", "/update-information-station/2916");
        roleTargetUrlMap.put("ROLE_uik2917", "/update-information-station/2917");
        roleTargetUrlMap.put("ROLE_uik2918", "/update-information-station/2918");
        roleTargetUrlMap.put("ROLE_uik1549", "/update-information-station/1549");
        roleTargetUrlMap.put("ROLE_uik1550", "/update-information-station/1550");
        roleTargetUrlMap.put("ROLE_uik1551", "/update-information-station/1551");
        roleTargetUrlMap.put("ROLE_uik1552", "/update-information-station/1552");
        roleTargetUrlMap.put("ROLE_uik1553", "/update-information-station/1553");
        roleTargetUrlMap.put("ROLE_uik2964", "/update-information-station/2964");
        roleTargetUrlMap.put("ROLE_uik2965", "/update-information-station/2965");
        roleTargetUrlMap.put("ROLE_uik2966", "/update-information-station/2966");
        roleTargetUrlMap.put("ROLE_uik2967", "/update-information-station/2967");
        roleTargetUrlMap.put("ROLE_uik2968", "/update-information-station/2968");

        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {

            String authorityName = grantedAuthority.getAuthority();
            if(roleTargetUrlMap.containsKey(authorityName)) {
                return roleTargetUrlMap.get(authorityName);
            }
        }

        throw new IllegalStateException();
    }

    protected final void clearAuthenticationAttributes(final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
