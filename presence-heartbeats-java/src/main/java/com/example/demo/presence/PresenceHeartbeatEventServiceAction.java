package com.example.demo.presence;

import java.util.concurrent.CompletionStage;
import com.google.protobuf.Empty;

import com.akkaserverless.javasdk.DeferredCall;
import com.akkaserverless.javasdk.SideEffect;
import com.akkaserverless.javasdk.action.ActionCreationContext;
import com.example.demo.presence.domain.UserPresenceDomain;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** An action. */
public class PresenceHeartbeatEventServiceAction extends AbstractPresenceHeartbeatEventServiceAction {

  public PresenceHeartbeatEventServiceAction(ActionCreationContext creationContext) {}

  /** Handler for "HeartbeatEvent". */
  @Override
  public Effect<UserPresenceDomain.Heartbeat> heartbeatEvent(UserPresenceApi.PresenceHeartbeatCommand presenceHeartbeatCommand) {
    CompletionStage<UserPresenceDomain.Heartbeat> heartbeatDone =
        components().userPresenceHeartbeat().heartbeat(presenceHeartbeatCommand)
            .execute();            
    
    CompletionStage<Effect<UserPresenceDomain.Heartbeat>> effect = heartbeatDone.thenApply(heartbeat -> {
      System.out.println("HeartbeatEvent: " + heartbeat);

      if (heartbeat.getIsModified()) {
        DeferredCall<UserPresenceDomain.Heartbeat, UserPresenceDomain.Heartbeat> call =
            components().presenceHeartbeatEventServiceAction().heartbeatEventToKafka(heartbeat); 
        return effects().forward(call);
      } else {
        return effects().reply(heartbeat);
      }
      
    });
    System.out.println("Heartbeat Effect: " + effect);
    return effects().asyncEffect(effect);

  }

  /** Handler for "HeartbeatEventToKafka". */
  @Override
  public Effect<UserPresenceDomain.Heartbeat> heartbeatEventToKafka(UserPresenceDomain.Heartbeat heartbeat) {
    System.out.println("HeartbeatEventToKafka: " + heartbeat);
    return effects().reply(heartbeat);
  
  }
}
