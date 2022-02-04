package ghebrat.bes.theresFoodAtHome.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
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

    @GetMapping("/{itemId}")
    public Optional<Item> getItemById(@PathVariable("itemId") Long itemId){
        return itemService.showItem(itemId);
    }

    @PostMapping
    public void addNewItem(@RequestBody Item item) throws ItemNotFoundException {
        itemService.createItem(item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable ("itemId") Long itemId) throws ItemNotFoundException {
        itemService.deleteItem(itemId);
    }

    @PutMapping("/{itemId}")
    public void updateItem(@PathVariable ("itemId") Long itemId,
                           @RequestParam(required = false) String name, //will be var name for param
                           @RequestParam(required = false) String type,
                           @RequestParam(required = false) String location) throws ItemNotFoundException {
        itemService.updateItem(itemId, name, type, location);

    }


}
