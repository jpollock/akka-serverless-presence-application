package com.example.demo.presence

import com.akkaserverless.scalasdk.action.Action
import com.akkaserverless.scalasdk.testkit.ActionResult
import com.example.demo.presence.domain.Heartbeat
import com.example.demo.presence.domain.UserPresenceState
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class PresenceHeartbeatEventServiceActionSpec
    extends AnyWordSpec
    with Matchers {

  "PresenceHeartbeatEventServiceAction" must {

    "have example test that can be removed" in {
      val testKit = PresenceHeartbeatEventServiceActionTestKit(new PresenceHeartbeatEventServiceAction(_))
      // use the testkit to execute a command
      // and verify final updated state:
      // val result = testKit.someOperation(SomeRequest)
      // verify the response
      // result.reply shouldBe expectedReply
    }

    "handle command HeartbeatEvent" in {
      val testKit = PresenceHeartbeatEventServiceActionTestKit(new PresenceHeartbeatEventServiceAction(_))
      // val result = testKit.heartbeatEvent(Heartbeat(...))
    }

  }
}
