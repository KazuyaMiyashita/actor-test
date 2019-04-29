package example

import akka.actor.{ActorSystem, Props}
import scala.io.StdIn.readLine

object Hello extends App {

  val system = ActorSystem()
  val actor = system.actorOf(Props[MyActor])

  @scala.annotation.tailrec
  def loop(): Unit = readLine match {
    case x if x == null || x == "" => {
      println("Bye!")
      system.terminate()
    }
    case str => {
      actor ! str
      loop()
    }
  }

  loop()

}
