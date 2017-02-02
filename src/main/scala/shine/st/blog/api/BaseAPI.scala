package shine.st.blog.api

import akka.http.scaladsl.server.Route
import shine.st.blog.MainService
import shine.st.blog.protocol.{JsonHandler, JsonResponse, RESTfulResponse, Success, UnknownError}

import scala.concurrent.Future

/**
  * Created by shinest on 16/01/2017.
  */
trait BaseAPI {
  implicit def executor = MainService.executor

  def route: Route

  def success[T](t: T) = RESTfulResponse[T](Success, Option(t))

  def fail[T](jsonResponse: JsonResponse) = RESTfulResponse[T](jsonResponse, None)

  def futureSuccess[T](t: Future[T])(jsonResponse: JsonResponse = UnknownError("occur error")) = t.map(success).fallbackTo(Future(fail(jsonResponse)))

  def errorHandle(jsonResponse: JsonResponse) = JsonHandler.handle(jsonResponse)
}