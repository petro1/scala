package main.scala.Actors

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureActor {
  def action = {
    // used by 'time' method
    implicit val baseTime = System.currentTimeMillis

    // 2 - create a Future
    val f = Future {
      Thread.sleep(500)
      "Ended"
    }

    // 3 - this is blocking (blocking is bad)
    val result = Await.result(f, 1 second)
    println(result)
    Thread.sleep(1000)
  }
}
