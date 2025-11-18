package com.aideclare.library

import com.aideclare.entities.ExecutionSender
import com.aideclare.entities.dsl.adt.RestSystem
import com.aideclare.entities.dsl.syntax.ApiDsl


object LibraryGenerator extends App {

  val sender = ExecutionSender()

  sender.send(
    new LibraryApp[RestSystem, ApiDsl.Resources].highschoolSystem
  )

}
