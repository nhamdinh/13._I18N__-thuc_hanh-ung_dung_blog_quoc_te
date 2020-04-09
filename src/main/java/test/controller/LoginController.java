package test.controller;

import test.model.Account;
import test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/home")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("/index", "account", new Account());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute("account") Account account) {
        Iterable<Account> accounts = accountService.findAll();
        for (Account a : accounts) {
            if (a.getUsername().equals(account.getUsername()) && a.getPassword().equals(account.getPassword())) {
                ModelAndView modelAndView = new ModelAndView("/success", "account", account);
                return modelAndView;
            }
        }
        ModelAndView modelAndView = new ModelAndView("/index", "account", account);
        return modelAndView;
    }
}
