# Trello API Automation Project

This project was created as part of the Testinium technical case study.
It demonstrates REST API automation using Java and Rest-Assured for Trello.

---

## Technologies Used
- Java
- Maven
- Rest-Assured
- JUnit 5
- Trello REST API

---

##  Project Structure
src
└─ test
└─ java
└─ org.example
├─ base
│ └─ BaseTest.java
├─ service
│ └─ TrelloService.java
└─ test
└─ TrelloApiTest.java


---

##  Test Scenario
1. Create a new Trello board
2. Retrieve the default list of the board
3. Create two cards in the list
4. Select one card randomly and update it
5. Delete both cards
6. Delete the board

---

##  How to Run the Tests

### 1. Clone the repository
```bash
git clone https://github.com/yigitoguz101/testinium-trello-test.git
2. Create config.properties
Create the following file locally (this file is ignored by Git for security reasons):

src/test/resources/config.properties
Content:

trello.api.key=YOUR_API_KEY
trello.token=YOUR_TOKEN
3. Run tests
bash
mvn test

Security Notes
API key and token are not stored in the repository.
Sensitive data is externalized via config.properties and excluded using .gitignore.
Author
Yiğit Oğuz
