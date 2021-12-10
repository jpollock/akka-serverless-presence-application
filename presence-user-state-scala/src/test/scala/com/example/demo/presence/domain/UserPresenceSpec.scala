package com.example.demo.presence.domain

import com.akkaserverless.scalasdk.testkit.ValueEntityResult
import com.akkaserverless.scalasdk.valueentity.ValueEntity
import com.example.demo.presence
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class UserPresenceSpec
    extends AnyWordSpec
    with Matchers {

  "UserPresence" must {

    "have example test that can be removed" in {
      val testKit = UserPresenceTestKit(new UserPresence(_))
      // use the testkit to execute a command
      // and verify final updated state:
      // val result = testKit.someOperation(SomeRequest)
      // verify the response
      // val actualResponse = result.getReply()
      // actualResponse shouldBe expectedResponse
      // verify the final state after the command
      // testKit.currentState() shouldBe expectedState
    }

    "handle command TogglePresence" in {
      val testKit = UserPresenceTestKit(new UserPresence(_))
      // val result = testKit.togglePresence(Heartbeat(...))
    }

    "handle command GetCurrentUserPresence" in {
      val testKit = UserPresenceTestKit(new UserPresence(_))
      // val result = testKit.getCurrentUserPresence(presence.GetUserPresenceCommand(...))
    }

  }
}
