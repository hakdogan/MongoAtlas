FROM openjdk:8-jre-alpine

LABEL maintainer = "Hüseyin Akdoğan <huseyin.akdogan@kodcu.com>"

VOLUME /var/log

ARG VERSION

ENV VERSION ${VERSION}

ADD target/mongoAtlas-${VERSION}.jar /atlas/

EXPOSE 8080

CMD ["sh","-c", "java -Dnetworkaddress.cache.ttl=60 -jar /atlas/mongoAtlas-$VERSION.jar"]