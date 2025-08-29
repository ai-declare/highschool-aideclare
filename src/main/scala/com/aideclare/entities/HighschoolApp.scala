package com.aideclare.entities

import com.aideclare.entities.dsl.syntax.*

class HighschoolApp[System, Api[_]](using systemDsl: SystemDsl[System, Api], apiDsl: ApiDsl[Api]) :

  import apiDsl.*
  import com.aideclare.entities.dsl.syntax.*
  import systemDsl.*

  def highschoolSystem: System =
    // Rest system name declaration
    system("highschool")
      // Declares a secured API to manage students, only Admin users will be able to operate it.
      // The path for this API will be /api/student
      .authenticated[Student, Admin]
      // Declares a secured API to manage student groups, only Admin users will be able to operate it.
      // The path for this API will be /api/studentgroup
      .authenticated[StudentGroup, Admin](
        // Declares a secured API to manage students that belong to a certain student group.
        // since it is a subAPI of /student only admin users will be able to operate it.
        // The path for this API will be /api/studentgroup/{groupId}/student
        api[StudentGroup]
          ./[Student]
      )
      // Declares a public API to manage professors, anyone will be able to operate it.
      // The path for this API will be /api/professor
      .public[Professor]


  private def professorAdminApis =
    api[Professor]
      ./(
        api[StudentGroup]
          ./[Student]
      )

