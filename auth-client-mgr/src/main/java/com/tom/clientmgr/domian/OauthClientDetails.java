package com.tom.clientmgr.domian;

import javax.persistence.*;

@Entity
@Table(name = "oauth_client_details")
public class OauthClientDetails {
    @Id
    @Column(nullable = false)
    private String client_id;
    private String resource_ids;
    private String client_secret;
    private String scope;
    private String authorized_grant_types;
    private String web_server_redirect_uri;
    private String authorities;
    private Integer access_token_validity;
    private Integer refresh_token_validity;
    private String additional_information;
    private String autoapprove;

    public OauthClientDetails() {
    }

    public OauthClientDetails(String client_id, String resource_ids, String client_secret, String scope, String authorized_grant_types, String web_server_redirect_uri, String authorities, Integer access_token_validity, Integer refresh_token_validity, String additional_information, String autoapprove) {
        this.client_id = client_id;
        this.resource_ids = resource_ids;
        this.client_secret = client_secret;
        this.scope = scope;
        this.authorized_grant_types = authorized_grant_types;
        this.web_server_redirect_uri = web_server_redirect_uri;
        this.authorities = authorities;
        this.access_token_validity = access_token_validity;
        this.refresh_token_validity = refresh_token_validity;
        this.additional_information = additional_information;
        this.autoapprove = autoapprove;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getResource_ids() {
        return resource_ids;
    }

    public void setResource_ids(String resource_ids) {
        this.resource_ids = resource_ids;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorized_grant_types() {
        return authorized_grant_types;
    }

    public void setAuthorized_grant_types(String authorized_grant_types) {
        this.authorized_grant_types = authorized_grant_types;
    }

    public String getWeb_server_redirect_uri() {
        return web_server_redirect_uri;
    }

    public void setWeb_server_redirect_uri(String web_server_redirect_uri) {
        this.web_server_redirect_uri = web_server_redirect_uri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccess_token_validity() {
        return access_token_validity;
    }

    public void setAccess_token_validity(Integer access_token_validity) {
        this.access_token_validity = access_token_validity;
    }

    public Integer getRefresh_token_validity() {
        return refresh_token_validity;
    }

    public void setRefresh_token_validity(Integer refresh_token_validity) {
        this.refresh_token_validity = refresh_token_validity;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}
