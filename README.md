Spike result putting together some technologies

# Tech stack
* Spring 5.x + Spring data jpa
* [Spark-java](https://github.com/perwendel/spark)
* [Jjwt](https://github.com/jwtk/jjwt)

# Quickstart
* run the application
```
mvn clean compile exec:java
```
* do a login
```
curl -X POST -H "Content-Type: application/json"  -d '{
	"username":"c.nolan",
	"password" : "batman"
}' "http://localhost:4567/login"
```

* try to get user rents (**Use token returning from login call**)
```
curl -X GET -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjLm5vbGFuIn0.55Zkp2ZjaZAHCS51j601UpVrDtOzwXO0_28BBqATeLU"  "http://localhost:4567/private/rents"
```
