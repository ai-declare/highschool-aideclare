package com.aideclare.entities

import com.aideclare.entities.dsl.adt.{Endpoint, RestSystem}
import com.aideclare.entities.dsl.gadt.*

object HighschoolApp:


  val highschoolSystem: System =
    // Rest system name declaration
    System("highschool")
      // The following 4 APIs will allow Admin users to manage Professor, Student, StudentGroup and Admin entities
      // /api/professor public API. endpoints: GET /api/professor, GET /api/professor/{id}, POST /api/professor,
      // PUT /api/professor/{id}, DELETE PUT /api/professor/{id}
      .addAuthenticatedApi[Professor, Admin]()
      // /api/student public API. endpoints: GET /api/student, GET /api/student/{id}, POST /api/student,
      // PUT /api/student/{id}, DELETE PUT /api/student/{id}
      .addAuthenticatedApi[Student, Admin]()
      // /api/studentgroup public API. endpoints: GET /api/studentgroup, GET /api/studentgroup/{id}, POST /api/studentgroup,
      // PUT /api/studentgroup/{id}, DELETE PUT /api/studentgroup/{id}
      .addAuthenticatedApi[StudentGroup, Admin]()
      // /api/admin public API. endpoints: GET /api/admin, GET /api/admin/{id}, POST /api/admin,
      // PUT /api/admin/{id}, DELETE PUT /api/admin/{id}
      .addAuthenticatedApi[Admin, Admin]()
      // Declares an API that belongs to Professor users and allow to see modify their data
      // /api/me/professor, endpoints GET and PUT
      .addMeApi[Professor](
        singleResourceApi[Professor]
          // Endpoints to manage authenticated professor student groups
          // /api/me/professor/studentgroup, all endpoints are available (create, update, delete, list)
          ./[StudentGroup](
            // Endpoints to manage students that belong to an authenticated professor student group
            // /api/me/professor/studentgroup/{groupId}/student, all endpoints are available (create, update, delete, list)
            api[StudentGroup]./[Student]
          )
      )
      .addMeApi[Student]()