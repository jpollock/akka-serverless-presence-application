from kafka import KafkaProducer
from kafka.errors import KafkaError
from pyjavaproperties import Properties
import argparse, sys, logging

from api_spec_pb2 import (UserPresenceState)


class KafkaMessageGenerator:
    def __init__(self):
        p = Properties()
        p.load(open('../conf/kafka.properties'))
        self.producer = KafkaProducer(bootstrap_servers=[p['bootstrap.servers.local']])
        print(self.producer.bootstrap_connected())

    def publish(self, topic, command):
        headers = [("ce-type",b"com.example.demo.presence.domain.UserPresenceState"),("ce-specversion",b"1.0"),("ce-datacontenttype",b"application/protobuf")]
        future = self.producer.send(topic, value=command.SerializeToString(), headers=headers)

        try:
            record_metadata = future.get(timeout=10)
        except KafkaError as e:
            # Decide what to do if produce request failed...
            print(e)
            logging.error(e)
                
def main() -> int:
    parser = argparse.ArgumentParser(description='Kafka Message Generator information')

    parser.add_argument('--user_id', dest='user_id', type=str, help='Id of the turkey')
    parser.add_argument('--device_id', dest='device_id', type=str, help='Temp increase')
    parser.add_argument('--is_online', dest='is_online', type=bool, help='Temp increase')
    args = parser.parse_args()
    
    profile = {"attr1": "value1", "attr2": "value2"}

    kmg = KafkaMessageGenerator()
    user_presence_command = UserPresenceState(user_id=(args.user_id).encode('utf-8'), device_id=(args.device_id).encode('utf-8'), is_online=args.is_online, profile=profile)
    topic = 'users'
    kmg.publish(topic, user_presence_command)

if __name__ == '__main__':
    sys.exit(main()) 

