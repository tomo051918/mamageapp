package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Waitingmanage;
import com.example.demo.service.WaitingmanageService;

@Controller
public class ManageController {

    @Autowired
    WaitingmanageService waitingmanageService;

    @GetMapping("/manage")
    public String showAdminPage(Model model) {
        Integer shopId = 1; // 対象のショップIDを設定
        List<Waitingmanage> waitingManageList = waitingmanageService.findByStatusIsNotAndShopIdOrderByWaitingNumberAsc(shopId);
        model.addAttribute("waitingManageList", waitingManageList);
        return "manage";
    }

    @PostMapping("/manage/call")
    public String callCustomer(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        waitingmanageService.updateStatus(id, status); // ステータスを変更
        return "redirect:/manage";
    }

    @PostMapping("/manage/arrived")
    public String arrivedCustomer(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        waitingmanageService.updateStatus(id, status); // ステータスを変更
        return "redirect:/manage";
    }

    @PostMapping("/manage/cancel")
    public String cancelCustomer(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        waitingmanageService.updateStatus(id, status); // ステータスを変更
        return "redirect:/manage";
    }
}
