package app.controller;

import app.service.JWTService;
import app.service.UserService;
import app.service.VerificationTokenService;
import app.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class BaseController {
    @Autowired
    protected UserService userService;
    @Autowired
    protected JWTService jwtService;
    @Autowired
    protected ReloadableResourceBundleMessageSource messageSource;
    @Autowired
    protected EmailUtils emailUtils;
    @Autowired
    protected VerificationTokenService verificationTokenService;


}
