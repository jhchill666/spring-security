package security

import org.springframework.context.{ApplicationEvent, ApplicationEventPublisher, ApplicationEventPublisherAware}

/**
 * Created with IntelliJ IDEA.
 * User: jamie
 * Date: 28/09/2013
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
private[security] trait EventPublisher extends ApplicationEventPublisherAware {

  var delegate: Option[ApplicationEventPublisher] = None

  val eventPublisher = new ApplicationEventPublisher {
    def publishEvent(a: ApplicationEvent) {
      delegate match {
        case Some(p) => p.publishEvent(a)
        case None =>
      }
    }
  }

  def setApplicationEventPublisher(publisher: ApplicationEventPublisher) {
    delegate = Some(publisher)
  }
}
