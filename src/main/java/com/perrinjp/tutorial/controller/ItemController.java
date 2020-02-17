package com.perrinjp.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.perrinjp.tutorial.model.Item;
import com.perrinjp.tutorial.service.ItemService;

import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		String itemNane = fetchItems().get(0).getItemName();
		model.addAttribute("itemNane", itemNane);
		return "greeting";
	}
	

    @Autowired
    private ItemService itemService;
    
    private List<Item> fetchItems() {
    	List<Item> items = itemService.getItems();
    	return  items;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item> >getItems(){

        return new ResponseEntity<>(fetchItems(), HttpStatus.OK);
    }
    
    @GetMapping("/table")
    public String table(Model modelAtt) {
        List<Item> itemList = fetchItems();
        
        Map<Long,String> itemListMap = new HashMap<>();
        for (Item item : itemList) {
        	itemListMap.put(item.getId(),item.getItemName());
        }
        
        modelAtt.addAttribute("itemList", itemList);
        modelAtt.addAttribute("itemListMap1", itemListMap);
        
		return "table/table";
	}

}
