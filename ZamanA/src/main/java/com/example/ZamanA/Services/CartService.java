package com.example.ZamanA.Services;

import com.example.ZamanA.Models.Cart;
import com.example.ZamanA.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);

    }

    public void deleteCartItem(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
