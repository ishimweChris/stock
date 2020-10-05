package com.invetory.stock.controller;

import com.invetory.stock.domain.Product;
import com.invetory.stock.domain.Sales;
import com.invetory.stock.domain.Unity;
import com.invetory.stock.service.ProductService;
import com.invetory.stock.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value="",method = RequestMethod.GET)
    public ResponseEntity<Object> allProducts(HttpSession session, ModelMap model) {
        Map<String,Object> map=new HashMap<>();
        try{
            map.put("sales",salesService.findByDeleted());
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }
    @RequestMapping(value="create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody InnerSale sl, HttpSession session, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try{

            Product product=productService.findByUuid(sl.product);
            Sales sales=new Sales();
            if(sl.unit.equalsIgnoreCase("Box")){
                if(product.getQuantity()>=sl.quantity){
                    sales.setQuantity(sl.quantity);
                    sales.setProduct(product);
                    sales.setUnityPrice(sl.unitPrice);
                    sales.setSaleStatus(Unity.valueOf(sl.unit));
                    salesService.create(sales);

//                    Updating product
                    product.setQuantity(product.getQuantity()-sl.quantity);
                    productService.save(product);
                    map.put("code",200);
                    map.put("object",sales);
                    return new ResponseEntity<Object>(map, HttpStatus.OK);
                }else{
                    map.put("code",402);
                    map.put("msg","Not enough quantity");
                    return new ResponseEntity<Object>(map, HttpStatus.OK);
                }
            }else{
                if(sl.quantity>product.getItemInPackage()){
                    int boxround=(int)sl.quantity/product.getItemInPackage();
                    double box=boxround;
                    double item=sl.quantity-(product.getItemInPackage()*box);
                   if(product.getQuantity()>=box && (product.getItemNumber()>=item|| product.getQuantity()>=box+1)){
                     if(box>product.getQuantity()){
                         map.put("code",402);
                         map.put("msg","Not enough quantity");
                         return new ResponseEntity<Object>(map, HttpStatus.OK);
                     }else{
                         sales.setUnityPrice(sl.unitPrice);
                         sales.setProduct(product);
                         sales.setQuantity(sl.quantity);
                         sales.setSaleStatus(Unity.PIECES);
                         salesService.create(sales);
                         double boxLeft=product.getQuantity()-box;

////                       Update Product
                         if(product.getItemNumber()==0 && item>0){
                             boxLeft=boxLeft-1;
                             product.setItemNumber(product.getItemInPackage()-item);
                             product.setQuantity(boxLeft);
                         }else if(product.getItemNumber()<item){
                             System.out.println(item +" "+box+" "+(product.getItemInPackage()*box)+" "+sl.quantity);
                             boxLeft=boxLeft-1;
                             double reduceItem=item-product.getItemNumber();
                             product.setItemNumber(product.getItemInPackage()-reduceItem);
                             product.setQuantity(boxLeft);
                         }else{
                             boxLeft=boxLeft-1;
                             product.setItemNumber(product.getItemNumber()-item);
                             product.setQuantity(boxLeft);
                         }
                         productService.save(product);
                         map.put("code",200);
                         map.put("object",sales);
                         map.put("msg","Sale are made successfully");
                         return new ResponseEntity<Object>(map, HttpStatus.OK);
                     }

                   }else{
                       map.put("code",402);
                       map.put("msg","Not enough quantity");
                       return new ResponseEntity<Object>(map, HttpStatus.OK);
                   }
                }else if(sl.quantity==product.getItemInPackage()){
                    sales.setUnityPrice(sl.unitPrice);
                    sales.setProduct(product);
                    sales.setQuantity(sl.quantity);
                    sales.setSaleStatus(Unity.PIECES);
                    salesService.create(sales);
                    product.setQuantity(product.getQuantity()-1);
                    productService.save(product);
                    map.put("code",200);
                    map.put("object",sales);
                    return new ResponseEntity<Object>(map, HttpStatus.OK);
                }else{
                    sales.setUnityPrice(sl.unitPrice);
                    sales.setProduct(product);
                    sales.setQuantity(sl.quantity);
                    sales.setSaleStatus(Unity.PIECES);
                    salesService.create(sales);
                    double boxLeft=product.getQuantity();
                    if(product.getItemNumber()==0 && sl.quantity>0){
                        boxLeft=boxLeft-1;
                        product.setItemNumber(product.getItemInPackage()-sl.quantity);
                        product.setQuantity(boxLeft);
                    }else if(product.getItemNumber()<sl.quantity){
                        boxLeft=boxLeft-1;
                        double reduceItem=sl.quantity-product.getItemNumber();
                        product.setItemNumber(product.getItemInPackage()-reduceItem);
                        product.setQuantity(boxLeft);
                    }else{
                        product.setItemNumber(product.getItemNumber()-sl.quantity);
                    }
                    productService.save(product);

                    map.put("code",200);
                    map.put("object",sales);
                    return new ResponseEntity<Object>(map, HttpStatus.OK);
                }
            }


        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }

    }




    public static class InnerSale{
        private String product;
        private String unit;
        private double quantity;
        private double unitPrice;
        private double totalPrice;

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }
    }

}
