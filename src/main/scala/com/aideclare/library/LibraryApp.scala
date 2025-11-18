package com.aideclare.library

import com.aideclare.entities.dsl.adt.Endpoint
import com.aideclare.entities.dsl.syntax.*

class LibraryApp[System, Api[_]](using systemDsl: SystemDsl[System, Api], apiDsl: ApiDsl[Api]):

  import apiDsl.*
  import com.aideclare.entities.dsl.syntax.*
  import systemDsl.*

  def highschoolSystem: System =
    // Rest system name declaration
    system("library")
      // Declares a secured API to manage students, only Admin users will be able to operate it.
      // The path for this API will be /api/student
      .public[Book](
        api(endpoints = Endpoint.ReadResourceEndpoints)
      )
      .public[Author](
        api(endpoints = Endpoint.ReadResourceEndpoints)
      )
      // Declares a secured API to manage student groups, only Admin users will be able to operate it.
      // The path for this API will be /api/studentgroup
      .me[Author](
        // Declares a secured API to manage students that belong to a certain student group.
        // since it is a subAPI of /student only admin users will be able to operate it.
        // The path for this API will be /api/studentgroup/{groupId}/student
        api[Author]()./[Book](api())
      )
      .authenticated[Author, Admin]
      .authenticated[Book, Admin]
      .authenticated[Admin, Admin]

