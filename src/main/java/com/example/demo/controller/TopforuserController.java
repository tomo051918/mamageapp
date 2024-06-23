package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ShopownerService;
import com.example.demo.service.WaitingmanageService;

import jakarta.servlet.http.HttpServletResponse;
@Controller
public class TopforuserController {
	@Autowired
    ShopownerService ShopownerService;
	@Autowired
    WaitingmanageService WaitingmanageService;
	
	@GetMapping("/topforuser")
	public String index(@CookieValue(name = "maxWaitingNumberBycookie", required = false) Integer maxWaitingNumberBycookie, Model model, HttpServletResponse response) {
	    Integer targetShopId = 1; // 対象のショップID
	    Integer maxWaitingNumber;
	    Integer countWaitingNumber;

	    if (maxWaitingNumberBycookie != null) {
	    	// クッキーがあればクッキーに保存してる番号を使用する
	    	// ※何度も来店するようなユーザーに関してはどうするか。QRコードを読み取った際にワンクッション挟んで、QRコードからの遷移の場合は新番号を発番させるか。
	        maxWaitingNumber = maxWaitingNumberBycookie;
	        countWaitingNumber =  WaitingmanageService.findCountWaitingNumber(targetShopId, maxWaitingNumber);
	    } else {
	        maxWaitingNumber = WaitingmanageService.findMaxWaitingNumberByShopId(targetShopId);
	        countWaitingNumber = WaitingmanageService.findCountWaitingNumber(targetShopId, maxWaitingNumber);

	        ResponseCookie cookie = ResponseCookie.from("maxWaitingNumberBycookie", String.valueOf(maxWaitingNumber))
	                .path("/")
	                .maxAge(24 * 60 * 60) // クッキーの有効期限を24時間に設定
	                .build();
	        response.addHeader("Set-Cookie", cookie.toString());
	    }

	    model.addAttribute("maxWaitingNumber", maxWaitingNumber);
	    model.addAttribute("countWaitingNumber", countWaitingNumber);

	    return "index";
	}
}