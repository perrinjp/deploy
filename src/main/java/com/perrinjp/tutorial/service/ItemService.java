package com.perrinjp.tutorial.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perrinjp.tutorial.model.Item;
import com.perrinjp.tutorial.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAllItems();
    }
}
