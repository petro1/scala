package main.scala.Actors

import akka.actor._

class MessageActor(myName: String) extends Actor {
  def receive = {
    case "exit" => context.stop(self)
    case _ =>
      if (myName.length()>1) {
        println("hello from %s".format(myName))
      } else {
        println("huh?")
      }
  }
}
object MessageActor {
  def chat(userName:  String) = {
    val system = ActorSystem("MessageActor")
    val helloActor = system.actorOf(Props(new MessageActor(userName)), name = "helloactor")
    helloActor ! userName
  }
}
