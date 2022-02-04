package ghebrat.bes.theresFoodAtHome.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo){
        this.itemRepo = itemRepo;
    }

    public List<Item> showItems(){
        return itemRepo.findAll();
    }

    public Optional<Item> showItem(Long itemId) {
        return itemRepo.findById(itemId);
    }

    public void createItem(Item item) throws ItemNotFoundException {
        if(itemRepo.findByName(item.getName()).isPresent()){
            throw new ItemNotFoundException("item already added");
        }
        itemRepo.save(item);
    }

    public void deleteItem(Long itemId) throws  ItemNotFoundException{
        if(!itemRepo.existsById(itemId)){
            throw new ItemNotFoundException("Item with id: " + itemId + "doesn't even exist");
        }
        itemRepo.deleteById(itemId);
    }

    @Transactional
    public void updateItem(Long itemId,
                           String name, String itemType,
                           String itemLocation)
            throws ItemNotFoundException {
        Item item = itemRepo.findById(itemId).orElseThrow(() -> new ItemNotFoundException("Item with ID: " + itemId + "doesn't even exist"));

        if (name !=null && name.length()>0
                && !Objects.equals(item.getName(), name)){
            Optional<Item> itemOptional = itemRepo.findByName(name);
            if(itemOptional.isPresent()){
                throw new ItemNotFoundException("Item already exists");
            }
            item.setName(name);
        }

        if(itemType !=null
                && itemType.length()>0
                && !Objects.equals(item.getItemType(), itemType)){
            item.setItemType(itemType);
        }

        if(itemLocation !=null && itemLocation.length()>0
        && !Objects.equals(item.getLocation(), itemLocation)){
            item.setLocation(itemLocation);
        }
    }


}
