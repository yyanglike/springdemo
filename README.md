#Spring boot Demo

参考pom.xml 调整自己的pom文件。

修改Application文件为@SpringBootApplication(proxyBeanMethods = false)
运行compile.sh




mvn -DskipTests=true clean package
export MI=src/main/resources/META-INF
mkdir -p $MI 
java -agentlib:native-image-agent=config-output-dir=${MI}/native-image -jar target/reactive.jar

## it's at this point that you need to exercise the application: http://localhost:8080/reservations 
## then hit CTRL + C to stop the running application.

tree $MI
mvn -Pgraal clean package
