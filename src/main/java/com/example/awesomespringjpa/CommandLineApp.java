package com.example.awesomespringjpa;

import com.example.awesomespringjpa.models.*;
import com.example.awesomespringjpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class CommandLineApp implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public void run(String... args) throws Exception {
        //oneToOneExample();
        oneToManyExample();
        //manyToManyExample();
        //deleteExample();
    }

    private void deleteExample() {
        this.cartRepository.deleteById(1);
    }

    private void manyToManyExample() {
        Channel channel1 = new Channel();
        channel1.setName("ch1");
        channel1.setUrl("url1");
        Channel channel2 = new Channel();
        channel2.setName("ch2");
        channel2.setUrl("url2");


        Subscriber subscriber1 = new Subscriber();
        subscriber1.setUsername("user1");
        Subscriber subscriber2 = new Subscriber();
        subscriber2.setUsername("user2");

        channel1.setSubscribers(List.of(subscriber1, subscriber2));
        this.subscriberRepository.saveAll(List.of(subscriber1,subscriber2));
        this.channelRepository.saveAll(List.of(channel1, channel2));

        List<Channel> channels = this.channelRepository.findAll();
        List<Subscriber> subscribers = this.subscriberRepository.findAll();

        System.out.println(subscribers);
        System.out.println(channels);
    }

    private void oneToManyExample() {
        Cart cart = new Cart();
        cart.setUserId(5);

        this.cartRepository.save(cart);

        CartItem cartItem1 = new CartItem();
        cartItem1.setCart(cart);
        cartItem1.setProductCode("code1");
        cartItem1.setQuantity(2);
        cartItem1.setUnitPrice(BigDecimal.valueOf(24.5));

        CartItem cartItem2 = new CartItem();
        cartItem2.setCart(cart);
        cartItem2.setProductCode("code2");
        cartItem2.setQuantity(5);
        cartItem2.setUnitPrice(BigDecimal.valueOf(124.5));

        this.cartItemRepository.save(cartItem1);
        this.cartItemRepository.save(cartItem2);

//        List<Cart> carts = this.cartRepository.findAll();
        List<Cart> carts = this.cartRepository.findByUserId(5);
        List<CartItem> cartItems = this.cartItemRepository.findAll();

        System.out.println(carts.get(0).getCartItems());
        System.out.println(cartItems.get(0).getCart());
    }

    private void oneToOneExample() {
        Person person = Person.builder()
                .name("mert")
                .surname("simsek")
                .build();
        Passport passport = Passport.builder()
                .expireDate(Instant.now().plus(10, ChronoUnit.DAYS).getEpochSecond())
                .person(person)
                .build();
        this.passportRepository.save(passport);
        System.out.println(passport);
    }
}
