package com.aideclare.entities

import com.aideclare.entities.dsl.syntax.{fk, id, password, username}
import com.aideclare.entities.dsl.typeclasses.{EntityMetadata, UserInfo}

import java.time.LocalDate

case class Student(@id studentId: Int,
                   @username email: String,
                   @password password: String,
                   name: String,
                   surname: String,
                   birthDate: LocalDate,
                   @fk[StudentGroup] groupId: Int
                  )derives EntityMetadata, UserInfo
