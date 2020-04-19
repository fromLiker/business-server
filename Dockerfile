FROM java:8
WORKDIR /tbusiness
COPY target/business-server-0.0.1-SNAPSHOT.jar /tbusiness/tbusiness.jar
EXPOSE 8183
ENTRYPOINT ["java","-Xms200m","-Xmx300m","-jar","/tbusiness/tbusiness.jar"]
