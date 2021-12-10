FROM python:3.9.6-slim

RUN apt-get update
RUN apt-get install -y curl zip 

WORKDIR /app
COPY ./ ./
RUN pip install -r requirements.txt

ENV PYTHONPATH=/app
ENTRYPOINT python ./api_service.py

