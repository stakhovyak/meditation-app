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
import com.weuoimi.user_service.services.ResourcesService;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class ResourcesController {


    // TODO: implement pagination serialization
    private final ResourcesService resourcesService;
    /* private final UserModelAssembler userModelAssembler;
    private final PagedResourcesAssembler<User> pagedResourcesAssembler; */

    @GetMapping
    public ResponseEntity<Page<User>> getProfiles(@RequestParam Map<String, Object> params, Pageable pageable) { 

        log.debug("invoking getProfile in the ResourcesController");
        try {

            /* Page<User> userPage = resourcesService.getProfile(params, pageable);
            PagedModel<EntityModel<User>> pagedModel = pagedResourcesAssembler.toModel(userPage, userModelAssembler); */

            return ResponseEntity.ok(/* pagedModel */resourcesService.getProfile(params, pageable));
        } catch (IllegalArgumentException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
}
