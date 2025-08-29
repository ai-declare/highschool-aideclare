package com.aideclare.entities

import com.aideclare.entities.dsl.syntax.{fk, id}
import com.aideclare.entities.dsl.typeclasses.EntityMetadata

case class StudentGroup(@id id: Int,
                        name: String,
                        title: String,
                        academicYear: Int,
                        @fk[Professor] professorId: Int
                       )derives EntityMetadata
