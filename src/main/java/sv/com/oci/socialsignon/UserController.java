package sv.com.oci.socialsignon;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    @GetMapping
    public Map<String, Object> getUserName(@AuthenticationPrincipal OAuth2User principal)
    {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @GetMapping("/all")
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal OAuth2User principal)
    {
        return principal.getAttributes();
    }
}
