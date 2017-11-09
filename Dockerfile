FROM openjdk:8-jre-alpine

LABEL maintainer = "Hüseyin Akdoğan <huseyin.akdogan@kodcu.com>"

VOLUME /var/log

CMD ["sh","-c", "mvn clean install"]

COPY target/mongoAtlas-1.0-SNAPSHOT.jar /atlas.jar

EXPOSE 8080

CMD ["sh","-c", "java -Dnetworkaddress.cache.ttl=60 -jar /atlas.jar"]