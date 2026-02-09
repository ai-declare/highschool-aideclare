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
      .me[CompanyAdmin](
        api[CompanyAdmin]().->[Company](
            api[Company]()./[Flight](
                api[Flight]()./[Passenger](api[Passenger]())
            )
        )
      )
      .me[Customer](
        api[Customer]()./[Passenger](
            api[Passenger]
        )
      )
      .authenticated[Customer, Admin]
      .authenticated[CompanyAdmin, Admin]

    