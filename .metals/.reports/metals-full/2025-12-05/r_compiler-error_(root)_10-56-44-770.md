file://<WORKSPACE>/src/main/scala/com/aideclare/airline/AirlineApp.scala
### java.lang.IndexOutOfBoundsException: -1

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 463
uri: file://<WORKSPACE>/src/main/scala/com/aideclare/airline/AirlineApp.scala
text:
```scala
package com.aideclare.airline

import com.aideclare.entities.dsl.adt.Endpoint
import com.aideclare.entities.dsl.syntax.*

class AirlineApp[System, Api[_]](using systemDsl: SystemDsl[System, Api], apiDsl: ApiDsl[Api]):

  import apiDsl.*
  import com.aideclare.entities.dsl.syntax.*
  import systemDsl.*

  def airlineSystem: System =
    // Rest system name declaration
    system("airline")
      .public[Company](
        api(Endpoint.ReadResourceEndpoints)./[]@@(

        )
    )
      .public[Flight](api(Endpoint.ReadResourceEndpoints))
      // /api/professor public API. endpoints: GET /api/professor, GET /api/professor/{id}
      .public[Professor](
        api[Professor](Endpoint.ReadResourceEndpoints)
          // /api/professor/{professorId}/studentgroup public API. endpoints: GET /api/professor/{professorId}/studentgroup,
          // GET /api/professor/{professorId}/studentgroup/{groupId}
          ./[StudentGroup](
            // /api/professor/{professorId}/studentgroup/{groupId}/student public API.
            // endpoints: GET /api/professor/{professorId}/studentgroup/{groupId}/student,
            // GET /api/professor/{professorId}/studentgroup/{groupId}/{groupId}/student/{studentId}
            api[StudentGroup](Endpoint.ReadResourceEndpoints)./[Student](api(Endpoint.ReadResourceEndpoints))
          )
      )
      // /api/student public API. endpoints: GET /api/student, GET /api/student/{id}
      .public[Student](api(Endpoint.ReadResourceEndpoints))
      // The following 4 APIs will allow Admin users to manage Professor, Student, StudentGroup and Admin entities
      // /api/professor public API. endpoints: GET /api/professor, GET /api/professor/{id}, POST /api/professor,
      // PUT /api/professor/{id}, DELETE PUT /api/professor/{id}
      .authenticated[Professor, Admin]
      // /api/student public API. endpoints: GET /api/student, GET /api/student/{id}, POST /api/student,
      // PUT /api/student/{id}, DELETE PUT /api/student/{id}
      .authenticated[Student, Admin]
      // /api/studentgroup public API. endpoints: GET /api/studentgroup, GET /api/studentgroup/{id}, POST /api/studentgroup,
      // PUT /api/studentgroup/{id}, DELETE PUT /api/studentgroup/{id}
      .authenticated[StudentGroup, Admin]
      // /api/admin public API. endpoints: GET /api/admin, GET /api/admin/{id}, POST /api/admin,
      // PUT /api/admin/{id}, DELETE PUT /api/admin/{id}
      .authenticated[Admin, Admin]
      // Declares an API that belongs to Professor users and allow to see modify their data
      // /api/me/professor, endpoints GET and PUT
      .me[Professor](
        api[Professor]
          // Endpoints to manage authenticated professor student groups
          // /api/me/professor/studentgroup, all endpoints are available (create, update, delete, list)
          ./[StudentGroup](
            // Endpoints to manage students that belong to an authenticated professor student group
            // /api/me/professor/studentgroup/{groupId}/student, all endpoints are available (create, update, delete, list)
            api[StudentGroup]./[Student]
          )
      )
```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:129)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:244)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:101)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:88)
	dotty.tools.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:46)
	dotty.tools.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:435)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: -1