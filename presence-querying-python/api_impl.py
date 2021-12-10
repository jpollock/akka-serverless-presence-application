"""
Copyright 2020 Lightbend Inc.
Licensed under the Apache License, Version 2.0.
"""
# imports fom Akka Serverless SDK
from akkaserverless.view import View

# imports fom Python generated code
from api_spec_pb2 import (_PRESENCEQUERYAPI, DESCRIPTOR as FILE_DESCRIPTOR)

view = View(_PRESENCEQUERYAPI,[FILE_DESCRIPTOR])