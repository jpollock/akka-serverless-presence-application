package com.example.demo.presence

import com.akkaserverless.scalasdk.action.Action
import com.akkaserverless.scalasdk.action.ActionCreationContext
import com.example.demo.presence.domain.Heartbeat
import com.example.demo.presence.domain.UserPresenceState

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** An action. */
class PresenceHeartbeatEventServiceAction(creationContext: ActionCreationContext) extends AbstractPresenceHeartbeatEventServiceAction {

  /** Handler for "HeartbeatEvent". */
  override def heartbeatEvent(heartbeat: Heartbeat): Action.Effect[UserPresenceState] = {

    val heartbeatReply: Future[UserPresenceState] =
      for { 
        userPresenceState <- components.userPresence.togglePresence(heartbeat).execute()
      } yield userPresenceState
      
    effects.asyncReply(heartbeatReply)
  }
}

