cd presence-user-state-scala
PORT=8080 sbt run &
cd ..

cd presence-heartbeats-java
PORT=8081 mvn compile exec:exec &
cd ..

cd presence-querying-python
if [ ! -d "penv" ] 
then
    virtualenv -p python3 penv  
    source penv/bin/activate
    pip install -r requirements.txt
    deactivate
fi
source penv/bin/activate
source compile.sh
PORT=8082 python3 index.py &
cd ..

docker-compose up -d