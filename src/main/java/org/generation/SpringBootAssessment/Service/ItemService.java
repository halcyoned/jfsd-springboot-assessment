package org.generation.SpringBootAssessment.Service;

import org.generation.SpringBootAssessment.repository.Entity.Item;

import java.util.List;

public interface ItemService {

    Item save(Item item);

    void delete(int idItem);

    List<Item> all();

    Item findById(int idItem);

}
