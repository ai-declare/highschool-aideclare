package com.aideclare.entities

import com.aideclare.entities.dsl.syntax.*
import com.aideclare.entities.dsl.typeclasses.{EntityMetadata, UserInfo}

case class Admin(
                  @id @username username: String,
                  @password password: String,
                  email: String
                )derives EntityMetadata, UserInfo
