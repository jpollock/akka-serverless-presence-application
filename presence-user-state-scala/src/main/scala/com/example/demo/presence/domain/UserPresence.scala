package com.example.demo.presence.domain

import com.akkaserverless.scalasdk.valueentity.ValueEntity
import com.akkaserverless.scalasdk.valueentity.ValueEntityContext
import com.example.demo.presence

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** A value entity. */
class UserPresence(context: ValueEntityContext) extends AbstractUserPresence {
  override def emptyState: UserPresenceState = UserPresenceState()

  override def togglePresence(currentState: UserPresenceState, heartbeat: Heartbeat): ValueEntity.Effect[UserPresenceState] = {
    val newState = currentState.copy(userId = heartbeat.userId, 
      deviceId = heartbeat.deviceId, 
      isOnline = heartbeat.isOnline,
      profile = heartbeat.profile)
    
    effects
      .updateState(newState) 
      .thenReply(newState) 
  }

  override def getCurrentUserPresence(currentState: UserPresenceState, getUserPresenceCommand: presence.GetUserPresenceCommand): ValueEntity.Effect[UserPresenceState] =  {
    if (currentState.userId == "" && currentState.deviceId == "") {
       effects.error(s"User ${getUserPresenceCommand.userId} and Device ${getUserPresenceCommand.deviceId} have not had any heartbeats yet.")
    } else if (currentState.deviceId == ""){
      effects.error(s"User ${getUserPresenceCommand.userId} and Device ${getUserPresenceCommand.deviceId} have not had any heartbeats yet.")
    } else {
      effects.reply(currentState)
    }
      
  }
    

}

