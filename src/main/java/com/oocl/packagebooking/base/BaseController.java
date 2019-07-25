package com.oocl.packagebooking.base;


import org.springframework.web.bind.annotation.*;

public class BaseController<T, ID>  {
    private BaseService<T, ID> baseService;

    public BaseController(BaseService<T, ID> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable ID id){
        T t = baseService.findById(id);
        return t;
    }

    @GetMapping
    public Object findAll() {
        return baseService.findAll();
    }

    @GetMapping(params = {"page","pageSize"})
    public Object findAll(@RequestParam(name = "page") int page, @RequestParam(name = "pageSize") int pageSize){
        return baseService.findAll(page - 1, pageSize);
    }

    @GetMapping(params = "page")
    public Object findAll(@RequestParam(name = "page") int page){
        return baseService.findAll(page - 1);
    }


    @PostMapping
    public T save(@RequestBody T t){
        baseService.save(t);
        return t;
    }

    @PostMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T t){
        T oldT = baseService.findById(id);
        baseService.update(t);
        return t;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) {
        T t = baseService.findById(id);
        baseService.delete(t);
    }
}