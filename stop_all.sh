docker-compose down
kill -9 $(lsof -ti :8080)
kill -9 $(lsof -ti :8081)
kill -9 $(lsof -ti :8082)