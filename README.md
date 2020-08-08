# RestAssured-Swagger
This project is used to generate the Automation script for Rest Assured framework from Swagger Json

<!-- Jar file added.

activation-1.1.jar
animal-sniffer-annotations-1.17.jar
bson-3.0.4.jar
btf-1.2.jar
checker-compat-qual-2.5.2.jar
commons-codec-1.9.jar
commons-io-2.6.jar
commons-lang3-3.2.1.jar
commons-lang3-3.4.jar
commons-logging-1.2.jar
error_prone_annotations-2.2.0.jar
extentreports-4.0.6.jar
failureaccess-1.0.1.jar
freemarker-2.3.23.jar
groovy-3.0.3.jar
groovy-json-3.0.3.jar
groovy-xml-3.0.3.jar
gson-2.8.5.jar
guava-27.0.1-android.jar
hamcrest-2.1.jar
httpclient-4.5.3.jar
httpcore-4.4.6.jar
httpmime-4.5.3.jar
j2objc-annotations-1.1.jar
jackson-annotations-2.10.2.jar
jackson-core-2.10.2.jar
jackson-coreutils-1.6.jar
jackson-databind-2.10.2.jar
jackson-dataformat-yaml-2.10.2.jar
jackson-datatype-jsr310-2.10.1.jar
jakarta.activation-api-1.2.1.jar
jakarta.activation-api-1.2.2.jar
jakarta.validation-api-2.0.2.jar
jakarta.xml.bind-api-2.3.2.jar
jakarta.xml.bind-api-2.3.3.jar
jaxb-impl-2.3.3.jar
joda-time-2.9.7.jar
jopt-simple-5.0.3.jar
json-patch-1.6.jar
json-schema-core-1.2.8.jar
json-schema-validator-2.2.8.jar
json-simple-1.1.1.jar
jsoup-1.8.3.jar
jsr305-3.0.2.jar
libphonenumber-8.0.0.jar
listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar
lombok.jar
mailapi-1.4.3.jar
mongodb-driver-3.0.4.jar
mongodb-driver-core-3.0.4.jar
msg-simple-1.1.jar
reactive-streams-1.0.2.jar
rest-assured-4.3.1.jar
rhino-1.7R4.jar
rxjava-2.1.14.jar
slf4j-api-1.7.30.jar
slf4j-ext-1.7.30.jar
swagger-models-1.6.1.jar
tagsoup-1.2.1.jar
uri-template-0.9.jar
validation-api-1.1.0.Final.jar -->

# What is the purpose of this project?
Every software development group tests its products, yet delivered software always has defects. Test engineers strive to catch them before the product is released but they always creep in and they often reappear, even with the best manual testing processes. Test Automation software is the best way to increase the effectiveness, efficiency and coverage of your software testing.

In the consideration of the same, As most of the companies are moving towards microservices, and also putting lots of the efforts to 
create a descriptive and easy understandable Swagger Document.

This project will <b>Generate Rest Assured Test Cases </b> from the <i><b>swagger json</b></i> file. 

# What are all covered?
1. This Project will be Generate the Rest Assured Java Code from the Swagger JSon file.
2. We can generate specific api / module Test cases.
3. Used Extent Report for Reporting purpose.
4. Listners added to capture the Report Data.
5. Request, Response, Query , Path Parameters, and  URL will be added to the Report Module based on teh consiguration.
6. Native Test Cases covered based on the required fields from the Swagger data.

# How to use this?
1. Download/ fork project.
2. Import the project to your favourite Development IDE (STS/Eclipse/Intellij IDEA) or on your choice.
3. Read the <b><i>constant.properties</i></b>. Change the consiguration according to your use case.
4. Open the <b><i>AutoMationCodeGen</i></b> java class and RUN after placing the Swagger Json in the class path.

# Configuration
1. To Configure the specific module to generate the code . Need to add the config of API Path (Ex: /api/student)
<img src="https://github.com/jgsudhakar735/RestAssured-Swagger/blob/master/docs/moduleidconfig.PNG">
2. To generate Negative Test Case from the swagger Enable the below flag . 
<img src="https://github.com/jgsudhakar735/RestAssured-Swagger/blob/master/docs/NegatieveTestConfig.PNG">
3. To Audit the Request, Response, Query , Path Parameters, and  URL will be added to the Report Module , do enable the below configuration.
<img src="https://github.com/jgsudhakar735/RestAssured-Swagger/blob/master/docs/logAuditConfig.PNG">

# How Does Report looks like?
1. For reporting purpose we have used Extent Report(https://extentreports.com/).
2. In this project, we have used 4.0.6 library.
<img src="https://github.com/jgsudhakar735/RestAssured-Swagger/blob/master/docs/ReportGenerated.PNG">
3. For any customization / better reporting purpose please do check in the <b>Extent Reports</b>
