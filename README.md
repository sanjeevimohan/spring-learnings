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


Litmos

Spring boot developer

Spring Boot’s opinionated approach removes much of the boilerplate and configuration that characterizes Spring, making development faster and deployment easier.




Separation of concern (SoC)
Testing
	Unit testing
	TDD
HTTP
MVC
CORS


Definition of Actuator
An actuator is a manufacturing term, referring to a mechanical device for moving or controlling something. Actuators can generate a large amount of motion from a small change.

Auditing, health and metrics gathering


CF
cf l  -a api.system.cumuluslabs.io
TIP: Use 'cf login --skip-ssl-validation' to continue with an insecure API endpoint


cf a
cf push directory-service-sm -p build/libs/directory-service-0.0.1-SNAPSHOT.jar
cf restage directory-service-sm
cf delete directory-service-sm -r

cf r
cf m

cf s
cf cs p-mysql 100mb mysql
cf bs directory-service-sm mysql
cf ds mysql


jdbc:h2:~/test
jdbc:h2:mem:testdb


specific
generic

https://pal-prerequisites-v1.cfapps.io


Install Brew

ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

brew doctor
Your system is ready to brew.


vnameits-Mac-mini-4:prerequisite-code sanjeevi$ cf push
Using manifest file /Users/sanjeevi/workspace/prerequisite-code/manifest.yml

Creating app prerequisite in org msanjeevi-pal / space sandbox as sanjeevi.mohan@cognizant.com...
OK

Creating route prerequisite-nonvoluble-hangar.apps.cumuluslabs.io...
OK

Binding prerequisite-nonvoluble-hangar.apps.cumuluslabs.io to prerequisite...
OK

Uploading prerequisite...
Uploading app files from: /var/folders/y_/3lvw0v3s20b8bj71sw8yxql40000gq/T/unzipped-app225281786
Uploading 312.5K, 81 files
Done uploading
OK

Starting app prerequisite in org msanjeevi-pal / space sandbox as sanjeevi.mohan@cognizant.com...
Downloading binary_buildpack...
Downloading go_buildpack...
Downloading ruby_buildpack...
Downloading nodejs_buildpack...
Downloading php_buildpack...
Downloaded ruby_buildpack
Downloading dotnet_core_buildpack...
Downloaded go_buildpack
Downloading python_buildpack...
Downloaded php_buildpack
Downloading java_buildpack_offline...
Downloaded nodejs_buildpack
Downloading meta_buildpack...
Downloaded binary_buildpack
Downloading staticfile_buildpack...
Downloaded python_buildpack
Downloaded dotnet_core_buildpack
Downloaded meta_buildpack
Downloaded java_buildpack_offline
Downloaded staticfile_buildpack
Creating container
Successfully created container
Downloading app package...
Downloaded app package (12.2M)
Staging...
[meta-buildpack] Compiling with container-security-provider=1.5.0_RELEASE java-buildpack=v3.17-offline-https://github.com/cloudfoundry/java-buildpack.git#87fb619 java-main open-jdk-like-jre=1.8.0_131 open-jdk-like-memory-calculator=2.0.2_RELEASE open-jdk-like-security-providers secur...
-----> Java Buildpack Version: v3.17 (offline) | https://github.com/cloudfoundry/java-buildpack.git#87fb619
-----> Downloading Open Jdk JRE 1.8.0_131 from https://java-buildpack.cloudfoundry.org/openjdk/trusty/x86_64/openjdk-1.8.0_131.tar.gz (found in cache)
       Expanding Open Jdk JRE to .java-buildpack/open_jdk_jre (1.0s)
-----> Downloading Open JDK Like Memory Calculator 2.0.2_RELEASE from https://java-buildpack.cloudfoundry.org/memory-calculator/trusty/x86_64/memory-calculator-2.0.2_RELEASE.tar.gz (found in cache)
       Memory Settings: -Xms681574K -XX:MetaspaceSize=104857K -Xmx681574K -XX:MaxMetaspaceSize=104857K -Xss349K
-----> Downloading Container Security Provider 1.5.0_RELEASE from https://java-buildpack.cloudfoundry.org/container-security-provider/container-security-provider-1.5.0_RELEASE.jar (found in cache)
-----> Downloading Spring Auto Reconfiguration 1.11.0_RELEASE from https://java-buildpack.cloudfoundry.org/auto-reconfiguration/auto-reconfiguration-1.11.0_RELEASE.jar (found in cache)
Exit status 0
Staging complete
Uploading droplet, build artifacts cache...
Uploading droplet...
Uploading build artifacts cache...
Uploaded build artifacts cache (109B)
Uploaded droplet (57.7M)
Uploading complete
Destroying container
Successfully destroyed container

0 of 1 instances running, 1 starting
1 of 1 instances running

App started


OK

App prerequisite was started using this command `CALCULATED_MEMORY=$($PWD/.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-2.0.2_RELEASE -memorySizes=metaspace:64m..,stack:228k.. -memoryWeights=heap:65,metaspace:10,native:15,stack:10 -memoryInitials=heap:100%,metaspace:100% -stackThreads=300 -totMemory=$MEMORY_LIMIT) && JAVA_OPTS="-Djava.io.tmpdir=$TMPDIR -XX:OnOutOfMemoryError=$PWD/.java-buildpack/open_jdk_jre/bin/killjava.sh $CALCULATED_MEMORY -Djava.ext.dirs=$PWD/.java-buildpack/container_security_provider:$PWD/.java-buildpack/open_jdk_jre/lib/ext -Djava.security.properties=$PWD/.java-buildpack/security_providers/java.security" && SERVER_PORT=$PORT eval exec $PWD/.java-buildpack/open_jdk_jre/bin/java $JAVA_OPTS -cp $PWD/. org.springframework.boot.loader.JarLauncher`

Showing health and status for app prerequisite in org msanjeevi-pal / space sandbox as sanjeevi.mohan@cognizant.com...
OK

requested state: started
instances: 1/1
usage: 1G x 1 instances
urls: prerequisite-nonvoluble-hangar.apps.cumuluslabs.io
last uploaded: Tue Oct 31 05:09:40 UTC 2017
stack: cflinuxfs2
buildpack: container-security-provider=1.5.0_RELEASE java-buildpack=v3.17-offline-https://github.com/cloudfoundry/java-buildpack.git#87fb619 java-main open-jdk-like-jre=1.8.0_131 open-jdk-like-memory-calculator=2.0.2_RELEASE open-jdk-like-se... (no decorators apply)

     state     since                    cpu    memory         disk           details
#0   running   2017-10-31 10:40:22 AM   0.0%   391.2M of 1G   137.2M of 1G
vnameits-Mac-mini-4:prerequisite-code sanjeevi$




./gradlew submitPrerequisites -PprerequisiteUrl=http://prerequisite-nonvoluble-hangar.apps.cumuluslabs.io



/usr/local/Cellar/gradle/4.3
/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/H‌ome/

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/
echo $JAVA_HOME


cf create-service-broker mongodb-service-broker-sm pivotal keepitsimple https://mongodb-service-broker-phoniest-diversion.apps.cumuluslabs.io --space-scoped


echo "# app-config" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/sanjeevimohan/app-config.git
git push -u origin master


cf create-service p-config-server standard config-server -c workspace/cfg-svr-config.json 


cf bind-service greeting-service config-server
cf bind-service greeting-service service-registry

./mvnw clean spring-boot:run


fortune-service
cf us gateway-app service-registry
cf us greeting-frontend service-registry
cf us greeting-hystrix service-registry
cf us greeting-ribbon-rest service-registry
cf us greeting-service  service-registry


cf bs gateway-app service-registry
cf bs greeting-frontend service-registry
cf bs greeting-hystrix service-registry
cf bs greeting-ribbon-rest service-registry
cf bs greeting-service  service-registry

The auditory learners learn by hearing and listening. The visual learners learn by reading or seeing imagery. The tactile learners learn by doing something that involves touching.

if you want me to talk for 60 minutes, give me 5 minutes to prepare; if you want me to talk for 5 minutes, give me a few hours to prepare


code craft

acdefort


DDD is a set of tools that assist you in designing and implementing software that delivers high value, both strategically and tactically.

priority
lets concentrate on core business

#Brew
brew install tomee-plume
/usr/local/Cellar/
brew info mysql

#Maven
 -DskipTests -Dmaven.test.skip=true
MOVIE_FUN_URL=http://moviefun-antioptimistic-brand.apps.cumuluslabs.io mvn test
mvn spring-boot:run

Tomee
/usr/local/Cellar/tomee-plume/1.7.4/libexec/webapps
/usr/local/Cellar/tomee-plume/1.7.4/libexec/bin/catalina.sh run open http://localhost:8080/moviefun

#CF

cf push moviefun -p target/moviefun.war -b https://github.com/cloudfoundry-community/tomee-buildpack.git

buildpack:         container-security-provider=1.5.0_RELEASE java-buildpack=v3.17-offline-https://github.com/cloudfoundry/java-buildpack.git#87fb619 open-jdk-like-jre=1.8.0_131
                   open-jdk-like-memory-calculator=2.0.2_RELEASE open-jdk-like-security-pro... (no decorators apply)

buildpack: https://github.com/cloudfoundry-community/tomee-buildpack.git
start command:     JAVA_OPTS="-agentpath:$PWD/.java-buildpack/open_jdk_jre/bin/jvmkill-1.11.0_RELEASE=printHeapHistogram=1 -Djava.io.tmpdir=$TMPDIR
                   -Djava.ext.dirs=$PWD/.java-buildpack/container_security_provider:$PWD/.java-buildpack/open_jdk_jre/lib/ext
                   -Djava.security.properties=$PWD/.java-buildpack/java_security/java.security $JAVA_OPTS -Djava.endorsed.dirs=$PWD/.java-buildpack/tomee/endorsed -Daccess.logging.enabled=false
                   -Dhttp.port=$PORT" && CALCULATED_MEMORY=$($PWD/.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-3.10.0_RELEASE -totMemory=$MEMORY_LIMIT -stackThreads=300
                   -loadedClasses=18042 -poolType=metaspace -vmOptions="$JAVA_OPTS") && echo JVM Memory Configuration: $CALCULATED_MEMORY && JAVA_OPTS="$JAVA_OPTS $CALCULATED_MEMORY" &&
                   JAVA_OPTS=$JAVA_OPTS JAVA_HOME=$PWD/.java-buildpack/open_jdk_jre exec $PWD/.java-buildpack/tomee/bin/catalina.sh run


 2017-11-14T12:16:41.66+0530 [APP/PROC/WEB/0] ERR Cannot calculate JVM memory configuration: There is insufficient memory remaining for heap. Memory limit 512M is less than allocated memory 678247K (-XX:ReservedCodeCacheSize=240M, -XX:MaxDirectMemorySize=10M, -XX:MaxMetaspaceSize=115047K, -Xss1M * 300 threads)

cf create-service p-mysql 100mb movies-mysql
cf bs moviefun movies-mysql
cf create-service p-mysql 100mb albums-mysql
cf bs moviefun albums-mysql
 The TomEE Buildpack is a community-developed buildpack, which means that it has no official support from Pivotal.


MySQL
mysql -uroot
create database movies;


MySQL	3306


smoke test

# Assignment
./gradlew submitReplatformingSpringBootification -PmovieFunUrl=http://moviefun-unsyllabicated-jade.apps.cumuluslabs.io
./gradlew submitReplatformingManagingDataSources -PmovieFunUrl=http://moviefun-unsyllabicated-jade.apps.cumuluslabs.io
./gradlew submitReplatformingRemovingReadsFromFileSystem -PmovieFunUrl=http://moviefun-unsyllabicated-jade.apps.cumuluslabs.io
./gradlew submitReplatformingRemovingPersistenceToFileSystem -PmovieFunUrl=http://moviefun-unsyllabicated-jade.apps.cumuluslabs.io
./gradlew submitReplatformingLogging -PmovieFunUrl=http://moviefun-unsyllabicated-jade.apps.cumuluslabs.io
./gradlew submitReplatformingBackgroundJobsWithDb -PmovieFunUrl=http://moviefun-unsyllabicated-jade.apps.cumuluslabs.io
./gradlew submitReplatformingBackgroundJobsWithAmqp -PmovieFunUrl=http://moviefun-unsyllabicated-jade.apps.cumuluslabs.io
./gradlew submitReplatformingRemoveInstanceSpecificState -PsessionStateUrl=http://remove-session-state-ascendible-tycoon.apps.cumuluslabs.io
./gradlew submitReplatformingStruts -PstrutsAppUrl=http://struts-unmountable-quinsy.apps.cumuluslabs.io
No qualifying bean of type 'org.springframework.transaction.PlatformTransactionManager' available: expected single matching bean but found 2: albumsTransactionManager,moviesTransactionManager


System-Provided:
{
 "VCAP_SERVICES": {
  "p-mysql": [
   {
    "credentials": {
     "hostname": "10.0.16.78",
     "jdbcUrl": "jdbc:mysql://10.0.16.78:3306/cf_7adc1e83_5960_4cd6_848b_1b6438fd3278?user=8YZYu88baY2K8v3C\u0026password=qFA1zlc0lgTxVf5F",
     "name": "cf_7adc1e83_5960_4cd6_848b_1b6438fd3278",
     "password": "qFA1zlc0lgTxVf5F",
     "port": 3306,
     "uri": "mysql://8YZYu88baY2K8v3C:qFA1zlc0lgTxVf5F@10.0.16.78:3306/cf_7adc1e83_5960_4cd6_848b_1b6438fd3278?reconnect=true",
     "username": "8YZYu88baY2K8v3C"
    },
    "label": "p-mysql",
    "name": "movies-mysql",
    "plan": "100mb",
    "provider": null,
    "syslog_drain_url": null,
    "tags": [
     "mysql",
     "relational"
    ],
    "volume_mounts": []
   },
{
    "credentials": {
     "hostname": "10.0.16.78",
     "jdbcUrl": "jdbc:mysql://10.0.16.78:3306/cf_f0d3d3dd_4a35_47fb_b159_c87c6c8d8e53?user=oEAdNcsTzDtwPvuL\u0026password=YzY4VxiqoKkq3mpS",
     "name": "cf_f0d3d3dd_4a35_47fb_b159_c87c6c8d8e53",
     "password": "YzY4VxiqoKkq3mpS",
     "port": 3306,
     "uri": "mysql://oEAdNcsTzDtwPvuL:YzY4VxiqoKkq3mpS@10.0.16.78:3306/cf_f0d3d3dd_4a35_47fb_b159_c87c6c8d8e53?reconnect=true",
     "username": "oEAdNcsTzDtwPvuL"
    },
    "label": "p-mysql",
    "name": "albums-mysql",
    "plan": "100mb",
    "provider": null,
    "syslog_drain_url": null,
    "tags": [
     "mysql",
     "relational"
    ],
    "volume_mounts": []
   }

  ]
 }
}

{
 "VCAP_APPLICATION": {
  "application_id": "1426739a-5fc2-44aa-8294-211df1202299",
  "application_name": "moviefun",
  "application_uris": [
   "moviefun-unsyllabicated-jade.apps.cumuluslabs.io"
  ],
  "application_version": "71b4861c-61df-4c39-ba3c-9d2324e97f6d",
  "cf_api": "https://api.system.cumuluslabs.io",
  "limits": {
   "disk": 512,
   "fds": 16384,
   "mem": 1024
  },
  "name": "moviefun",
  "space_id": "8d5230e6-8da1-4cd2-8cc9-2bbd7c7bb223",
  "space_name": "sandbox",
  "uris": [
   "moviefun-unsyllabicated-jade.apps.cumuluslabs.io"
  ],
  "users": null,
  "version": "71b4861c-61df-4c39-ba3c-9d2324e97f6d"
 }
}

User-Provided:
MOVIEFUN_DATASOURCES_ALBUMS_PASSWORD: YzY4VxiqoKkq3mpS
MOVIEFUN_DATASOURCES_ALBUMS_URL: jdbc:mysql://10.0.16.78:3306/cf_f0d3d3dd_4a35_47fb_b159_c87c6c8d8e53
MOVIEFUN_DATASOURCES_ALBUMS_USERNAME: cf_f0d3d3dd_4a35_47fb_b159_c87c6c8d8e53
MOVIEFUN_DATASOURCES_MOVIES_PASSWORD: qFA1zlc0lgTxVf5F
MOVIEFUN_DATASOURCES_MOVIES_URL: jdbc:mysql://10.0.16.78:3306/cf_7adc1e83_5960_4cd6_848b_1b6438fd3278
MOVIEFUN_DATASOURCES_MOVIES_USERNAME: 8YZYu88baY2K8v3C

No user-defined env variables have been set

No running env variables have been set

No staging env variables have been set


cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_URL jdbc:mysql://10.0.16.78:3306/cf_7adc1e83_5960_4cd6_848b_1b6438fd3278?user=8YZYu88baY2K8v3C\u0026password=qFA1zlc0lgTxVf5F
cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_USERNAME cf_7adc1e83_5960_4cd6_848b_1b6438fd3278
cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_PASSWORD qFA1zlc0lgTxVf5F
cf set-env moviefun MOVIEFUN_DATASOURCES_ALBUMS_URL jdbc:mysql://10.0.16.78:3306/cf_f0d3d3dd_4a35_47fb_b159_c87c6c8d8e53?user=oEAdNcsTzDtwPvuL\u0026password=YzY4VxiqoKkq3mpS
cf set-env moviefun MOVIEFUN_DATASOURCES_ALBUMS_USERNAME cf_f0d3d3dd_4a35_47fb_b159_c87c6c8d8e53
cf set-env moviefun MOVIEFUN_DATASOURCES_ALBUMS_PASSWORD YzY4VxiqoKkq3mpS


cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_URL jdbc:mysql://10.0.16.78:3306/cf_f99066c7_0e34_4783_b2f4_9dbc319eec9a
cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_USERNAME DCRg7YXszgd4jCaK
cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_PASSWORD l4bIG9EbRqXPt5YF
cf set-env moviefun MOVIEFUN_DATASOURCES_ALBUMS_URL jdbc:mysql://10.0.16.78:3306/cf_f0d3d3dd_4a35_47fb_b159_c87c6c8d8e53
cf set-env moviefun MOVIEFUN_DATASOURCES_ALBUMS_USERNAME oEAdNcsTzDtwPvuL
cf set-env moviefun MOVIEFUN_DATASOURCES_ALBUMS_PASSWORD YzY4VxiqoKkq3mpS

cf m
service                       plans                                      description
app-autoscaler                standard                                   Scales bound applications in response to load (beta)
aws-dynamodb                  standard*                                  Create and manage Amazon DynamoDB tables
aws-rds-aurora                basic*, standard*, premium*, enterprise*   Create and manage Amazon RDS Aurora deployments
aws-rds-mariadb               basic*, standard*, premium*, enterprise*   Create and manage Amazon RDS MariaDB deployments
aws-rds-mysql                 basic*, standard*, premium*, enterprise*   Create and manage Amazon RDS MySQL deployments
aws-rds-oracle                basic*, standard*, premium*, enterprise*   Create and manage Amazon RDS Oracle deployments
aws-rds-postgres              basic*, standard*, premium*, enterprise*   Create and manage Amazon RDS PostgreSQL deployments
aws-rds-sqlserver             basic*, standard*, premium*, enterprise*   Create and manage Amazon RDS SQL Server deployments
aws-s3                        standard*                                  Create and manage Amazon S3 buckets
aws-sqs                       standard*                                  Create and manage Amazon SQS queues
p-circuit-breaker-dashboard   standard                                   Circuit Breaker Dashboard for Spring Cloud Applications
p-config-server               standard                                   Config Server for Spring Cloud Applications
p-identity                    basic-sso                                  Single Sign-On as a Service
p-mysql                       100mb                                      MySQL databases on demand
p-rabbitmq                    standard                                   RabbitMQ is a robust and scalable high-performance multi-protocol messaging broker.
p-redis                       dedicated-vm, shared-vm                    Redis service to provide pre-provisioned instances configured as a datastore, running on a shared or dedicated VM.
p-service-registry            standard                                   Service Registry for Spring Cloud Applications
p.redis                       cache-small, cache-medium, cache-large     Redis service to provide on-demand dedicated instances configured as a cache.

* These service plans have an associated cost. Creating a service instance will incur this cost.

TIP:  Use 'cf marketplace -s SERVICE' to view descriptions of individual plans of a given service.

cf cs aws-s3 standard moviefun-s3
cf bs moviefun moviefun-s3


cf set-env moviefun S3_ENDPOINTURL http://s3.amazonaws.com 
cf set-env moviefun S3_ACCESSKEY AKIAJUJB2FIMN6NDEMXQ
cf set-env moviefun S3_SECRETKEY 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
cf set-env moviefun S3_BUCKETNAME cf-9f6108d9-aebe-432d-b93e-4f8e743574f4

"aws-s3": [
   {
    "credentials": {
     "access_key_id": "AKIAJUJB2FIMN6NDEMXQ",
     "bucket": "cf-9f6108d9-aebe-432d-b93e-4f8e743574f4",
     "region": "ap-southeast-1",
     "secret_access_key": "LyBnII19Iz3T9MAHfIuqom8OvCXBqZBiHo/rFzhY"
    },
    "label": "aws-s3",
    "name": "moviefun-s3",
    "plan": "standard",
    "provider": null,
    "syslog_drain_url": null,
    "tags": [],
    "volume_mounts": []
   }
  ]


cf create-user-provided-service paper-trail -l syslog-tls://logs6.papertrailapp.com:32581

cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_URL jdbc:mysql://10.0.16.78:3306/cf_f99066c7_0e34_4783_b2f4_9dbc319eec9a
cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_USERNAME DCRg7YXszgd4jCaK
cf set-env moviefun MOVIEFUN_DATASOURCES_MOVIES_PASSWORD l4bIG9EbRqXPt5YF

cf ssh -L 63306:10.0.16.78:3306/cf_7adc1e83_5960_4cd6_848b_1b6438fd3278 moviefun
mysql -u vxA28krhS6CSsDCo -h 0 -p nDQ8CPSbDDwRcjEl -P 63306


16-Nov-2016
https://docs.cloudfoundry.org/devguide/deploy-apps/start-restart-restage.html


https://github.com/platform-acceleration-lab/apps-movie-fun-code.git
git checkout background-jobs-rabbit-start


curl -X POST http://moviefun-unsyllabicated-jade.apps.cumuluslabs.io/rabbit -d


PWD present working directory,

stocks queue
10.0.16.95
7a43202e-d29a-42b9-9fc1-1810563585fe
8l8kf4gc3q84r5147jbloh60sm

cf ssh -L 63306:10.0.16.78:3306 album-service-sm
mysql -u zOyeISUSDDFuiEQ3 -h 0 -p -D cf_4df0b79e_9c31_4f03_bad4_c3fb39c1813f -P 63306
v6hxh3OovcSOuQiK


cf ssh -L 63306:10.0.16.78:3306 movie-service-sm
mysql -u 8FtzbndSzbQc7rWL -h 0 -p -D cf_62974901_9947_4767_b69a_954aba77fda1 -P 63306
m9COmacQO59MDokl

https://cognizant-pal-v4.apps.cumuluslabs.io/
https://github.com/platform-acceleration-lab/prerequisite-code#readme
https://apps.system.cumuluslabs.io
https://docs.cloudfoundry.org/devguide/deploy-apps/blue-green.html
https://github.com/pivotalservices/concourse-pipeline-samples/tree/master/blue-green-app-deployment
https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-metrics.html
http://www.baeldung.com/spring-boot-actuators
https://www.dineshonjava.com/spring-boot-actuator-complete-guide/
http://projects.spring.io/spring-security-oauth/docs/oauth2.html
http://www.baeldung.com/spring-security-authentication-with-a-database
https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html
http://www.baeldung.com/spring-boot-testing
http://www.baeldung.com/spring-cloud-configuration
http://docs.pivotal.io/spring-cloud-services/1-4/common/service-registry/managing-service-instances.html
https://gooroo.io/GoorooTHINK/Article/17367/Spring-Cloud-and-Netflix-Ribbon-Clientside-Load-Balancing/28985#.WgHtFcgjHIU
https://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html#netflix-ribbon-starter
https://spring.io/guides/gs/client-side-load-balancing/
http://www.baeldung.com/spring-cloud-rest-client-with-netflix-ribbon
https://dst.cognizant.com/Oct-2017-digest.html
https://docs.pivotal.io/pivotalcf/1-12/devguide/services/using-vol-services.html
https://mac.eltima.com/amazon-mac.html
http://docs.aws.amazon.com/cli/latest/userguide/cli-install-macos.html#awscli-install-osx-path
https://github.com/TheCognizantFoundry/apps-movie-fun-code.git
https://www.danrodney.com/mac/

https://basic-sso.login.system.cumuluslabs.io/login.do


{"ticker":"INTC","quantity":1,"price":null,"orderType":"MARKET","accountName":"ACCT-123","buyRequest":true,"userName":"Joe","requestId":"REQ-1","id":"c1a60c02-e711-4f40-ba84-643d99c6fb44"}



{"ticker":"AAPL","quantity":1,"price":null,"orderType":"MARKET","confirmationNumber":null,"error":false,"errorMessage":null,"accountName":"ACCT-123","timestamp":1511501012639,"requestId":"REQ-1"}


mvn -N io.takari:maven:wrapper
git checkout -b concourse_deployment
git push -u origin concourse_deployment

chmod -x /usr/local/bin/fly
fly -t cicd login --concourse-url http://IP:8080/
