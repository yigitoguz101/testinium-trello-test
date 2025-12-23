package org.example.service;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TrelloService {

    private final String apiKey;
    private final String token;

    public TrelloService(String apiKey, String token) {
        this.apiKey = apiKey;
        this.token = token;
    }

    public String createBoard(String name) {
        return given()
                .queryParam("name", name)
                .queryParam("key", apiKey)
                .queryParam("token", token)
                .when()
                .post("/boards")
                .then()
                .statusCode(200)
                .extract().path("id");
    }

    public String getFirstListId(String boardId) {
        return given()
                .queryParam("key", apiKey)
                .queryParam("token", token)
                .when()
                .get("/boards/" + boardId + "/lists")
                .then()
                .statusCode(200)
                .extract().path("[0].id");
    }

    public String createCard(String listId, String cardName) {
        return given()
                .queryParam("name", cardName)
                .queryParam("idList", listId)
                .queryParam("key", apiKey)
                .queryParam("token", token)
                .when()
                .post("/cards")
                .then()
                .statusCode(200)
                .extract().path("id");
    }

    public void updateCard(String cardId, String newName) {
        given()
                .queryParam("name", newName)
                .queryParam("key", apiKey)
                .queryParam("token", token)
                .when()
                .put("/cards/" + cardId)
                .then()
                .statusCode(200);
    }

    public void deleteCard(String cardId) {
        given()
                .queryParam("key", apiKey)
                .queryParam("token", token)
                .when()
                .delete("/cards/" + cardId)
                .then()
                .statusCode(200);
    }

    public void deleteBoard(String boardId) {
        given()
                .queryParam("key", apiKey)
                .queryParam("token", token)
                .when()
                .delete("/boards/" + boardId)
                .then()
                .statusCode(200);
    }
}