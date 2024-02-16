package pack;

//import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import pack.Producer;

@RestController
//@RequiredArgsConstructor
public class Controller {
    private static final PetModel petmodel=PetModel.getInstance();
    private static final AtomicInteger newID= new AtomicInteger(1);
    private final Producer producer;

    public Controller( Producer producer) {
        this.producer = producer;
    }

//    public Controller(Producer producer) {
//        this.producer = producer;
//    }
  //consumer.listen(record);

    @PostMapping(value = "/createPet",consumes = "application/json",produces = "text/html")
    public String createPet(@RequestBody Pet pet) //чтобы pack.Pet pet воспринимали как json надо прописать аннотацию @RequestBody
    {
        petmodel.add(pet, newID.getAndIncrement());
        String name=pet.getName();
        String pt="Вы создали питомца, у которого имя ";
        producer.sendPet(pt+name);

        System.out.println(pt+name);
        return pt;

    }

    @GetMapping(value = "/getAll",produces = "application/json")
    public Map<Integer,Pet> getAll()
    {
        return petmodel.getAll();
    }

    //если писать id  в body
    /*@GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public pack.Pet getPet(@RequestBody Map<String,Integer> id)
    {
        return petmodel.petGetFromList(id.get("id"));

    }*/

    //если писать id в строке
    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestParam("id") int id)
    {
        //ArrayList<String>= (petmodel.petGetFromList(id)).getName();
        Pet pet=petmodel.petGetFromList(id);
        String name=pet.getName();
        producer.sendPet("Вы посмотрели питомца с id = "+String.valueOf(id)+", у которого имя "+name);
        return petmodel.petGetFromList(id);

    }

    //если писать id  в body
    /*@DeleteMapping(value = "/delPet",consumes = "application/json")
    public void delPet(@RequestBody Map<String,Integer> id)
    {
        int newid=id.get("id");
         petmodel.delete(newid);

    }*/
    //если писать id в строке
    @DeleteMapping(value = "/delPet",consumes = "application/json")
    public void delPet(@RequestParam("id") int id)
    {
        Pet pet=petmodel.petGetFromList(id);
        String name=pet.getName();
        producer.sendPet("Вы удалили питомца с id = "+String.valueOf(id)+", у которого имя "+name);
        petmodel.delete(id);
    }

    @PutMapping(value = "/updPet/{id}",consumes = "application/json")
    public void updPet(@RequestBody Pet pet, @PathVariable("id") int id)
    {
        Pet petLast=petmodel.petGetFromList(id);
        String nameLast=petLast.getName();
        petmodel.add(pet, id);
        String name=pet.getName();
        producer.sendPet("Вы изменили питомца с id = "+String.valueOf(id)+", у которого было имя "+nameLast);

    }

}
