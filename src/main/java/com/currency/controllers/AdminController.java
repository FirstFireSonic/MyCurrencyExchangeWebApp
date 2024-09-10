package com.currency.controllers;

import com.currency.dto.UserDTO;
import com.currency.models.Currency;
import com.currency.models.User;
import com.currency.services.CurrencyService;
import com.currency.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final CurrencyService currencyService;

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getAllUsers(@PathVariable String username) {
        var user = userService.getUser(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all-users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        var users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete-user/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {

        if (username == null || username.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        userService.deleteUserByUsername(username);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCurrency(@RequestParam(value = "code", required = false) String code) {

        if (code == null || code.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        currencyService.deleteCurrencyByCode(code);

        return ResponseEntity.noContent().build();

    }

    @PostMapping("/add")
    public ResponseEntity<Currency> addNewCurrency(
            @RequestParam("name") String name,
            @RequestParam("code") String code,
            @RequestParam("sign") String sign) {

        if (name == null || name.isEmpty() || code == null || code.isEmpty() || sign == null || sign.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Currency savedCurrency = currencyService.addCurrency(
                Currency.builder()
                        .code(code)
                        .fullName(name)
                        .sign(sign)
                        .build()
        );

        return ResponseEntity.ok(savedCurrency);

    }

}
