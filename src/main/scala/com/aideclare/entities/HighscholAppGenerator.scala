package com.aideclare.entities

import com.aideclare.entities.dsl.adt.RestSystem
import com.aideclare.entities.dsl.syntax.ApiDsl

object HighscholAppGenerator extends App :

  val sender = ExecutionSender()
  sender.send(
    HighschoolApp.highschoolSystem
  )
