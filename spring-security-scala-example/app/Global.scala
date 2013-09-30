import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.security.access.SecurityConfig
import play.api.{Logger, Application, GlobalSettings}

/**
 * Created with IntelliJ IDEA.
 * User: jamie
 * Date: 29/09/2013
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
object Global extends GlobalSettings {

  /**
   * Declare the application context to be used. AnnotationConfigApplicationContext cannot be refreshed so we can
   * only do this once. We tell the context what packages to scan and then to refresh itself.
   */
  val ctx = new AnnotationConfigApplicationContext
//  ctx.register(classOf[SecurityConfig])
  ctx.scan("security")
  ctx.refresh()


  /**
   * Sync the context lifecycle with Play's.
   * @param app
   */
  override def onStart(app: Application) {

    Logger.debug("[SpringSecurity] - Start");
    ctx.start()
  }

  /**
   * Sync the context lifecycle with Play's.
   * @param app
   */
  override def onStop(app: Application) {
    Logger.debug("[SpringSecurity] - Stop");
    ctx.stop()
  }

  /**
   * Controllers must be resolved through the application context. There is a special method of GlobalSettings
   * that we can override to resolve a given controller. This resolution is required by the Play router.
   * @param controllerClass
   * @tparam A
   * @return
   */
  override def getControllerInstance[A](controllerClass: Class[A]): A = ctx.getBean(controllerClass)
}
