package main.scala

import main.scala.Actors.{FutureActor, MessageActor}

object Main extends App {

  var done = false
  while(!done) {
    println("What's your name? exit for quit")
    val name = readLine()
    MessageActor.chat(name)
    if (name == "exit") {
      done = true
      FutureActor.action
    }
  }
}
