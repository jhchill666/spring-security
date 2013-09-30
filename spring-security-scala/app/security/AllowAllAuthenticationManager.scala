package security

import org.springframework.security.authentication.{BadCredentialsException, UsernamePasswordAuthenticationToken, AuthenticationManager}
import org.springframework.security.core.Authentication

/**
 * Created with IntelliJ IDEA.
 * User: jamie
 * Date: 28/09/2013
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
class AllowAllAuthenticationManager (authorities : String*) extends AuthenticationManager {

  def authenticate(authentication: Authentication) = authentication match {
    case u : UsernamePasswordAuthenticationToken =>
      if (u.getPrincipal == u.getCredentials)
        new UsernamePasswordAuthenticationToken(u.getName, u.getName)
      else
        badCredentials()
    case _ => badCredentials()
  }

  def badCredentials() = {
    throw new BadCredentialsException("Bad Credentials")
  }
}
