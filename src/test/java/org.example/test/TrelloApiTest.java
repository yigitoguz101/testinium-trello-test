package org.example.test;

import org.example.base.BaseTest;
import org.example.service.TrelloService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TrelloApiTest extends BaseTest {

    @Test
    void trelloEndToEndScenario() {

        TrelloService trelloService =
                new TrelloService(API_KEY, TOKEN);
        System.out.println("Trello service initialized with API key and token");

        // 1-Creating Board
        String boardId = trelloService.createBoard("Testinium_Board");
        assertNotNull(boardId, "Board ID should not be null");
        System.out.println("Board created successfully. Board ID: " + boardId);

        // 2-Get Board List ID
        String listId = trelloService.getFirstListId(boardId);
        assertNotNull(listId, "List ID should not be null");
        System.out.println("Default list retrieved successfully. List ID: " + listId);

        // 3-Create 2 Card
        String cardId1 = trelloService.createCard(listId, "Card_One");
        System.out.println("First card created. Card ID: " + cardId1);

        String cardId2 = trelloService.createCard(listId, "Card_Two");
        System.out.println("Second card created. Card ID: " + cardId2);
        assertAll(
                () -> assertNotNull(cardId1),
                () -> assertNotNull(cardId2)
        );

        // 4-Pick Random Card
        List<String> cards = List.of(cardId1, cardId2);
        String randomCard =
                cards.get(new Random().nextInt(cards.size()));
        assertTrue(cards.contains(randomCard));
        System.out.println("Random card selected for update. Card ID: " + randomCard);

        // 5-Update picked Card
        trelloService.updateCard(randomCard, "Updated_Card");
        System.out.println("Random card updated successfully. New name: Updated_Card");

        // 6-Delete Cards
        trelloService.deleteCard(cardId1);
        System.out.println("First card deleted successfully. Card ID: " + cardId1);

        trelloService.deleteCard(cardId2);
        System.out.println("Second card deleted successfully. Card ID: " + cardId2);
        // 7-Delete Board
        trelloService.deleteBoard(boardId);
        System.out.println("Board deleted successfully. Board ID: " + boardId);

        System.out.println("=== Trello API Test Finished Successfully ===");
    }
}