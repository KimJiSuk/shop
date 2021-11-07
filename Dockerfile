FROM openjdk:11
VOLUME /app
ADD build/libs/shop-1.0.0.war app-1.0.0.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app-1.0.0.war"]