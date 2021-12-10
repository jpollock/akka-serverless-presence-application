package com.example.demo.presence.domain;

import com.akkaserverless.javasdk.replicatedentity.ReplicatedEntityContext;
import com.akkaserverless.javasdk.replicatedentity.ReplicatedRegister;
import com.example.demo.presence.UserPresenceApi;
import com.google.protobuf.Empty;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** A replicated entity. */
public class UserPresenceHeartbeat extends AbstractUserPresenceHeartbeat {
  @SuppressWarnings("unused")
  private final String entityId;

  public UserPresenceHeartbeat(ReplicatedEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public UserPresenceDomain.Heartbeat emptyValue() {
    return UserPresenceDomain.Heartbeat.getDefaultInstance();
  }

  @Override
  public Effect<UserPresenceDomain.Heartbeat> heartbeat(ReplicatedRegister<UserPresenceDomain.Heartbeat> currentData, UserPresenceApi.PresenceHeartbeatCommand presenceHeartbeatCommand) {
    System.out.println("UserPresenceHeartbeat.heartbeat.state: " + currentData);
    UserPresenceDomain.Heartbeat currentHeartbeat = currentData.get(); 
    
    boolean isModified = true;
    if (currentHeartbeat.getIsOnline() == presenceHeartbeatCommand.getIsOnline()) {
      isModified = false;
    } 
    UserPresenceDomain.Heartbeat newValue = 
      UserPresenceDomain.Heartbeat.newBuilder()
        .setUserId(presenceHeartbeatCommand.getUserId())
        .setDeviceId(presenceHeartbeatCommand.getDeviceId())
        .setIsOnline(presenceHeartbeatCommand.getIsOnline())
        .setProfile(presenceHeartbeatCommand.getProfile())
        .setIsModified(isModified)
        .build();
    System.out.println("UserPresenceHeartbeat.heartbeat: " + newValue);
    return effects()
      .update(currentData.set(newValue)) 
      .thenReply(newValue);  
    
  }
}
