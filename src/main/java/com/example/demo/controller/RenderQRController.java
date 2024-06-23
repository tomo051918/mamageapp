package com.example.demo.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.QRCodeService;

@Controller
public class RenderQRController {
	
	@Autowired
    private QRCodeService qrCodeService;
	
	@GetMapping("/renderqr")
	public String getQRCode(Model model) throws Exception {
        String url = "http://localhost:8080/"; // QRコードに含めるURL
        int width = 200; // QRコードの幅
        int height = 200; // QRコードの高さ

        byte[] qrCodeImage = qrCodeService.generateQRCode(url, width, height);

        String qrCodeBase64 = Base64.getEncoder().encodeToString(qrCodeImage);
        model.addAttribute("qrCodeBase64", qrCodeBase64);

        return "renderqr";
    }

}
