package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.Trello;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.NullException;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() throws NullException {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards().orElseThrow(NullException::new);
        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());

            System.out.println("This board contains lists: ");

            trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
        });
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        CreatedTrelloCard result = trelloClient.createTrelloCard(trelloCardDto);


            System.out.println("{\n" + "id: " + result.getId() + "\nbadges: {\n");
            System.out.println("Votes " + result.getBadges().getVotes() + result.getBadges().getAttachmentsByTypeDto());
            System.out.println("attachmentsByType: {\n");
        try {
            System.out.println("trello: {\n board: " + result.getBadges().getAttachmentsByTypeDto().getTrello().getBoard() + "\n card: " + result.getBadges().getAttachmentsByTypeDto().getTrello().getCard() ) ;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            Trello tempTrello = new Trello();
            System.out.println("trello: {\n board: " + tempTrello.getBoard() + "\n card: " + tempTrello.getCard() ) ;
        }
            return result;

    }
}