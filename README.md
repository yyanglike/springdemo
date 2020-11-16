


https://spring.io/blog/2020/04/16/spring-tips-the-graalvm-native-image-builder-feature


https://github.com/spring-projects-experimental/spring-init

#Spring boot Demo

参考pom.xml 调整自己的pom文件。

修改Application文件为@SpringBootApplication(proxyBeanMethods = false)
运行compile.sh




mvn -DskipTests=true clean package
export MI=src/main/resources/META-INF
mkdir -p $MI 
java -agentlib:native-image-agent=config-output-dir=${MI}/native-image -jar target/reactive.jar
$JAVA_HOME/bin/java -agentlib:native-image-agent=config-output-dir=${MI}/native-image,config-write-period-secs=10,config-write-initial-delay-secs=3 -jar target/demo-0.0.1-SNAPSHOT.jar


## it's at this point that you need to exercise the application: http://localhost:8080/reservations 
## then hit CTRL + C to stop the running application.

tree $MI
mvn -Pgraal clean package


							<!-- <buildArgs>--Dspring.graal.mode=initialization-only -Dspring.graal.dump-config=/tmp/computed-reflect-config.json -Dspring.graal.verbose=true -Dspring.graal.skip-logback=true --initialize-at-run-time=org.springframework.data.r2dbc.connectionfactory.ConnectionFactoryUtils --initialize-at-build-time=io.r2dbc.spi.IsolationLevel,io.r2dbc.spi --initialize-at-build-time=io.r2dbc.spi.ConstantPool,io.r2dbc.spi.Assert,io.r2dbc.spi.ValidationDepth --initialize-at-build-time=org.springframework.data.r2dbc.connectionfactory -H:+TraceClassInitialization --no-fallback --allow-incomplete-classpath --report-unsupported-elements-at-runtime -H:+ReportExceptionStackTraces --no-server --initialize-at-build-time=org.reactivestreams.Publisher --initialize-at-build-time=com.example.reactive.ReservationRepository --initialize-at-run-time=io.netty.channel.unix.Socket --initialize-at-run-time=io.netty.channel.unix.IovArray --initialize-at-run-time=io.netty.channel.epoll.EpollEventLoop --initialize-at-run-time=io.netty.channel.unix.Errors
							</buildArgs> -->




                            	<profiles>
        <profile>
            <id>graal</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.graalvm.nativeimage</groupId>
                        <artifactId>native-image-maven-plugin</artifactId>
                        <version>${native-image-maven-plugin.version}</version>
                        <configuration>
                            <buildArgs>
								-Dspring.graal.mode=initialization-only -Dspring.graal.dump-config=/tmp/computed-reflect-config.json -Dspring.graal.verbose=true -Dspring.graal.skip-logback=true --initialize-at-run-time=org.springframework.data.r2dbc.connectionfactory.ConnectionFactoryUtils --initialize-at-build-time=io.r2dbc.spi.IsolationLevel,io.r2dbc.spi --initialize-at-build-time=io.r2dbc.spi.ConstantPool,io.r2dbc.spi.Assert,io.r2dbc.spi.ValidationDepth --initialize-at-build-time=org.springframework.data.r2dbc.connectionfactory -H:+TraceClassInitialization --no-fallback --allow-incomplete-classpath --report-unsupported-elements-at-runtime -H:+ReportExceptionStackTraces --no-server --initialize-at-build-time=org.reactivestreams.Publisher --initialize-at-run-time=io.netty.channel.unix.Socket --initialize-at-run-time=io.netty.channel.unix.IovArray --initialize-at-run-time=io.netty.channel.epoll.EpollEventLoop --initialize-at-run-time=io.netty.channel.unix.Errors
                            </buildArgs>
                        </configuration>
                        <executions>
                            <execution>
                                <goals>
                                    <goal>native-image</goal>
                                </goals>
                                <phase>package</phase>
                            </execution>
                        </executions>
                    </plugin>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                    </plugin>
                </plugins>
            </build>
        </profile>
		
	</profiles>	



    								-Dspring.graal.mode=initialization-only 
								-Dspring.graal.dump-config=/tmp/computed-reflect-config.json 
								-Dspring.graal.verbose=true 
								-Dspring.graal.skip-logback=true 
								--initialize-at-run-time=org.redisson.api.RedissonClient
								--initialize-at-run-time=org.springframework.data.r2dbc.connectionfactory.ConnectionFactoryUtils 
								--initialize-at-build-time=io.r2dbc.spi.IsolationLevel,io.r2dbc.spi 
								--initialize-at-build-time=io.r2dbc.spi.ConstantPool,io.r2dbc.spi.Assert,io.r2dbc.spi.ValidationDepth 
								--initialize-at-build-time=org.springframework.data.r2dbc.connectionfactory -H:+TraceClassInitialization 
								--no-fallback --allow-incomplete-classpath 
								--report-unsupported-elements-at-runtime 
								-H:+ReportExceptionStackTraces 
								--no-server 
								--initialize-at-build-time=org.reactivestreams.Publisher 
								--initialize-at-run-time=io.netty.channel.unix.Socket 
								--initialize-at-run-time=io.netty.channel.unix.IovArray 
								--initialize-at-run-time=io.netty.channel.epoll.EpollEventLoop 
								--initialize-at-run-time=io.netty.channel.unix.Errors



                                                                -Dspring.native.mode=reflection



native-image.properties:
Args=-H:+UseServiceLoaderFeature \
-Dspring.native.remove-yaml-support=true \
-Dspring.native.remove-jmx-support=true \
-Dspring.native.remove-request-mapping-support=true \
-Dspring.spel.ignore=true \
-Dspring.xml.ignore=true \
--initialize-at-build-time=org.reactivestreams.Publisher \
--initialize-at-run-time=io.netty.channel.unix.Socket \
--initialize-at-run-time=io.netty.channel.unix.IovArray \
--initialize-at-run-time=io.netty.channel.epoll.EpollEventLoop \
--initialize-at-run-time=io.netty.channel.unix.Errors \
--initialize-at-run-time=org.redisson.Redisson.create



TraceClassInitialization=
