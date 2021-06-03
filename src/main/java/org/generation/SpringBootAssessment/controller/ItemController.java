package org.generation.SpringBootAssessment.controller;

import org.generation.SpringBootAssessment.Service.ItemService;
import org.generation.SpringBootAssessment.controller.dto.ItemDTO;
import org.generation.SpringBootAssessment.repository.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/item")
public class ItemController {

    final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems() {
        return itemService.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    public Item save(@RequestParam(name = "title", required = true) String title,
                     @RequestParam(name = "description", required = true) String description,
                     @RequestParam(name = "date", required = true) String date) {

        ItemDTO itemDTO = new ItemDTO(title, description, date);
        Item item = new Item(itemDTO);
        System.out.println(item);
        return itemService.save(item);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Item update(@PathVariable Integer id, @RequestBody ItemDTO itemDTO) {
        Item item = itemService.findById(id);
        item.setTitle(itemDTO.getTitle());
        item.setDescription(itemDTO.getDescription());
        item.setDate(itemDTO.getDate());
        return itemService.save(item);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }
}
