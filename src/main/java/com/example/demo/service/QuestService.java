package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.model.equipment.Inventory;
import com.example.demo.model.equipment.Item;
import com.example.demo.model.quests.Quest;
import com.example.demo.model.quests.Reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * QuestService
 */
@Service
public class QuestService {
    private final Map<String, Quest> quests = new HashMap<>();
    @Autowired
    private InventoryService inventoryService;

    public void addQuest(Quest quest) {
        quests.put(quest.getTitle(), quest);
    }

    public void acceptQuest(String title) {
        Quest quest = getQuestByTitle(title);
        if (quest == null) {
            throw new IllegalArgumentException("Quest not found.");
        }
        quest.obtainQuest();
    }

    public Quest getQuestByTitle(String title) {
        return quests.get(title);
    }

    public Reward completeQuest(String questTitle) {
        Quest quest = getQuestByTitle(questTitle);
        if (quest == null) {
            throw new IllegalArgumentException("Quest not found.");
        }

        Inventory<Item> inventory = inventoryService.getPlayerInventory();

        Reward reward = quest.completeQuest(inventory);

        if (reward.getItemReward() != null) {
            inventoryService.addItem(reward.getItemReward(), 1);
        }

        return reward;
    }
}
