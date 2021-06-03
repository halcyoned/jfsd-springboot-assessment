package org.generation.SpringBootAssessment.Service;

import org.generation.SpringBootAssessment.repository.Entity.Item;
import org.generation.SpringBootAssessment.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void delete(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> all() {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(result :: add);
        return result;
    }

    @Override
    public Item findById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.get();
    }

}
