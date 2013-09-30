package security

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.security.core.userdetails.{User, UserDetailsService}
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import java.util.Arrays

import org.springframework.security.authentication.{DefaultAuthenticationEventPublisher, ProviderManager}

import security.web.WebAccessRules._
import security.web._

/**
 * Created with IntelliJ IDEA.
 * User: jamie
 * Date: 29/09/2013
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
@Configuration
class SecurityConfig {


  @Bean
  def simpleFormLoginChain =
    new FilterChain with FormLogin with Logout with RememberMe with LoginPageGenerator {
      val authenticationManager = testAuthenticationManager
      val userDetailsService = testUserDetailsService
      interceptUrl("/**", hasRole("ROLE_USER"))
    }


  /**
   * Simple AuthenticationManager setup for testing.
   */
  @Bean
  def testAuthenticationManager = {
    val provider = new DaoAuthenticationProvider
    provider.setUserDetailsService(testUserDetailsService)
    val am = new ProviderManager(Arrays.asList(provider))
    am.setAuthenticationEventPublisher(authenticationEventPublisher)
    am
  }

  @Bean
  def authenticationEventPublisher = new DefaultAuthenticationEventPublisher

  /**
   * Test UserDetailsService which accepts any username and returns a user object which has a password equal to the
   * username and which is assigned the single authority "ROLE_USER".
   */
  @Bean
  def testUserDetailsService = {
    import security.Conversions._

    new UserDetailsService {
      def loadUserByUsername(username: String) = new User(username, username, "ROLE_USER")
    }
  }

}
