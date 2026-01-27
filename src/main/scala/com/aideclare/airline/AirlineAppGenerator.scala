package com.aideclare.airline

import com.aideclare.entities.dsl.adt.RestSystem
import com.aideclare.entities.dsl.syntax.ApiDsl
import com.aideclare.entities.ExecutionSender

object AirlineAppGenerator extends App :
    val sender = ExecutionSender()
    sender.send(
        new AirlineApp[RestSystem, ApiDsl.Resources].airlineSystem
    )
