package mateus.CRUD.controller;

import jakarta.validation.Valid;
import mateus.CRUD.model.entity.Manga;
import mateus.CRUD.model.repository.MangaRepository;
import mateus.CRUD.model.repository.MangaSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/manga")
public class MangaControler {
    @Autowired
    private MangaRepository mr;
    @Autowired
    private MangaSortingRepository msr;
    //CREATE & UPDATE
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public @Valid Manga newManga(@Valid Manga manga){
        mr.save(manga);
        return manga;
    }
    //READ
    @GetMapping("/title/{title}")
    @ResponseBody
    public Iterable<Manga> getMangaByNome(@PathVariable String title){
        return msr.findByTitleContaining(title);
    }
    @GetMapping("/author/{author}")
    @ResponseBody
    public Iterable<Manga> getMangaByAuthor(@PathVariable String author){
        return msr.findByAuthorContaining(author);
    }
    @GetMapping("/priceLess/{price}")
    @ResponseBody
    public Iterable<Manga> getMangaPriceLessThan(@PathVariable double price){
        return msr.findPriceLessThan(price);
    }
    @GetMapping("/oneshot")
    @ResponseBody
    public Iterable<Manga> getOneShotManga(){
        return msr.findAllOneShotManga();
    }
    //DELETE
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteById(@RequestParam(name = "id") int id){
        mr.deleteById(id);
    }
}
