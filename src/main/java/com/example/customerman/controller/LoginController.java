package com.example.customerman.controller;

import com.example.customerman.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("account")
public class LoginController {

    @ModelAttribute("account")
    public Account setUpAccountForm() {
        return new Account();
    }

    @GetMapping("/login")
    public String showLoginForm(@CookieValue(value = "savedUsername", defaultValue = "") String savedUsername, Model model) {
        model.addAttribute("cookieValue", savedUsername); // Chỉ cần thêm giá trị cookie vào model
        return "account/login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("account") Account account, Model model,
                          @CookieValue(value = "savedUsername", defaultValue = "") String savedUsername,
                          HttpServletResponse response) {

        // Kiểm tra thông tin đăng nhập
        if (account.getAccountEmail() != null && account.getAccountPassword() != null &&
                account.getAccountPassword().equals("123456")) {

            // Lưu tên người dùng vào cookie nếu đăng nhập thành công
            if (account.getAccountEmail() != null) {
                savedUsername = account.getAccountEmail();
            }

            // Tạo cookie và thiết lập nó trong phản hồi
            Cookie cookie = new Cookie("savedUsername", savedUsername);
            cookie.setMaxAge(24 * 60 * 60); // Cookie hết hạn sau 24 giờ
            cookie.setPath("/"); // Thiết lập đường dẫn cho cookie
            response.addCookie(cookie);

            model.addAttribute("message", "Login successful. Welcome!");
            model.addAttribute("account", account);
            return "account/mainPage";
        } else {
            model.addAttribute("message", "Login failed. Please try again.");
            return "account/login";
        }
    }



    @GetMapping("/logout")
    public String logout(HttpServletResponse response, SessionStatus sessionStatus) {

        // Hủy session bằng cách đánh dấu nó là hoàn thành
        sessionStatus.setComplete();

        // Xóa cookie savedUsername
        Cookie cookie = new Cookie("savedUsername", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/login";
    }

}