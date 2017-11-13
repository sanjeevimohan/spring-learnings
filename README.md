# spring-learnings
# GRADLE
./gradlew build
./gradlew applications/ums:build
./gradlew applications/billing:build
./gradlew applications/ums:bootRun
./gradlew applications/billing:bootRun

# CF
cf push ums --random-route -p applications/ums/build/libs/ums-0.0.1-SNAPSHOT.jar
cf push billing --random-route -p applications/billing/build/libs/billing-0.0.1-SNAPSHOT.jar


cf push ums -p applications/ums/build/libs/ums-0.0.1-SNAPSHOT.jar —no-start
cf push billing -p applications/billing/build/libs/billing-0.0.1-SNAPSHOT.jar


cf create-service p-service-registry standard service-registry
cf service service-registry
cf bind-service ums service-registry
cf restart ums
cf bind-service billing service-registry
cf restart billing

cf create-service p-circuit-breaker-dashboard standard circuit-breaker-dashboard
cf bind-service ums circuit-breaker-dashboard
cf bind-service billing circuit-breaker-dashboard

cf bind-service ums config-server
cf bind-service billing config-server

cf create-service p-rabbitmq standard rabbitmq
cf bind-service ums rabbitmq
cf bind-service billing rabbitmq

cf delete-orphaned-routes

cf scale ums -m 1G

a	app
s	service
m	marketplace
r	route

st	start
sp	stop
rs	restart
rg	restage
cs	create service
bs	bind service
us	unbind service


# CURL
curl -i -H "Content-Type:application/json" -d '{"userId":"user-123", "packageId":"package-123"}' ums-intermarine-ductility.apps.cumuluslabs.io/subscriptions
curl -i ums-intermarine-ductility.apps.cumuluslabs.io/subscriptions

curl -i -H "Content-Type:application/json" -d '{"userId":"user-123", "packageId":"package-123"}' localhost:8080/subscriptions
curl -i localhost:8080/subscriptions


# BREW
brew tap pivotal/tap
brew install springboot


# SPRING
spring install org.springframework.cloud:spring-cloud-cli:1.3.2.RELEASE

## Application Configuration
server.port=8081
spring.application.name=billing


# PORT
8761	Eureka
8888 Config Server
15672 RabbitMQ Dashboard
5672 RabbitMQ


./gradlew submitCloudNativeEvolutionServiceDiscovery -PumsUrl=http://ums-intermarine-ductility.apps.cumuluslabs.io
./gradlew submitCloudNativeEvolutionDistributedConfiguration -PumsUrl=http://ums-intermarine-ductility.apps.cumuluslabs.io  -Pusername=user -Ppassword=110fba1a0-dfb6-42d5-830f-8bb961769fc7
./gradlew submitCloudNativeEvolutionSubscriptions -PumsUrl=http://ums-intermarine-ductility.apps.cumuluslabs.io  -Pusername=user -Ppassword=110fba1a0-dfb6-42d5-830f-8bb961769fc7

billing-attritive-dal
