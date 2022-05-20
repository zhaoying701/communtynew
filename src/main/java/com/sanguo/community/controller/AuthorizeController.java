package com.sanguo.community.controller;


import com.sanguo.community.dto.AccessTokenDTO;
import com.sanguo.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("callback")
    public  String  callback(
            @RequestParam(name="code") String code,
            @RequestParam(name="state")String state
    ){
        AccessTokenDTO accessTokenDto = new AccessTokenDTO();
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setRedirect_uri(redirectUri);
        accessTokenDto.setClient_secret(clientSecret);
        githubProvider.getAccessToken(accessTokenDto);
        return "index";
    }



}
