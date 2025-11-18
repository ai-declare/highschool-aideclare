package com.aideclare.library

import com.aideclare.entities.dsl.adt.Entity
import com.aideclare.entities.dsl.syntax.{fk, id}
import com.aideclare.entities.dsl.typeclasses.EntityMetadata

case class Book(
                 @id isbn: String,
                 title: String,
                 @fk[Author] autthorId: Int)derives EntityMetadata
