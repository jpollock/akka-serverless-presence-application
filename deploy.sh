cd presence-heartbeats-java
mvn -Ddocker.username=$DOCKER_USER -Ddocker.password=$DOCKER_PASS deploy
akkasls -q services deploy presence-heartbeats-java $DOCKER_REGISTRY/$DOCKER_USER/presence-heartbeats-java:latest
akkasls -q services expose presence-heartbeats-java
cd ..

cd presence-user-state-scala
sbt -Ddocker.username=$DOCKER_USER -Ddocker.password=$DOCKER_PASS docker:publishLocal
akkasls -q services deploy presence-user-state-scala $DOCKER_REGISTRY/$DOCKER_USER/presence-user-state-scala:latest
akkasls -q services expose presence-user-state-scala
cd ..

cd presence-querying-python
docker_build.sh latest
docker_push.sh latest
akkasls -q services deploy presence-querying-python $DOCKER_REGISTRY/$DOCKER_USER/presence-querying-python:latest
akkasls -q services expose presence-querying-python
cd ..
