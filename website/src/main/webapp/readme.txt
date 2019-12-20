【maven】
	# versions-maven-plugin
		[坐标]:
			<dependency>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>versions-maven-plugin</artifactId>
				<version>2.5</version>
			</dependency>
		[用法]：
			1>检测组件是否存在更新（mvn versions:display-dependency-updates） 
			2>更新版本号（mvn versions:set -DnewVersion=1.1-SNAPSHOT） 
			3>提交（mvn versions:commit）
			4>撤销（mvn versions:revert）
	
	# versions-maven-plugin
		[坐标]:
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.2</version>
				<configuration>
					<!-- Tomcat6将text替换为html -->
					<url>http://127.0.0.1:8080/manager/text</url>
					<!-- 以下三项与Maven的Setting文件一致 -->
					<server>tomcat</server>
					<username>admin</username>
					<password>admin</password>
				</configuration>
			</plugin>
		[用法]：
			1>部署至TOMCAT（mvn tomcat7:deploy）
			2>删除部署（mvn tomcat7:undeploy）
【RPC】
	-概念：把应用中的某些功能发布为[远程服务]并提供给[其他应用]来使用。
	-模型
		-RMI: 不考虑网络限制时（例如防火墙），访问/发布基于Java的服务
		-Hessian或Burlap: 考虑网络限制时，通过HTTP访问/发布基于Java的服务。Hessian是二进制协议，而Burlap是基于XML的
		-HTTP invoker: 考虑网络限制，并希望使用基于XML或专有的序列化机制实现Java序列化时，访问/发布基于Spring的服务
		-JAX-RPC和JAX-WS：访问/发布平台独立的、基于SOAP的Web服务
【JMX】 
	-作用：JMX这项技术能够让我们管理、监视和配置应用。