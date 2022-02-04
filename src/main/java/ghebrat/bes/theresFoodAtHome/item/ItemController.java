package ghebrat.bes.theresFoodAtHome.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems(){
        return itemService.showItems();
    }

    @PostMapping
    public void addNewItem(@RequestBody Item item) throws ItemNotFoundException {
        itemService.createItem(item);
    }

    @DeleteMapping()
    public void deleteItem(Long itemId){

    }


}
