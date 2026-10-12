package com.example.demo.controller;

import com.example.demo.model.quests.Quest;
import com.example.demo.model.quests.Reward;
import com.example.demo.service.QuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quests")
public class QuestController {
    @Autowired
    private QuestService questService;

    @PostMapping
    public ResponseEntity<String> addQuest(@RequestBody Quest quest) {
        questService.addQuest(quest);

        return ResponseEntity.ok("Success! The quest '" + quest.getTitle() + "' was added.");
    }

    @PostMapping("/accept/{title}")
    public ResponseEntity<String> acceptQuest(@PathVariable String title) {
        questService.acceptQuest(title);

        return ResponseEntity.ok("Success! The quest '" + title + "' was accepted.");
    }

    @GetMapping("/{title}")
    public ResponseEntity<Quest> getQuestByTitle(@PathVariable String title) {
        Quest quest = questService.getQuestByTitle(title);
        if (quest == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(quest);
    }

    @PostMapping("/complete/{title}")
    public ResponseEntity<Reward> completeQuest(@PathVariable String title) {
        Reward reward = questService.completeQuest(title);

        return ResponseEntity.ok(reward);
    }
}
