package com.example.demo.presence;

import akka.stream.javadsl.Source;
import com.akkaserverless.javasdk.testkit.ActionResult;
import com.example.demo.presence.PresenceHeartbeatEventServiceAction;
import com.example.demo.presence.PresenceHeartbeatEventServiceActionTestKit;
import com.example.demo.presence.UserPresenceApi;
import com.example.demo.presence.domain.UserPresenceDomain;
import org.junit.Test;
import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class PresenceHeartbeatEventServiceActionTest {

  @Test
  public void exampleTest() {
    PresenceHeartbeatEventServiceActionTestKit testKit = PresenceHeartbeatEventServiceActionTestKit.of(PresenceHeartbeatEventServiceAction::new);
    // use the testkit to execute a command
    // ActionResult<SomeResponse> result = testKit.someOperation(SomeRequest);
    // verify the response
    // SomeResponse actualResponse = result.getReply();
    // assertEquals(expectedResponse, actualResponse);
  }

  @Test
  public void heartbeatEventTest() {
    PresenceHeartbeatEventServiceActionTestKit testKit = PresenceHeartbeatEventServiceActionTestKit.of(PresenceHeartbeatEventServiceAction::new);
    // ActionResult<UserPresenceDomain.Heartbeat> result = testKit.heartbeatEvent(UserPresenceApi.PresenceHeartbeatCommand.newBuilder()...build());
  }

}
