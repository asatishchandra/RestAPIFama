# RestAPIFama
Spring Boot App V2.2.4.RELEASE. <br />
URL to test the app: http://restapifama.herokuapp.com/api/v1/num_to_english/123. <br />
o/p is in Json format {"status":"Success","number":123,"numInEnglish":"One Hundred Twenty Three"}. <br />
Status displays the error message. <br />
Currently the app only works with HTTP GET action. The remaing HTTP action methods are stubbed in, and can be filled in as needed. <br />
Integration test for the RESTAPI calls and Unit tests for the service have been accounted for. <br />

To build locally: <br />
Open cmd prompt <br />
Navigate to the dir you have the project checkout to <br />
Run the following command to clean and build the project:  mvnw clean package <br />
Run the following command to start the server : java -jar target\REST-API-FAMA-0.0.1-SNAPSHOT.jar  <br />
Local url: http://localhost:8083/api/v1/num_to_english/1234563432 
