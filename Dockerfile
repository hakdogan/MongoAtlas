FROM openjdk:8-jre-alpine

LABEL maintainer = "Hüseyin Akdoğan <huseyin.akdogan@kodcu.com>"

VOLUME /var/log

ADD target/mongoAtlas-1.0-SNAPSHOT.jar /atlas/

EXPOSE 8080

CMD ["sh","-c", "java -Dnetworkaddress.cache.ttl=60 -jar /atlas/mongoAtlas-1.0-SNAPSHOT.jar"]