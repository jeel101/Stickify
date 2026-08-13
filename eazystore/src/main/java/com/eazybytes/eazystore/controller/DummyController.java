package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.dto.UserDto;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/dummy")
@Validated
public class DummyController {
    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDto userDto) {
        return "user created!";
    }
    @GetMapping("/search")
    public String searchUser(@Size(min=2, max=30) @RequestParam(required = false, name="name") String userName) {
        return "Searching for user " + userName;
    }
    @GetMapping("/multiple-search")
    public String multipleSearchUser(@RequestParam() Map<String, String> params) {
        return "Searching for user " + params.get("firstName") + " " + params.get("lastName");
    }
    @GetMapping({"/user/{userId}/post/{postId}", "/user/{userId}"})
    public String getUser(@PathVariable(name = "userId") String id, @PathVariable(required = false) String postId) {
        return "Searching for user " + id + " and post Id is " + postId;
    }
    @GetMapping({"/user/map/{userId}/post/{postId}", "/user/map/{userId}"})
    public String getUserBymap(@PathVariable Map<String, String> m) {
        return "Searching for user " + m.get("userId") + " and post Id is " + m.get("postId");
    }
//    @GetMapping({"/headers"})
//    public String readHeaders(@RequestHeader(name="User-Agent") String value, @RequestHeader(required = false) String userLoc) {
//        return "Received header with value  " + value + " user location is " + userLoc;
//    }
//    @GetMapping({"/headers"})
//    public String readHeaders(@RequestHeader Map<String, String> m) {
//        return "Searching for user " + m.toString();
//    }
    @GetMapping({"/headers"})
    public String readHeaders(@RequestHeader HttpHeaders header) {
        List<String> loc = header.get("userLoc");
        return "Searching for user " + header.toString();
    }
//    isn't recommended to use RequestEntity to read query param and path variable
    @PostMapping("/request-entity")
    public String createWithUserEntity(RequestEntity<UserDto> requestEntity) {
        HttpHeaders h = requestEntity.getHeaders();
        UserDto u = requestEntity.getBody();
        String s = requestEntity.getUrl().getQuery();
        return "user created!";
    }
}
