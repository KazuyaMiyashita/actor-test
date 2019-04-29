package example

import akka.actor.Actor

class MyActor extends Actor {
  def receive = {
    case "Hello" => println("World!")
    case "Error" => throw new Exception()
    case _ => ()
  }
}
