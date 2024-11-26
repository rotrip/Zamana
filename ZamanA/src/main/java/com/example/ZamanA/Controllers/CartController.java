package com.example.ZamanA.Controllers;

import com.example.ZamanA.Models.Cart;
import com.example.ZamanA.Models.User;
import com.example.ZamanA.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart){
        System.out.println(cart.toString());
        Cart addedToCart= cartService.addToCart(cart);
        return ResponseEntity.ok(addedToCart);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getCartItems(@RequestParam Long userId){
        List<Cart> cartItems=cartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);

    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable Long cartId){
        cartService.deleteCartItem(cartId);
        return ResponseEntity.ok("Cart Item Successfully Deleted");
    }



}
