package app.jwt;

import app.dao.UserDAO;
import app.model.User;
import app.service.JWTService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    private final static String TOKEN_HEADER = "authorization";

    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader(TOKEN_HEADER);
        if (jwtService.validateTokenLogin(authToken)) {
            String username = jwtService.getUsernameFromToken(authToken);
            User user = userDAO.loadUserByUserName(username);
            if (user != null) {
                UserDetails userDetail = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthorities(user));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,
                        null, userDetail.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }

    private List<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return authorities;
    }
}
