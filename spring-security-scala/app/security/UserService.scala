package security

import org.springframework.security.core.userdetails.UserDetailsService

/**
 * Created with IntelliJ IDEA.
 * User: jamie
 * Date: 28/09/2013
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
trait UserService {
  val userDetailsService: UserDetailsService
}
