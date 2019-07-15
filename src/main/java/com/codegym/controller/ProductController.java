package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

@Controller
public class ProductController {

    public final String UPLOAD_DIR ="E:\\TuLuyen\\product-jpa\\src\\main\\webapp\\static\\image\\";
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public ModelAndView showAllProduct(){
        ModelAndView modelAndView = new ModelAndView("/list");
        Iterable<Product> productIterable = productService.findAll();
        modelAndView.addObject("products", productIterable);
        return modelAndView;
    }

    @GetMapping("/create-new")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    //upload file
    @PostMapping("/create")
    public ModelAndView createProduct(@ModelAttribute ProductForm productForm){
        ModelAndView modelAndView = new ModelAndView("/create");
        MultipartFile file = productForm.getImage();
        String fileName = file.getOriginalFilename();
        String path = UPLOAD_DIR + fileName;
        try {
            saveFile(file.getInputStream(),path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Product product1 = new Product(productForm.getId(), productForm.getName(),productForm.getPrice(),productForm.getProducer(),fileName);
        productService.save(product1);
        modelAndView.addObject("message", "Create Success");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        Product productFind = productService.findById(id);
        ProductForm productForm = new ProductForm(productFind.getId(), productFind.getName(), productFind.getPrice(), productFind.getProducer(), null);
        modelAndView.addObject("product",productFind);
        modelAndView.addObject("productForm", productForm);
        return modelAndView;
    }
    @PostMapping("/edit-product")
    public ModelAndView editProduct(@ModelAttribute ProductForm productForm){
        ModelAndView modelAndView = new ModelAndView("/edit");
        MultipartFile file = productForm.getImage();
        String fileName = file.getOriginalFilename();
        String path = UPLOAD_DIR + fileName;
        try {
            saveFile(file.getInputStream(),path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Product product1 = new Product(productForm.getId(), productForm.getName(),productForm.getPrice(),productForm.getProducer(), fileName);
        productService.save(product1);
        modelAndView.addObject("message", "Edit Success");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        Product product = productService.findById(id);

        ProductForm productForm = new ProductForm(product.getId(), product.getName(), product.getPrice(), product.getProducer(), null);
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/delete/delete-product")
    public ModelAndView deleteProduct(@ModelAttribute ProductForm productForm){
        ModelAndView modelAndView = new ModelAndView("/delete");
        MultipartFile file = productForm.getImage();
        String fileName = file.getOriginalFilename();
        String path = UPLOAD_DIR + fileName;
        try {
            saveFile(file.getInputStream(),path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Product product1 = new Product(productForm.getId(), productForm.getName(),productForm.getPrice(),productForm.getProducer(), fileName);
        productService.remove(product1.getId());
        modelAndView.addObject("message", "Delete Success");
        return modelAndView;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;

    }
    private void saveFile(InputStream inputStream, String path) {
        try {
            OutputStream outputStream = new FileOutputStream(new File(path));
            byte[] bytes = new byte[1024];
            int read =0;
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,read);
            }
            outputStream.flush();
            outputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
