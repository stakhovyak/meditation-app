package com.weuoimi.user_service.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.weuoimi.user_service.entity.User;
import  com.weuoimi.user_service.services.ResourcesService;
import java.util.Map;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/resources")
@RequiredArgsConstructor
public class ResourcesController {

    private final ResourcesService resourcesService;

    @GetMapping("/profiles")
    public ResponseEntity<Page<User>> getProfiles(@RequestParam Map<String, Object> params, Pageable pageable) {
        
        try {

            return ResponseEntity.ok(resourcesService.getProfile(params, pageable));
        } catch (IllegalArgumentException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
}
