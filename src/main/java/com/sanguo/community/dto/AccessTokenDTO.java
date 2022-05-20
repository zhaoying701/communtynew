package com.sanguo.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDTO {

    private  String client_id;
    private  String redirect_uri;
    private  String client_secret;
    private  String code;
    private  String state;

}
