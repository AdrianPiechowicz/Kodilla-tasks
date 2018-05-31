package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.Trello;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.NullException;
import com.crud.tasks.trello.client.TrelloClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloClient.class);

    @Autowired
    private TrelloService trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

        return trelloService.fetchTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        //CreatedTrelloCard result = trelloService.createdTrelloCard(trelloCardDto);
        return trelloService.createdTrelloCard(trelloCardDto);

        /*    System.out.println("{\n" + "id: " + result.getId() + "\nbadges: {\n");
            System.out.println("Votes " + result.getBadges().getVotes() + result.getBadges().getAttachmentsByTypeDto());
            System.out.println("attachmentsByType: {\n");
        try {
            System.out.println("trello: {\n board: " + result.getBadges().getAttachmentsByTypeDto().getTrello().getBoard() + "\n card: " + result.getBadges().getAttachmentsByTypeDto().getTrello().getCard() ) ;
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage(),e);
            Trello tempTrello = new Trello();
            System.out.println("trello: {\n board: " + tempTrello.getBoard() + "\n card: " + tempTrello.getCard() ) ;
        }
            return result;
         */
    }
}