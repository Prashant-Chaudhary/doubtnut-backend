# Welcome to DoubtNut PDF Service!

Hi! I'm **Doubtnut PDF Generation Service**. If you want to learn about this project, you can read this file. Basic Modules & Functionality are explained below.


# Explanation

Submit JSON list of Questions with user id. The last request for each user id would be stored and checked if the inactive time is more than 5 minutes for users last request.

# How to Execute

Just Import the Repository in Eclipse of IntelliJ. Start the Server by running the **BackendApplication.java** file. Once the server has been started the sample REST APIs should be up and running at - **http://localhost:8080/swagger-ui.html** . 


## Steps to Follow for test cases

 1. Open the **POST /api/v1/test/related-questions** API in Swagger Dashboard.
 2. Use the Sample JSON files in the SampleJson Folder
 3. Try the REST API with different json payload with the user of **Try Now** button.
 4. You would be able notice in console the Last REST API call list which is maintained on the server.
 5. The CRON Job runs at the interval of 1 minute and it would check the list for all the APIs call which are older than 5         Minutes.
 6. If any user request is older than 5 min , then the PDF Generation service would be called and a PDF is generated with the     JSON list associated with the request and is stored in the **pdfs** folder in the repository. Naming convention of the         PDFs are - **UserID + Current TimeStamp**.


